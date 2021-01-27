package com.github.tasktracker.backend.services;

import com.github.tasktracker.backend.dto.CommentDTO;
import com.github.tasktracker.backend.entities.Task;
import com.github.tasktracker.backend.entities.TaskComment;
import com.github.tasktracker.backend.repositories.TaskCommentRepository;
import com.github.tasktracker.backend.repositories.TaskRespository;
import com.github.tasktracker.backend.resources.TaskCommentListResource;
import com.github.tasktracker.backend.resources.TaskListResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskService {
  @Autowired
  private TaskRespository taskRepository;
  @Autowired
  private TaskCommentRepository taskCommentRepository;

  public void createTask(Task task, long[] trainees) {
    Task savedTask = taskRepository.save(task);
    long department = savedTask.getDepartment();
    this.initTaskRecords(trainees,savedTask.getId(), department);
  }

  public void initTaskRecords(long[] trainees, long taskId, long department) {
    // to be shifted to util
    for (long id : trainees) {
      TaskComment taskComment = new TaskComment();
      taskComment.setUser(id);
      taskComment.setDepartment(department);
      taskComment.setTask(taskId);
      taskComment.setComment("");
      taskCommentRepository.save(taskComment);
    }
  }

  public List<Task> getTasksFromTaskRecord(List<TaskComment> taskCommentList) {
    // to be shifted to util
    List<Task> tasks = new ArrayList<Task>();
    for (TaskComment taskComment : taskCommentList) {
      tasks.add(taskRepository.findById(taskComment.getTask()).get());
    }
    return tasks;
  }
  
  public TaskListResource getAllTask() {
    List<Task> taskList = (List<Task>)taskRepository.findAll();
    TaskListResource tlr = new TaskListResource();
    tlr.setTaskList(taskList);
    return tlr;
  }
  
  public TaskCommentListResource getAllTaskComment() {
    TaskCommentListResource trlr = new TaskCommentListResource();
    trlr.setTaskCommentList((List<TaskComment>) taskCommentRepository.findAll());
    return trlr;
  }

  public TaskListResource getAllTaskByDepartment(long did) {
    List<Task> taskList = (List<Task>)taskRepository.findByDepartment(did);
    TaskListResource tlr = new TaskListResource();
    tlr.setTaskList(taskList);
    return tlr;
  }

  public TaskCommentListResource getAllTaskCommentOfUserAndDepartment(long uid, long did) {
    TaskCommentListResource tclr = new TaskCommentListResource();
    List<TaskComment> trl = taskCommentRepository.findByDepartmentAndUser(did, uid);
    tclr.setTaskCommentList(trl);
    return tclr;
  }
  
  public TaskListResource getAllTaskOfUserAndDepartment(long uid, long did) {
    TaskListResource tlr = new TaskListResource();
    List<Task> tl = this.getTasksFromTaskRecord(taskCommentRepository.findByDepartmentAndUser(did, uid));
    tlr.setTaskList(tl);
    return tlr;
  }

  public CommentDTO getWork(long uid, long did, long tid) {
    TaskComment tr = taskCommentRepository.findByDepartmentAndUserAndTask(did, uid, tid);
    CommentDTO dto = new CommentDTO();
    dto.setComment(tr.getComment() != null ? tr.getComment() : "");
    
    return dto;
  }

  public void addComment(long uid, long did, long tid, String comment) {
    TaskComment tc = taskCommentRepository.findByDepartmentAndUserAndTask(did, uid, tid);
    tc.setComment(comment);
    taskCommentRepository.save(tc);
  }
}
