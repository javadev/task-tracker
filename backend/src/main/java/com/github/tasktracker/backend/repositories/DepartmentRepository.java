package com.github.tasktracker.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.tasktracker.backend.entities.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

  List<Department> findByAdmin(long admin);
}
