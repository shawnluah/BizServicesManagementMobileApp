package com.charlottechia.bizservicesmanagementmobileapp;

import java.util.Date;

public class Client {
    private Integer id;
    private String name;
    private Integer contact;
    private String email;
    private String contactPerson;
    private String secretary;
    private String endDate;
    private String director1;
    private String director2;
    private String director3;
    private String shareholder1;
    private String shareholder2;

    public Client(Integer id, String name, Integer contact, String email, String contactPerson, String secretary, String endDate, String director1, String director2, String director3, String shareholder1, String shareholder2) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.email = email;
        this.contactPerson = contactPerson;
        this.secretary = secretary;
        this.endDate = endDate;
        this.director1 = director1;
        this.director2 = director2;
        this.director3 = director3;
        this.shareholder1 = shareholder1;
        this.shareholder2 = shareholder2;
    }

    public Integer getClientId() {
        return id;
    }

    public void setClientId(int id) {
        this.id = id;
    }

    public String getClientName() {
        return name;
    }

    public void setClientName(String name) {
        this.name = name;
    }

    public Integer getClientContact() {
        return contact;
    }

    public void setClientContact(int contact) {
        this.contact = contact;
    }

    public String getClientEmail() {
        return email;
    }

    public void setClientEmail(String email) {
        this.email = email;
    }

    public String getClientContactPerson() {
        return contactPerson;
    }

    public void setClientContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getClientSecretary() {
        return secretary;
    }

    public void setClientSecretary(String secretary) {
        this.secretary = secretary;
    }

    public String getClientEndDate() {
        return endDate;
    }

    public void setClientEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getClientDirector1() {
        return director1;
    }

    public void setClientDirector1(String director1) {
        this.director1 = director1;
    }

    public String getClientDirector2() {
        return director2;
    }

    public void setClientDirector2(String director2) {
        this.director2 = director2;
    }

    public String getClientDirector3() {
        return director3;
    }

    public void setClientDirector3(String director3) {
        this.director3 = director3;
    }

    public String getClientShareholder1() {
        return shareholder1;
    }

    public void setClientShareholder1(String shareholder1) {
        this.shareholder1 = shareholder1;
    }

    public String getClientShareholder2() {
        return shareholder2;
    }

    public void setClientShareholder2(String shareholder2) {
        this.shareholder2 = shareholder2;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", contactPerson='" + contactPerson + '\'' +
                ", secretary='" + secretary + '\'' +
                ", endDate='" + endDate + '\'' +
                ", director1='" + director1 + '\'' +
                ", director2='" + director2 + '\'' +
                ", director3='" + director3 + '\'' +
                ", shareholder1='" + shareholder1 + '\'' +
                ", shareholder2='" + shareholder2 + '\'' +
                '}';
    }
}
