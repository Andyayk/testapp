package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class JobController {

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

    @PostMapping("/retrieveallfavouritesjobs")
    public List<Job> retrieveAllFavouritesJobs(@RequestBody HashMap<String, Object> payload) {
        return jobService.findUserFavourites(payload);
    }
}
