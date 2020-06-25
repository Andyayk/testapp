package com.example.demo;

public class AppUser {
    private String employeeid;
    private String username;
    private String password;
    private String name;
    private String email;
    private boolean isAdmin;

    public AppUser() {
    }

    public AppUser(String employeeid, String username, String password, String name, String email, boolean isAdmin) {
        this.employeeid = employeeid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.isAdmin = isAdmin;
    }

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }
}
