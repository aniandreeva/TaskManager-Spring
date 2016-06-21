package com.taskManager.viewModels.account;

import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class AccountRegisterVM {

    private int id;

    @NotEmpty(message = "Username is required!")
    @Size(min=6, max = 25, message = "Username must be between 6 and 25 chars")
    @Pattern(regexp = "^([A-z-_.0-9])+$", message = "Username should consist only letters, dashes, underscores and fullstops.")
    private String username;

    @NotEmpty(message = "Password is required!")
    @Size(min=6, max = 25, message = "Password must be between 6 and 25 chars")
    @Pattern(regexp = "^([A-z-_.0-9])+$", message = "Password should consist only letters, dashes, underscores and fullstops.")
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
