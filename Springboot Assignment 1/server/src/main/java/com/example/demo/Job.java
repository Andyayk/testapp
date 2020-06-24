package com.example.demo;

public class Job {
    private String jobTitle;
    private String jobDescription;
    private String datePosted;

    public Job() {
    }

    public Job(String jobTitle, String jobDescription, String datePosted) {
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.datePosted = datePosted;
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
}