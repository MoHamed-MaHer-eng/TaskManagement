package com.example.task;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TaskService {

     String addTasks(Task task);
     List<Task> getTasks() ;
     Task updateTasks(String taskName,Status status) ;

}
