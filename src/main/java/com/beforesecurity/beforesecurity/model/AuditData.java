package com.beforesecurity.beforesecurity.model;

import java.time.LocalDateTime;

import jakarta.persistence.Embeddable;

@Embeddable
public class AuditData {



  private LocalDateTime createdAt;
  private LocalDateTime updatedAt;

  private String createdBy;
  private String updatedBy;


}
