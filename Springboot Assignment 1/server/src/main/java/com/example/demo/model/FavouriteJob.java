package com.example.demo.model;

import javax.persistence.*;

@Entity
public class FavouriteJob {
    @EmbeddedId
    FavouriteJobKey id;

    @ManyToOne
    @MapsId("employeeId")
    @JoinColumn(name = "employeeId")
    AppUser appUser;

    @ManyToOne
    @MapsId("jobId")
    @JoinColumn(name = "jobId")
    Job job;

    public FavouriteJob () {

    }

    public FavouriteJob(FavouriteJobKey id, AppUser appUser, Job job) {
        this.id = id;
        this.appUser = appUser;
        this.job = job;
    }

    public FavouriteJobKey getId() {
        return id;
    }

    public void setId(FavouriteJobKey id) {
        this.id = id;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }
}
