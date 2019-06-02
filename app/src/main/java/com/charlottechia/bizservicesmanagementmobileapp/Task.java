package com.charlottechia.bizservicesmanagementmobileapp;

public class Task {
    private String name;
    private Integer id;
    private String userInCharge;
    private Integer percentOfUIC;
    private String Liaison;
    private Integer percentOfLiaison;
    private String client;
    private Integer price;
    private String dueDate;
    private Boolean status;
    private String type;

    public Task(String name, Integer id, String userInCharge, Integer percentOfUIC, String liaison, Integer percentOfLiaison, String client, Integer price, String dueDate, Boolean status, String type) {
        this.name = name;
        this.id = id;
        this.userInCharge = userInCharge;
        this.percentOfUIC = percentOfUIC;
        Liaison = liaison;
        this.percentOfLiaison = percentOfLiaison;
        this.client = client;
        this.price = price;
        this.dueDate = dueDate;
        this.status = status;
        this.type = type;


    }

    public String getTaskName() {
        return name;
    }

    public Integer getTaskId() {
        return id;
    }

    public String getTaskUserInCharge() {
        return userInCharge;
    }

    public Integer getTaskPercentOfUIC() {
        return percentOfUIC;
    }

    public String getTaskLiaison() {
        return Liaison;
    }

    public Integer getTaskPercentOfLiaison() {
        return percentOfLiaison;
    }

    public String getTaskClient() {
        return client;
    }

    public Integer getTaskPrice() {
        return price;
    }

    public String getTaskDueDate() {
        return dueDate;
    }

    public Boolean getTaskStatus() {
        return status;
    }

    public String getTaskType() {
        return type;
    }
}
