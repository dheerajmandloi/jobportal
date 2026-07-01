package com.example.jobportal.DTO;

import java.time.LocalDateTime;

public class ApplicationDto {

    private Long applicationId;
    private Long userId;
    private Long jobId;
    private String status;
    private LocalDateTime appliedAt;

    public ApplicationDto() {
    }

    public ApplicationDto(Long applicationId, Long userId, Long jobId,
            String status, LocalDateTime appliedAt) {
        this.applicationId = applicationId;
        this.userId = userId;
        this.jobId = jobId;
        this.status = status;
        this.appliedAt = appliedAt;
    }

    public Long getApplicationId() {
        return applicationId;
    }

    public void setApplicationId(Long applicationId) {
        this.applicationId = applicationId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getJobId() {
        return jobId;
    }

    public void setJobId(Long jobId) {
        this.jobId = jobId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDateTime getAppliedAt() {
        return appliedAt;
    }

    public void setAppliedAt(LocalDateTime appliedAt) {
        this.appliedAt = appliedAt;
    }
}