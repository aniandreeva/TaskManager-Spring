package com.taskManager.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User extends BaseModel {

    @Column
    private String username;

    @Column
    private String password;

    @OneToMany(fetch = FetchType.LAZY)
    private List<Task> tasks;

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

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}