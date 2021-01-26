package com.github.tasktracker.backend.controllers;

import com.github.tasktracker.backend.dto.CommentDTO;
import com.github.tasktracker.backend.dto.NewTaskDTO;
import com.github.tasktracker.backend.entities.Task;
import com.github.tasktracker.backend.resources.TaskCommentListResource;
import com.github.tasktracker.backend.resources.TaskListResource;
import com.github.tasktracker.backend.services.TaskService;
import com.github.tasktracker.backend.utils.Client;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    final String clientUrl = Client.clientUrl;

    @Autowired
    private TaskService service;

    @PostMapping("/createTask")
    @CrossOrigin(origins = clientUrl)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<Boolean> createTask(@RequestBody NewTaskDTO newTaskDto) {
        Task task = new Task();
        BeanUtils.copyProperties(newTaskDto.getTask(), task);
        service.createTask(task, newTaskDto.getUser());
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @GetMapping("/getAllTaskCommentByUser/{did}/{uid}")
    @CrossOrigin(origins = clientUrl)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<TaskCommentListResource> getAllTaskCommentByUser(@PathVariable("did") Long did, @PathVariable("uid") Long uid) {
        // service call
        TaskCommentListResource trlr = service.getAllTaskCommentOfUserAndDepartment(uid, did);
        return new ResponseEntity<TaskCommentListResource>(trlr, HttpStatus.OK);
    }

    @GetMapping("/getAllTaskByUser/{did}/{uid}")
    @CrossOrigin(origins = clientUrl)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<TaskListResource> getAllTaskByUser(@PathVariable("did") Long did, @PathVariable("uid") Long uid) {
        // service call
        TaskListResource tlr = service.getAllTaskOfUserAndDepartment(uid, did);
        return new ResponseEntity<TaskListResource>(tlr, HttpStatus.OK);
    }

    @GetMapping("/getAllTaskComment")
    @CrossOrigin(origins = clientUrl)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<TaskCommentListResource> getAllTaskComment() {
        // service call
        TaskCommentListResource trlr = service.getAllTaskComment();
        return new ResponseEntity<TaskCommentListResource>(trlr, HttpStatus.OK);
    }

    @GetMapping("/getAllTaskByDepartment/{did}")
    @CrossOrigin(origins = clientUrl)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<TaskListResource> getAllTaskByDepartment(@PathVariable("did") Long did) {
        // service call
        TaskListResource tlr = service.getAllTaskByDepartment(did);
        return new ResponseEntity<TaskListResource>(tlr, HttpStatus.OK);
    }

    @PostMapping("/updateTaskStatus/{status}")
    @CrossOrigin(origins = clientUrl)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> updateTaskStatus(@PathVariable("status") String status) {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/addTaskComment/{did}/{uid}/{tid}")
    @CrossOrigin(origins = clientUrl)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> addComment(@PathVariable("did") Long did, @PathVariable("uid") Long uid, @PathVariable("tid") Long tid, @RequestBody CommentDTO comment) {
        // service call
        service.addComment(uid, did, tid, comment.getComment());
        return new ResponseEntity<Boolean>(true, HttpStatus.OK);
    }

    @GetMapping("/getTaskWork/{did}/{uid}/{tid}")
    @CrossOrigin(origins = clientUrl)
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<CommentDTO> getWork(@PathVariable("did") Long did, @PathVariable("uid") Long uid, @PathVariable("tid") Long tid) {
        // service call
        CommentDTO response = service.getWork(uid, did, tid);
        return new ResponseEntity<CommentDTO>(response, HttpStatus.OK);
    }
}
