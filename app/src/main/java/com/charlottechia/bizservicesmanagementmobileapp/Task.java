package com.charlottechia.bizservicesmanagementmobileapp;

public class Task {
    private String name;
    private Integer id;
    private String userInCharge;
    private Double percentOfUIC;
    private String Liaison;
    private Double percentOfLiaison;
    private String client;
    private Double price;
    private boolean complete;
    private String type;


    public Task(String name, Integer id, String userInCharge, Double percentOfUIC, String liaison, Double percentOfLiaison, String client, Double price, boolean complete, String type) {
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

    public String getTaskName() {
        return name;
    }

    public void setTaskName(String name) {
        this.name = name;
    }

    public Integer getTaskId() {
        return id;
    }

    public void setTaskId(Integer id) {
        this.id = id;
    }

    public String getUserInCharge() {
        return userInCharge;
    }

    public void setUserInCharge(String userInCharge) {
        this.userInCharge = userInCharge;
    }

    public Double getPercentOfUIC() {
        return percentOfUIC;
    }

    public void setPercentOfUIC(Double percentOfUIC) {
        this.percentOfUIC = percentOfUIC;
    }

    public String getLiaison() {
        return Liaison;
    }

    public void setLiaison(String liaison) {
        Liaison = liaison;
    }

    public Double getPercentOfLiaison() {
        return percentOfLiaison;
    }

    public void setPercentOfLiaison(Double percentOfLiaison) {
        this.percentOfLiaison = percentOfLiaison;
    }

    public String getTaskClient() {
        return client;
    }

    public void setTaskClient(String client) {
        this.client = client;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
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
