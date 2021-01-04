package com.example.demo;

import javax.persistence.*;

@Entity
public class AppUser {
    @Id
    @Column(name = "jobId", insertable = false, updatable = false)
    private String jobId;
    private String username;
    private String password;
    private String name;
    private String email;

    private String isadmin;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "jobId")
    @MapsId
    private Job job;

    public AppUser() {
    }

    public AppUser(String jobId, String username, String password, String name, String email, String isadmin, Job job) {
        this.jobId = jobId;
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.isadmin = isadmin;
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
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

    public String getIsadmin() {
        return isadmin;
    }

    public void setIsadmin(String isadmin) {
        this.isadmin = isadmin;
    }
}
