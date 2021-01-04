package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface AppUserRepo extends JpaRepository<AppUser, String> {

    AppUser findByUsername(String username);

    @Query("SELECT u FROM AppUser u WHERE u.jobId = :jobId")
    AppUser retrieveByJobid(@Param("jobId") String jobId);

    @Query(
        value = "SELECT * FROM AppUser u WHERE u.jobId = ?1",
        nativeQuery = true)
    AppUser retrieveByJobidNative(String jobId);
}
