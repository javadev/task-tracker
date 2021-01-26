package com.github.tasktracker.backend.dto;

public class NewDepartmentDTO {
  private long id;
  private String name;
  private long[] users;
  private long admin;

  public long getId() {
    return id;
  }
  
  public void setId(long id) {
    this.id = id;
  }
  
  public String getName() {
    return name;
  }
  
  public void setName(String name) {
    this.name = name;
  }
  
  public long[] getUsers() {
    return users;
  }

  public void setUsers(long[] users) {
    this.users = users;
  }

  public long getAdmin() {
    return admin;
  }

  public void setAdmin(long admin) {
    this.admin = admin;
  }
}
