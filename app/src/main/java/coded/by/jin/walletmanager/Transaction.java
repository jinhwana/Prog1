package coded.by.jin.walletmanager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by JinHwan Oh on 2015-10-19.
 */
public class Transaction {
    private UUID id;
    private String date;
    private String type;
    private String category;
    private double amount;
    private String description;

    private static final String JSON_ID = "id";
    private static final String JSON_DATE = "date";
    private static final String JSON_TYPE = "type";
    private static final String JSON_CATEGORY = "category";
    private static final String JSON_AMOUNT = "amount";
    private static final String JSON_DESCRIPTION= "description";

    // Constructor
    public Transaction(){
        id = UUID.randomUUID();
    }

    public Transaction(JSONObject json) throws JSONException{
        this.id = UUID.fromString(json.getString(JSON_ID));
        this.date = json.getString(JSON_DATE);
        this.type = json.getString(JSON_TYPE);
        this.category = json.getString(JSON_CATEGORY);
        this.amount = json.getDouble(JSON_AMOUNT);
        this.description = json.getString(JSON_DESCRIPTION);
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public String getType() {
        return type;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // Setters
    public void setDate(String date) {
        this.date = date;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // toString
    @Override
    public String toString(){
        return this.getDate() + " " + this.getType() + ":$" + this.getAmount();
    }

    // to json object
    public JSONObject toJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSON_ID, this.id.toString());
        jsonObject.put(JSON_TYPE, this.type);
        jsonObject.put(JSON_DATE, this.date);
        jsonObject.put(JSON_CATEGORY, this.category);
        jsonObject.put(JSON_AMOUNT, this.amount);
        jsonObject.put(JSON_DESCRIPTION, this.description);

        return  jsonObject;
    }
}
