package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
public class PopularJobController {

    @Autowired
    private PopularJobService popularJobService;

    @GetMapping("/popularjobs")
    public List<PopularJob> getAllPopularJobs() {
        return popularJobService.findAllPopularJobs();
    }
}
