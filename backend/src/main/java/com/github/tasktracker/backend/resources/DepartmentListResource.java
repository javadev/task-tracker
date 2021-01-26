package com.github.tasktracker.backend.resources;

import java.util.List;

public class DepartmentListResource {

  private List<DepartmentResource> departmentList;

  public List<DepartmentResource> getDepartmentList() {
    return departmentList;
  }

  public void setDepartmentList(List<DepartmentResource> departmentList) {
    this.departmentList = departmentList;
  }
  
}
