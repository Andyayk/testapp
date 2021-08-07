package com.example.demo.repository;

import com.example.demo.model.Job;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobRepo extends JpaRepository<Job, Long> {
    @Query("SELECT j FROM Job j WHERE j.deleted = :deleted")
    List<Job> retrieveAllByNotDeleted(@Param("deleted") Integer deleted);

    Job findByJobId(Long jobId);
}
