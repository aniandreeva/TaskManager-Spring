package com.taskManager.repositories;

import com.taskManager.models.Task;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class TasksRepository extends BaseRepository<Task>{

    public TasksRepository() {
        super(Task.class);
    }
}