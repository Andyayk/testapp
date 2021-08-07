package com.example.demo.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class FavouriteJobKey implements Serializable {
    @Column(name = "employeeId")
    Long employeeId;

    @Column(name = "jobId")
    Long jobId;

    public FavouriteJobKey () {

    }

    public FavouriteJobKey(Long employeeId, Long jobId) {
        this.employeeId = employeeId;
        this.jobId = jobId;
    }
}
