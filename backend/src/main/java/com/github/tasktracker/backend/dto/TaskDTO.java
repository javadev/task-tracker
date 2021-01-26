package com.github.tasktracker.backend.dto;

import java.time.LocalDateTime;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TaskDTO {
  private long id;
  private long department;
  private String name;
  private long createdBy;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime createdTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime startTime;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime endTime;
  private long modifiedBy;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime modifiedTime;
  private String status;

  @Column(length = 65450, columnDefinition = "text")
  private String description;

  public long getId() {
    return id;
  }

  public long getDepartment() {
    return department;
  }

  public String getName() {
    return name;
  }

  public long getCreatedBy() {
    return createdBy;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public LocalDateTime getCreatedTime() {
    return createdTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public long getModifiedBy() {
    return modifiedBy;
  }

  public LocalDateTime getModifiedTime() {
    return modifiedTime;
  }

  public String getStatus() {
    return status;
  }

  public String getDescription() {
    return description;
  }

  public void setId(long id) {
    this.id = id;
  }

  public void setDepartment(long department) {
    this.department = department;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setCreatedBy(long createdBy) {
    this.createdBy = createdBy;
  }

  public void setCreatedTime(LocalDateTime createdTime) {
    this.createdTime = createdTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public void setModifiedBy(long modifiedBy) {
    this.modifiedBy = modifiedBy;
  }

  public void setModifiedTime(LocalDateTime modifiedTime) {
    this.modifiedTime = modifiedTime;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public void setDescription(String description) {
    this.description = description;
  }
}
