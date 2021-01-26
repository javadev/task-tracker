package com.github.tasktracker.backend.resources;

import com.github.tasktracker.backend.entities.Department;

public class DepartmentResource {

    private long id;
    private String name;
    private long admin;

    public DepartmentResource(Department department) {
        this.id = department.getId();
        this.name = department.getName();
        this.admin = department.getAdmin();
    }

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

    public long getAdmin() {
        return admin;
    }

    public void setAdmin(long admin) {
        this.admin = admin;
    }


}
