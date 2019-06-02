package com.charlottechia.bizservicesmanagementmobileapp;

public class User {

    private String name;
    private Integer id;
    private Integer contact;
    private String email;
    private String username;
    private Integer password;
    private Boolean role;
    private Boolean status;

    public User(String name, Integer id, Integer contact, String email, String username, Integer password, Boolean role, Boolean status) {
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public String getUserName() {
        return name;
    }

    public Integer getUserId() {
        return id;
    }

    public Integer getUserContact() {
        return contact;
    }

    public String getUserEmail() {
        return email;
    }

    public String getUserUsername() {
        return username;
    }

    public Integer getUserPassword() {
        return password;
    }

    public Boolean getUserRole() {
        return role;
    }

    public Boolean getUserStatus() {
        return status;
    }

}
