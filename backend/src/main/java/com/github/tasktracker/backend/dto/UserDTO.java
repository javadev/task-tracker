package com.github.tasktracker.backend.dto;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.github.tasktracker.backend.entities.Department;
import com.github.tasktracker.backend.entities.Role;

public class UserDTO {
  private long id;
  private String name;
  private String username;
  private String email;
  private String password;
  private Set<Role> roles = new HashSet<>();
  private List<Department> department = new ArrayList<>();

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
  public String getUsername() {
    return username;
  }
  public void setUsername(String username) {
    this.username = username;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public Set<Role> getRoles() {
    return roles;
  }
  public void setRoles(Set<Role> roles) {
    this.roles = roles;
  }
  public List<Department> getDepartment() {
    return department;
  }
  public void setDepartment(List<Department> department) {
    this.department = department;
  }
}
