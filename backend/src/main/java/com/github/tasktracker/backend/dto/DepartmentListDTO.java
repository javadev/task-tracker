package com.github.tasktracker.backend.dto;

import java.util.List;
import com.github.tasktracker.backend.entities.Department;

public class DepartmentListDTO {
  private List<Department> departmentList;

  public List<Department> getDepartmentList() {
    return departmentList;
  }

  public void setDepartmentList(List<Department> departmentList) {
    this.departmentList = departmentList;
  }
}
