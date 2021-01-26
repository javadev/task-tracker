package com.github.tasktracker.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.tasktracker.backend.dto.CodeDTO;
import com.github.tasktracker.backend.dto.NewDepartmentDTO;
import com.github.tasktracker.backend.resources.DepartmentListResource;
import com.github.tasktracker.backend.services.DepartmentService;
import com.github.tasktracker.backend.services.UserService;
import com.github.tasktracker.backend.utils.Client;

@RestController
public class DepartmentController {
  final String clientUrl = Client.clientUrl;
  
  @Autowired
  private DepartmentService service;
  
  @Autowired
  private UserService userService;
  
  @PostMapping("/createDepartment/{uid}")
  @CrossOrigin(origins = clientUrl)
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<Boolean> createDepartment(@PathVariable("uid") Long uid, @RequestBody NewDepartmentDTO newDepartmentDto) {
    service.createDepartment(newDepartmentDto, uid);
    return new ResponseEntity<Boolean>(true,HttpStatus.OK);
  }
  
  @GetMapping("/getAllDepartment")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity<DepartmentListResource> getAllDepartment() {
    return new ResponseEntity<DepartmentListResource>(service.getAll(), HttpStatus.OK);
  }
  
  @GetMapping("/getAllDepartmentByAdmin/{id}")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity<DepartmentListResource> getAllDepartmentByAdmin(@PathVariable("id") Long id) {
      DepartmentListResource dto = service.getAllByAdmin(id);
    return new ResponseEntity<DepartmentListResource>(dto, HttpStatus.OK);
  }
  
  @GetMapping("/getAllDepartmentByUser/{uid}")
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  @CrossOrigin(origins = clientUrl)
  public ResponseEntity<DepartmentListResource> getAllDepartmentByUser(@PathVariable("uid") Long uid) {
      DepartmentListResource dto = new DepartmentListResource();
    dto.setDepartmentList(userService.getAllDepartmentByUser(uid));
    return new ResponseEntity<DepartmentListResource>(dto, HttpStatus.OK);
  }
  
  @PostMapping("/enterPrg")
  @CrossOrigin(origins = clientUrl)
  @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
  public ResponseEntity<Boolean> enterDepartment(@RequestBody CodeDTO code) {
    service.addUser(code.getUid(), code.getCode());
    return new ResponseEntity<Boolean>(true,HttpStatus.OK);
  }
}
