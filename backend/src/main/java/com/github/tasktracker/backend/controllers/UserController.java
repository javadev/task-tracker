package com.github.tasktracker.backend.controllers;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.github.tasktracker.backend.resources.UserListResource;
import com.github.tasktracker.backend.resources.UserResource;
import com.github.tasktracker.backend.services.UserService;
import com.github.tasktracker.backend.utils.Client;

@RestController
public class UserController {

  @Autowired
  private UserService service;

  final String clientUrl = Client.clientUrl;

  @GetMapping("/getAllUser")
  @CrossOrigin(origins = clientUrl)
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<UserListResource> getAllUser() {
    UserListResource ulr = new UserListResource();
    ulr.setUserList(service.getAllUser());
    return new ResponseEntity<UserListResource>(ulr, HttpStatus.OK);
  }
  
  @GetMapping("/getAllUser/{pid}")
  @CrossOrigin(origins = clientUrl)
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<UserListResource> getAllUser(@PathVariable("pid") Long pid) {
    UserListResource ulr = new UserListResource();
    ulr.setUserList(service.getAllUserByDepartment(pid));
    return new ResponseEntity<UserListResource>(ulr, HttpStatus.OK);
  }

  @GetMapping("/getUser/{uid}")
  @CrossOrigin(origins = clientUrl)
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<UserResource> getUserById(@PathVariable("uid") Long uid) {
    UserResource ur = new UserResource();
    BeanUtils.copyProperties(service.getUser(uid), ur);
    return new ResponseEntity<UserResource>(ur, HttpStatus.OK);
  }
}
