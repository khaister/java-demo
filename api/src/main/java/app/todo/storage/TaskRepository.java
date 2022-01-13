package app.todo.storage;

import org.springframework.data.repository.CrudRepository;

import app.todo.storage.entities.Task;

public interface TaskRepository extends CrudRepository<Task, Integer> {
    
}
