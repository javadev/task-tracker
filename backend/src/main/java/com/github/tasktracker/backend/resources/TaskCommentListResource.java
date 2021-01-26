package com.github.tasktracker.backend.resources;

import java.util.List;
import com.github.tasktracker.backend.entities.TaskComment;

public class TaskCommentListResource {
  private List<TaskComment> taskCommentList;

  public List<TaskComment> getTaskCommentList() {
    return taskCommentList;
  }

  public void setTaskCommentList(List<TaskComment> taskCommentList) {
    this.taskCommentList = taskCommentList;
  }
}
