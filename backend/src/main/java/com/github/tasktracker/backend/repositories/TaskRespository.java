package com.github.tasktracker.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.tasktracker.backend.entities.Task;

@Repository
public interface TaskRespository extends JpaRepository<Task, Long> {
  List<Task> findByDepartment(long department);
}
