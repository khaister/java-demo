package com.example.storage;

import org.springframework.data.repository.CrudRepository;

import com.example.storage.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    
}
