package com.example.restservice.controllers;

import com.example.restservice.models.Task;
import com.example.storage.TaskRepository;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/tasks")
    public @ResponseBody Iterable<Task> getTasks() {
        var tasks = taskRepository.findAll();
        var results = new ArrayList<Task>();
        for (com.example.storage.entities.Task task : tasks) {
            var mapped = new Task();
            mapped.setTaskId(task.getTaskId());
            mapped.setName(task.getName());
            mapped.setDueDate(task.getDueDate());
            mapped.setCompletedDate(task.getCompletedDate());

            results.add(mapped);
        }

        return results;
    }

}
