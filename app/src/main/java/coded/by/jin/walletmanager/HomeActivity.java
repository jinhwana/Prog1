package coded.by.jin.walletmanager;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity {

    // Attributes
    private final Button btn_newTransaction = (Button)findViewById(R.id.btn_newTransaction);
    private final Button btn_viewTransactions = (Button)findViewById(R.id.btn_viewTransactions);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        newTransactionButtonListener();
        viewTransactionsButtonListener();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
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

    public void newTransactionButtonListener(){
        final Context context = this;
        btn_newTransaction.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, AddTransactionActivity.class);
                startActivity(intent);
            }
        });
    }

    public void viewTransactionsButtonListener(){
        final Context context = this;
        btn_viewTransactions.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(context, ViewTransactionsActivity.class);
                startActivity(intent);
            }
        });
    }
}
