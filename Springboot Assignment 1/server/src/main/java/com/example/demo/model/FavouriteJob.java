package com.example.demo.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
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

    public FavouriteJob() {

    }

    public FavouriteJob(FavouriteJobKey id, AppUser appUser, Job job) {
        this.id = id;
        this.appUser = appUser;
        this.job = job;
    }
}
