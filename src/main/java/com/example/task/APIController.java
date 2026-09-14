package com.example.task;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api")
public class APIController {
    private final TaskService taskService ;
    public APIController(TaskService taskService){
        this.taskService = taskService ;
    }

    @GetMapping("/tasks")
    public ResponseEntity<List<Task>> getAllTasks(){
        return ResponseEntity.ok().body(taskService.getTasks()) ;
    }

    @PostMapping("/tasks")
    public ResponseEntity<String> addTask(@RequestBody Task task){
        taskService.addTasks(task) ;
        return ResponseEntity.ok().body(taskService.addTasks(task));
    }


    @PatchMapping("/tasks/{taskName}")
    public ResponseEntity<Task> updateTask(@PathVariable String taskName , @RequestBody Status status){
        return ResponseEntity.ok().body(taskService.updateTasks(taskName , status)) ;
    }
}
