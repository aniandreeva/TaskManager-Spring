package com.taskManager.services.modelService;

import com.taskManager.models.Task;
import com.taskManager.services.AuthenticationService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class TaskService extends BaseService<Task>{

    public List<Task> getAllById(int userId) {
        return getAll().stream().filter(t->t.getUser().getId()== AuthenticationService.getLoggedUser().getId()).collect(Collectors.toCollection(ArrayList<Task>::new));
    }
}
