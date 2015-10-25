package coded.by.jin.walletmanager;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class AddTransactionActivity extends AppCompatActivity implements View.OnClickListener {
    private RadioGroup radioGroup;
    private RadioButton radio_depostis;
    private RadioButton radio_withdraws;
    private Button btnSave;
    private String type = "";
    private EditText txtDate;
    private EditText txtAmount;
    private DatePickerDialog datePicker;
    private SimpleDateFormat dateFormatter;
    private Spinner categorySpinner;
    private ArrayAdapter<String> categoryAdapter;
    private FileOutputStream outputStream;
    private final String filename = "file.txt";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_transaction);
        dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.CANADA);
        type = "Deposit";
        findViewById();
        setDateTimeField();
        radioButtonListener();
        setSpinner();
        saveButtonListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_add_transaction, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
     public void onClick(View view) {
        if (view == txtDate) {
            datePicker.show();
        }
    }
    public void findViewById() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radio_depostis = (RadioButton) findViewById(R.id.radio_deposit);
        radio_withdraws = (RadioButton) findViewById(R.id.radio_spent);
        txtDate = (EditText) findViewById(R.id.txt_date);
        txtDate.setInputType(InputType.TYPE_NULL);
        txtDate.requestFocus();
        txtAmount = (EditText) findViewById(R.id.txt_amount);
        categorySpinner = (Spinner)findViewById(R.id.spinner_category);
    }

    public void radioButtonListener() {
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.check(radio_depostis.getId());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (radio_depostis.isChecked()) {
                    type = "Deposit";
                } else if (radio_withdraws.isChecked()) {
                    type = "Withdraws";
                }
            }
        });
    }

    private void setDateTimeField() {
        txtDate.setOnClickListener(this);
        Calendar newCalendar = Calendar.getInstance();
        datePicker = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                txtDate.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
    }

    // Spinner
    private void setSpinner(){
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.categories, android.R.layout.simple_spinner_dropdown_item);
        categorySpinner.setAdapter(adapter);
    }

    // Save file
    private void saveFile(){
        try{
            outputStream = openFileOutput(filename, Context.MODE_APPEND);
            // format
            // date;type;category;amount
            String record = (txtDate.getText().toString() + ";" +
                    type + ";" +
                    categorySpinner.getSelectedItem().toString() + ";" +
                    txtAmount.getText().toString()+";\n");

            outputStream.write(record.getBytes());
            outputStream.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    // Save button
    private void saveButtonListener(){
        final Context context = this;
        btnSave = (Button)findViewById(R.id.btn_save);
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (dataGood()) {
                    saveFile();
                    Toast.makeText(getApplicationContext(), "Record saved!", Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(context, HomeActivity.class);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(), "Empty field found", Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    private boolean dataGood(){
        if(txtDate.getText().toString().equals("") || txtAmount.getText().toString().equals((""))){
            return false;
        }
        return true;
    }
}
