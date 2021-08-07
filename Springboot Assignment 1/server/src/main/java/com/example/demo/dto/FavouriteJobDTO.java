package com.example.demo.dto;

public class FavouriteJobDTO {
    private Long employeeId;
    private Long jobId;

    public Long getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    @Override
    public String toString() {
        return "FavouriteJobDTO{" +
                "employeeId=" + employeeId +
                ", jobId=" + jobId +
                '}';
    }
}
