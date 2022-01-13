package app.todo.webapi.controllers;

import app.todo.storage.TaskRepository;
import app.todo.webapi.models.Task;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
        for (app.todo.storage.entities.Task task : tasks) {
            var mapped = new Task();
            mapped.setTaskId(task.getTaskId());
            mapped.setName(task.getName());
            mapped.setDueDate(task.getDueDate());
            mapped.setCompletedDate(task.getCompletedDate());

            results.add(mapped);
        }

        return results;
    }

    @PostMapping("/tasks")
    public @ResponseBody Task addTask(@RequestBody Task task) {
        var mapped = new app.todo.storage.entities.Task();
        mapped.setName(task.getName());
        mapped.setDueDate(task.getDueDate());
        mapped.setCompletedDate(task.getCompletedDate());

        var saved = taskRepository.save(mapped);
        task.setTaskId(saved.getTaskId());

        return task;
    }

}
