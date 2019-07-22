package com.charlottechia.bizservicesmanagementmobileapp;

import java.util.Date;

public class Client {
    private Integer id;
    private String name;
    private Integer contact;
    private String email;
    private String contactPerson;
    private String secretary;
    private Date endDate;
    private String director1;
    private String director2;
    private String director3;
    private String shareholder1;
    private String shareholder2;

    public Client(Integer id, String name, Integer contact, String email, String contactPerson, String secretary, Date endDate, String director1, String director2, String director3, String shareholder1, String shareholder2) {
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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getContact() {
        return contact;
    }

    public void setContact(Integer contact) {
        this.contact = contact;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContactPerson() {
        return contactPerson;
    }

    public void setContactPerson(String contactPerson) {
        this.contactPerson = contactPerson;
    }

    public String getSecretary() {
        return secretary;
    }

    public void setSecretary(String secretary) {
        this.secretary = secretary;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getDirector1() {
        return director1;
    }

    public void setDirector1(String director1) {
        this.director1 = director1;
    }

    public String getDirector2() {
        return director2;
    }

    public void setDirector2(String director2) {
        this.director2 = director2;
    }

    public String getDirector3() {
        return director3;
    }

    public void setDirector3(String director3) {
        this.director3 = director3;
    }

    public String getShareholder1() {
        return shareholder1;
    }

    public void setShareholder1(String shareholder1) {
        this.shareholder1 = shareholder1;
    }

    public String getShareholder2() {
        return shareholder2;
    }

    public void setShareholder2(String shareholder2) {
        this.shareholder2 = shareholder2;
    }
}
