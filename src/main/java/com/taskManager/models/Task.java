package com.taskManager.models;

import com.taskManager.enums.TaskStatusEnum;

import javax.persistence.*;

@Entity
@Table(name = "tasks")
public class Task extends BaseModel {

    @Column
    private String title;

    @Column
    private String content;

    @Column
    private TaskStatusEnum status;

    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="userId")
    private User user;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public TaskStatusEnum getStatus() {
        return status;
    }

    public void setStatus(TaskStatusEnum stats) {
        this.status = stats;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
