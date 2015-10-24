package coded.by.jin.walletmanager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by JinHwan Oh on 2015-10-19.
 */
public class Favorite {
    private UUID id;
    private String type;
    private String name;
    private double amount;
    private String description;

    private static final String JSON_ID = "id";
    private static final String JSON_TYPE = "type";
    private static final String JSON_NAME = "name";
    private static final String JSON_AMOUNT = "amount";
    private static final String JSON_DESCRIPTION= "description";

    // Constructor
    public Favorite() {
        this.id = UUID.randomUUID();
    }

    public Favorite(JSONObject json) throws JSONException {
        this.id = UUID.fromString(json.getString(JSON_ID));
        this.type = json.getString(JSON_TYPE);
        this.name = json.getString(JSON_NAME);
        this.amount = json.getDouble(JSON_AMOUNT);
        this.description = json.getString(JSON_DESCRIPTION);
    }

    // Getters
    public UUID getId() {
        return id;
    }

    public String getType() {
        return type;
    }

    public String getName() {
        return name;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // Setter
    public void setType(String type) {
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // to json object
    public JSONObject toJSON() throws JSONException{
        JSONObject jsonObject = new JSONObject();
        jsonObject.put(JSON_ID, this.id.toString());
        jsonObject.put(JSON_TYPE, this.type);
        jsonObject.put(JSON_NAME, this.name);
        jsonObject.put(JSON_AMOUNT, this.amount);
        jsonObject.put(JSON_DESCRIPTION, this.description);

        return  jsonObject;
    }
}
