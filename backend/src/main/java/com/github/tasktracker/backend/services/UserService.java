package com.github.tasktracker.backend.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.tasktracker.backend.entities.User;
import com.github.tasktracker.backend.repositories.DepartmentRepository;
import com.github.tasktracker.backend.repositories.UserRepository;
import com.github.tasktracker.backend.resources.DepartmentResource;
import com.github.tasktracker.backend.resources.UserResource;

@Service
public class UserService {
  @Autowired
  private DepartmentRepository departmentRepository;
  @Autowired
  private UserRepository userRepository;
 
  public List<UserResource> getAllUser() {
    return (List<UserResource>) userRepository.findAll()
                                .stream()
                                .map(user -> new UserResource(user))
                                .collect(Collectors.toList());
  }
  
  public List<UserResource> getAllUserByDepartment(long departmentId) {
    List<UserResource> users = departmentRepository.findById(departmentId)
                                .get()
                                .getUsers()
                                .stream()
                                .map(user -> new UserResource(user))
                                .collect(Collectors.toList());
    return users;
  }
  
  public List<DepartmentResource> getAllDepartmentByUser(long uid) {
    return userRepository.findDepartmentById(uid)
                                .stream()
                                .map(department -> new DepartmentResource(department))
                                .collect(Collectors.toList());
  }
  
  public User getUser(long id) {
    return userRepository.findById(id).get();
  }
}
