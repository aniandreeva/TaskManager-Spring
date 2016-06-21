package com.taskManager.services.modelService;

import com.taskManager.models.User;
import com.taskManager.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class UserService extends BaseService<User> {

    @Autowired
    UsersRepository usersRepository;

    public User getByUsernameAndPassword(String username, String password) {
        return usersRepository.getByUsernameAndPassword(username, password);
    }

    public boolean isUserExist(User user) {
        return usersRepository.isUserExist(user);
    }
}
