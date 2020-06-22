package com.example.demo;

public class AppUser {
    private String name;
    private String email;
    private String employeeid;
    private boolean isadmin;

    public AppUser() {
    }

    public AppUser(String name, String email, String employeeid, boolean isadmin) {
        this.name = name;
        this.email = email;
        this.employeeid = employeeid;
        this.isadmin = isadmin;
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

    public String getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(String employeeid) {
        this.employeeid = employeeid;
    }

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean isadmin) {
        this.isadmin = isadmin;
    }
}
