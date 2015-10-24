package coded.by.jin.walletmanager;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.UUID;

/**
 * Created by JinHwan Oh on 2015-10-19.
 */
public class StaticFee {
    private UUID id;
    private String type;
    private String name;
    private String startingDate;
    private String endingDate;
    private long frequencyInDays; //every n days
    private double amount;
    private String description;

    private static final String JSON_ID = "id";
    private static final String JSON_TYPE = "type";
    private static final String JSON_NAME = "name";
    private static final String JSON_STARTING_DATE = "startingDate";
    private static final String JSON_ENDING_DATE = "endingDate";
    private static final String JSON_FREQUENCY_IN_DAYS = "frequencyInDays";
    private static final String JSON_AMOUNT = "amount";
    private static final String JSON_DESCRIPTION= "description";
    // Constructor
    public StaticFee() {
        this.id = UUID.randomUUID();
    }
    public StaticFee(JSONObject json) throws JSONException {
        this.id = UUID.fromString(json.getString(JSON_ID));
        this.startingDate = json.getString(JSON_STARTING_DATE);
        this.endingDate = json.getString(JSON_ENDING_DATE);
        this.type = json.getString(JSON_TYPE);
        this.name = json.getString(JSON_NAME);
        this.frequencyInDays = json.getLong(JSON_FREQUENCY_IN_DAYS);
        this.amount = json.getDouble(JSON_AMOUNT);
        this.description = json.getString(JSON_DESCRIPTION);
    }
    // Getters
    public UUID getId() {
        return id;
    }

    public String getType(){
        return type;
    }

    public String getName() {
        return name;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public long getFrequencyInDays() {
        return frequencyInDays;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    // setters
    public void setType(String type){
        this.type = type;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public void setFrequencyInDays(long frequencyInDays) {
        this.frequencyInDays = frequencyInDays;
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
        jsonObject.put(JSON_STARTING_DATE, this.startingDate);
        jsonObject.put(JSON_ENDING_DATE, this.endingDate);
        jsonObject.put(JSON_FREQUENCY_IN_DAYS,  this.frequencyInDays);
        jsonObject.put(JSON_AMOUNT, this.amount);
        jsonObject.put(JSON_DESCRIPTION, this.description);

        return  jsonObject;
    }
}
