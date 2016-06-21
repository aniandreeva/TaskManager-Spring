package com.taskManager.viewModels.tasks;

import com.taskManager.enums.TaskStatusEnum;
import com.taskManager.models.User;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Pattern;

public class TasksEditVM {

    private int id;

    @NotEmpty(message = "Title is required!")
    @Pattern(regexp = "^([A-z-_. 0-9])+$", message = "Title should consist only letters, dashes, underscores and fullstops.")
    private String title;

    @NotEmpty(message = "Content is required!")
    @Pattern(regexp = "^([A-z-_. 0-9])+$", message = "Content should consist only letters, dashes, underscores and fullstops.")
    private String content;

    private TaskStatusEnum status;

    private int userId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public void setStatus(TaskStatusEnum status) {
        this.status = status;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
