package com.charlottechia.bizservicesmanagementmobileapp;

public class User  {

    private String name;
    private Integer id;
    private Integer contact;
    private String email;
    private String username;
    private String password;
    private String role;
    private Boolean status;

    public User(String name, Integer id, Integer contact, String email, String username, String password,String role, Boolean status) {
        this.name = name;
        this.id = id;
        this.contact = contact;
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
        this.status = status;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
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

    public String getUserPassword() {
        return password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }


    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", contact=" + contact +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", role='" + role + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
