package com.github.tasktracker.backend.dto;

public class TaskCommentDTO {
  private long id;
  private long user;
  private long department;
  private long task;
  private String comment;

  public long getDepartment() {
    return department;
  }

  public void setDepartment(long department) {
    this.department = department;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getUser() {
    return user;
  }

  public void setUser(long user) {
    this.user = user;
  }

  public long getTask() {
    return task;
  }

  public void setTask(long task) {
    this.task = task;
  }

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
