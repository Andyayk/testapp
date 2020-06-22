package com.example.demo;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class JobService {

    private static List<Job> jobs = new ArrayList<>();
    private static long jobidCounter = 0;

    static {
        jobs.add(new Job(++jobidCounter, "Teacher", "Need to manage children", "31-12-2020"));
        jobs.add(new Job(++jobidCounter, "Police", "Need to manage criminals", "31-12-2020"));
        jobs.add(new Job(++jobidCounter, "Lawyer", "Need to manage law", "31-12-2020"));
        jobs.add(new Job(++jobidCounter, "Doctor", "Need to manage patients", "31-12-2020"));
    }

    public List<Job> findAll() {
        return jobs;
    }
}