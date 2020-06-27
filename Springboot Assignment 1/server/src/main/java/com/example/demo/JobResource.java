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
    public String addJob(@RequestBody HashMap<String, Object> payload) {
        return jobService.addJob(payload);
    }

    @PostMapping("/deletejob")
    public String deleteJob(@RequestBody HashMap<String, Object> payload) {
        return jobService.deleteJob(payload);
    }

    @PostMapping("/editjob")
    public String editJob(@RequestBody HashMap<String, Object> payload) {
        return jobService.editJob(payload);
    }
}