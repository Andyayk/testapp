package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PopularJobRepo extends JpaRepository<PopularJob, Integer> {
    /*
    @Modifying
    @Query(value = "insert into popular_job (name, age, email, status) values (:name, :age, :email, :status)", nativeQuery = true)
    void insertData(@Param("name") String name, @Param("age") Integer age, @Param("status") Integer status, @Param("email") String email);
     */
}
