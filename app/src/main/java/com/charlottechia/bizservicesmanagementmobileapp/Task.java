package com.charlottechia.bizservicesmanagementmobileapp;

public class Task {
    private String name;
    private int id;
    private String userInCharge;
    private float percentOfUIC;
    private String Liaison;
    private float percentOfLiaison;
    private String client;
    private float price;
    private boolean complete;
    private String type;


    public Task(String name, int id, String userInCharge, float percentOfUIC, String liaison, float percentOfLiaison, String client, float price, boolean complete, String type) {
        this.name = name;
        this.id = id;
        this.userInCharge = userInCharge;
        this.percentOfUIC = percentOfUIC;
        Liaison = liaison;
        this.percentOfLiaison = percentOfLiaison;
        this.client = client;
        this.price = price;
        this.complete = complete;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserInCharge() {
        return userInCharge;
    }

    public void setUserInCharge(String userInCharge) {
        this.userInCharge = userInCharge;
    }

    public float getPercentOfUIC() {
        return percentOfUIC;
    }

    public void setPercentOfUIC(float percentOfUIC) {
        this.percentOfUIC = percentOfUIC;
    }

    public String getLiaison() {
        return Liaison;
    }

    public void setLiaison(String liaison) {
        Liaison = liaison;
    }

    public float getPercentOfLiaison() {
        return percentOfLiaison;
    }

    public void setPercentOfLiaison(float percentOfLiaison) {
        this.percentOfLiaison = percentOfLiaison;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


}
