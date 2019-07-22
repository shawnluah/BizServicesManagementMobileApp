package com.charlottechia.bizservicesmanagementmobileapp;

import java.util.Date;

public class AlertList {

    private int id;
    private Date taskDueDate;
    private Date taskRemoveType;
    private String taskType;

    public AlertList(int id, Date taskDueDate, Date taskRemoveType, String taskType) {
        this.id = id;
        this.taskDueDate = taskDueDate;
        this.taskRemoveType = taskRemoveType;
        this.taskType = taskType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getTaskDueDate() {
        return taskDueDate;
    }

    public void setTaskDueDate(Date taskDueDate) {
        this.taskDueDate = taskDueDate;
    }

    public Date getTaskRemoveType() {
        return taskRemoveType;
    }

    public void setTaskRemoveType(Date taskRemoveType) {
        this.taskRemoveType = taskRemoveType;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }
}
