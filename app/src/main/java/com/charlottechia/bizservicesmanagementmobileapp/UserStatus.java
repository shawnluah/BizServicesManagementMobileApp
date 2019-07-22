package com.charlottechia.bizservicesmanagementmobileapp;

public class UserStatus {

    private int id;
    private boolean userStatus;

    public UserStatus(int id, boolean userStatus) {
        this.id = id;
        this.userStatus = userStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(boolean userStatus) {
        this.userStatus = userStatus;
    }

}
