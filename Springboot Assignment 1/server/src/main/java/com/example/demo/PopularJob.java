package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class PopularJob {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    private String jobId;
    private String jobTitle;
    private String jobDescription;
    private String datePosted;
    private int favouriteCount;
    private String dateRetrieved;

    public PopularJob() {
    }

    public PopularJob(String jobId, String jobTitle, String jobDescription, String datePosted, int favouriteCount, String dateRetrieved) {
        this.jobId = jobId;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.datePosted = datePosted;
        this.favouriteCount = favouriteCount;
        this.dateRetrieved = dateRetrieved;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
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

    public int getFavouriteCount() {
        return favouriteCount;
    }

    public void setFavouriteCount(int favouriteCount) {
        this.favouriteCount = favouriteCount;
    }

    public String getDateRetrieved() {
        return dateRetrieved;
    }

    public void setDateRetrieved(String dateRetrieved) {
        this.dateRetrieved = dateRetrieved;
    }
}
