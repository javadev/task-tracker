package com.github.tasktracker.backend.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class TaskComment {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;
  private long user;
  private long task;
  private String comment;

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
