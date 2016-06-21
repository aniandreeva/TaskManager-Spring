package com.taskManager.repositories;

import com.taskManager.models.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class UsersRepository extends BaseRepository<User> {
    public UsersRepository() {
        super(User.class);
    }

    public User getByUsernameAndPassword(String username, String password) {
        return this.getAll().stream().filter((User) -> User.getUsername().equals(username) && User.getPassword().equals(password)).findFirst().orElse(null);
    }

    public boolean isUserExist(User user) {
        User checkedUser = this.getAll().stream().filter((User) -> User.getUsername().equals(user.getUsername())).findFirst().orElse(null);

        if (checkedUser != null) {
            return true;
        }
        return false;
    }
}