package com.example.demo.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Job {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "jobId", nullable = false, updatable = false)
    private Long jobId;
    private String jobTitle;
    private String jobDescription;
    private String datePosted;

    @OneToMany(mappedBy = "job")
    Set<FavouriteJob> favouriteJob;

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(String jobDescription) {
        this.jobDescription = jobDescription;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public Set<FavouriteJob> getFavouriteJob() {
        return favouriteJob;
    }

    public void setFavouriteJob(Set<FavouriteJob> favouriteJob) {
        this.favouriteJob = favouriteJob;
    }
}