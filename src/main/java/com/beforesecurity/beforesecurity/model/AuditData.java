package com.beforesecurity.beforesecurity.model;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;

@Embeddable
public class AuditData {



  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private String createdBy;
  private String updatedBy;
  
  public AuditData() {
  }

  public AuditData(LocalDateTime createdAt, LocalDateTime updatedAt, String createdBy, String updatedBy) {
    this.createdAt = createdAt;
    this.updatedAt = updatedAt;
    this.createdBy = createdBy;
    this.updatedBy = updatedBy;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
  }

  public LocalDateTime getUpdatedAt() {
    return updatedAt;
  }

  public void setUpdatedAt(LocalDateTime updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(String createdBy) {
    this.createdBy = createdBy;
  }

  public String getUpdatedBy() {
    return updatedBy;
  }

  public void setUpdatedBy(String updatedBy) {
    this.updatedBy = updatedBy;
  }

  @Override
  public String toString() {
    return "AuditData [createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", createdBy=" + createdBy
        + ", updatedBy=" + updatedBy + "]";
  }

  


}
