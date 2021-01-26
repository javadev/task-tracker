package com.github.tasktracker.backend.dto;

public class CommentDTO {

  String comment;

  public CommentDTO(String comment) {
    this.comment = comment;
  }

  public CommentDTO() {}

  public String getComment() {
    return comment;
  }

  public void setComment(String comment) {
    this.comment = comment;
  }
}
