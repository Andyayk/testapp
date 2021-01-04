package com.example.demo;

import javax.persistence.*;

@Entity
public class AppUser {
    @Id
    private String employeeid;
    private String username;
    private String password;
    private String name;
    private String email;
    private boolean isadmin;

    @OneToOne
    @JoinColumn(name = "jobId")
    @MapsId
    private Job job;

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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

    public boolean isIsadmin() {
        return isadmin;
    }

    public void setIsadmin(boolean admin) {
        isadmin = admin;
    }

}
