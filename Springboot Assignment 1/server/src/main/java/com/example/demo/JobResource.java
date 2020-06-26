package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@CrossOrigin(origins = { "http://localhost:8081" })
@RestController
public class JobResource {

    @Autowired
    private JobService jobService;

    @GetMapping("/jobs")
    public List<Job> getAllJobs() {
        return jobService.findAll();
    }

    @PostMapping("/addjob")
    public void addJob() {
        jobService.addJob();
    }

    @PostMapping("/deletejob")
    public void deleteJob(@RequestBody HashMap<String, Object> payload) {
        jobService.deleteJob(payload);
    }

    @PostMapping("/editjob")
    public void editJob() {
        jobService.editJob();
    }
}