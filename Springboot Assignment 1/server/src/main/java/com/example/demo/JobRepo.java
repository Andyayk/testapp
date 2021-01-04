package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepo extends JpaRepository<Job, String> {

    Job findByJobId(String jobId);
}
