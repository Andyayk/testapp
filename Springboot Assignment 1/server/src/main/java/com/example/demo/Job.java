package com.example.demo;

public class Job {
    private Long jobid;
    private String jobTitle;
    private String jobDescription;
    private String datePosted;

    public Job() {
    }

    public Job(Long jobid, String jobTitle, String jobDescription, String datePosted) {
        this.jobid = jobid;
        this.jobTitle = jobTitle;
        this.jobDescription = jobDescription;
        this.datePosted = datePosted;
    }

    public Long getJobid() {
        return jobid;
    }

    public void setJobid(Long jobid) {
        this.jobid = jobid;
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