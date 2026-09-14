package com.example.task;
import com.example.task.EmailValidator ;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TaskServiceImpl implements TaskService {
    private final EmailValidator emailValidator ;
    //dependency injection of the repository
    private final TaskRepository taskRepository ;
    public TaskServiceImpl(TaskRepository taskRepository, EmailValidator emailValidator){
        this.taskRepository = taskRepository ;
        this.emailValidator = emailValidator;
    }


    @Override
    public String addTasks(Task task) throws EmailInvalidException {
        if(!emailValidator.ValidateEmail(task.getUserEmail()))
            throw new EmailInvalidException("Invalid Email");
        taskRepository.save(task) ;
        return "Task added successfully " ;
    }

    @Override
    public List<Task> getTasks() {
        return taskRepository.findAll();
    }

    @Override
    public Task updateTasks(String taskName , Status status) {
        if(!taskRepository.existsByTitle(taskName)) throw new RuntimeException("not found") ;
        Task taskToUpdate = taskRepository.findByTitle(taskName) ;
        taskToUpdate.setStatus(status);
        Task updatedTask = taskRepository.save(taskToUpdate) ;
        return updatedTask ;
    }
}
