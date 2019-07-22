package com.charlottechia.bizservicesmanagementmobileapp;

public class ClientStatus {

    private int id;
    private boolean clientStatus;

    public ClientStatus(int id, boolean clientStatus) {
        this.id = id;
        this.clientStatus = clientStatus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isClientStatus() {
        return clientStatus;
    }

    public void setClientStatus(boolean clientStatus) {
        this.clientStatus = clientStatus;
    }

}
