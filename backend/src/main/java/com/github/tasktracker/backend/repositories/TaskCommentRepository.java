package com.github.tasktracker.backend.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.github.tasktracker.backend.entities.TaskComment;

@Repository
public interface TaskCommentRepository extends JpaRepository<TaskComment, Long> {

    @Query("SELECT t FROM TaskComment t WHERE t.user=:id")
    List<TaskComment> getTaskCommentByUser(@Param("id") long user);

    List<TaskComment> findByDepartmentAndUser(long department, long user);

    TaskComment findByDepartmentAndUserAndTask(long department, long user, long task);
}
