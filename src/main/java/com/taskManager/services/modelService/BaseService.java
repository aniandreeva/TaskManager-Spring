package com.taskManager.services.modelService;

import com.taskManager.models.BaseModel;
import com.taskManager.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional
public abstract class BaseService <T extends BaseModel>{

    @Autowired
    private BaseRepository<T> repository;

    public T getById(int id) throws InstantiationException, IllegalAccessException {
        return repository.getById(id);
    }

    public List<T> getAll() {
        return repository.getAll();
    }

    public void save(T item) {
        repository.save(item);
    }

    public void delete(int id) throws IllegalAccessException, InstantiationException {
        repository.delete(id);
    }
}
