package com.charlottechia.bizservicesmanagementmobileapp;

public class Client {
    private String name;
    private Integer id;
    private Integer contact;
    private String email;
    private String contactPerson;
    private String secretary;
    private String endDate;
    private String directors;
    private String shareholders;
    private Boolean status;

    public Client(String name, Integer id, Integer contact, String email, String contactPerson, String secretary, String endDate, String directors, String shareholders, Boolean status) {
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.email = email;
        this.contactPerson = contactPerson;
        this.secretary = secretary;
        this.endDate = endDate;
        this.directors = directors;
        this.shareholders = shareholders;
        this.status = status;
    }

    public String getClientName() {
        return name;
    }

    public Integer getClientId() {
        return id;
    }

    public Integer getClientContact() {
        return contact;
    }

    public String getClientEmail() {
        return email;
    }

    public String getClientContactPerson() {
        return contactPerson;
    }

    public String getClientSecretary() {
        return secretary;
    }

    public String getClientEndDate() {
        return endDate;
    }

    public String getClientDirectors() {
        return directors;
    }

    public String getClientShareholders() {
        return shareholders;
    }

    public Boolean getClientStatus() {
        return status;
    }
}
