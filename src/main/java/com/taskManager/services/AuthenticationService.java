package com.taskManager.services;

import com.taskManager.models.User;
import com.taskManager.repositories.UsersRepository;

public class AuthenticationService {
    public static User loggedUser;

    public static User getLoggedUser() {
        return loggedUser;
    }

    public static void setLoggedUser(User LoggedUser) {
        loggedUser = LoggedUser;
    }

    public static void Authenticate(String username, String password) {
        UsersRepository userRep = new UsersRepository();
        setLoggedUser(userRep.getByUsernameAndPassword(username, password));
    }

    public static void logout(){
        loggedUser=null;
    }
}
