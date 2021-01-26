package com.github.tasktracker.backend.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Task {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime createdTime;
  private String name;
  @Column(length = 65450, columnDefinition = "text")
  private String description;
  private String status;
  private long createdBy;
  private long assignedTo;
  
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime startTime;
  
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm")
  private LocalDateTime endTime;
  
  private long department;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public LocalDateTime getCreatedTime() {
    return createdTime;
  }

  public void setCreatedTime(LocalDateTime createdTime) {
    this.createdTime = createdTime;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public long getCreatedBy() {
    return createdBy;
  }

  public void setCreatedBy(long createdBy) {
    this.createdBy = createdBy;
  }

  public long getAssignedTo() {
    return assignedTo;
  }

  public void setAssignedTo(long assignedTo) {
    this.assignedTo = assignedTo;
  }

  public LocalDateTime getStartTime() {
    return startTime;
  }

  public void setStartTime(LocalDateTime startTime) {
    this.startTime = startTime;
  }

  public LocalDateTime getEndTime() {
    return endTime;
  }

  public void setEndTime(LocalDateTime endTime) {
    this.endTime = endTime;
  }

  public long getDepartment() {
    return department;
  }

  public void setDepartment(long department) {
    this.department = department;
  }
}
