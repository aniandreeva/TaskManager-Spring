package com.taskManager.controllers;

import com.taskManager.models.Task;
import com.taskManager.services.*;
import com.taskManager.services.modelService.TaskService;
import com.taskManager.viewModels.tasks.TasksEditVM;
import com.taskManager.viewModels.tasks.TasksListVM;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;


@Controller
public class TasksController {
    @Autowired
    private TaskService taskService;

    @RequestMapping(value = "tasks/list", method = RequestMethod.GET)
    public ModelAndView list() {
        TasksListVM model= new TasksListVM();

        model.setTasks(taskService.getAllById(AuthenticationService.getLoggedUser().getId()));

        return new ModelAndView("tasks/list", "model", model);
    }

    @RequestMapping(value = "tasks/edit", method = RequestMethod.GET)
    public ModelAndView edit(Integer id) throws IllegalAccessException, InstantiationException {

        Task task;

        if (id == null) {
            task = new Task();
        } else {
            task = taskService.getById(id);

            if (task == null) {
                return new ModelAndView("redirect:/tasks/edit");
            }

            if (task.getUser().getId()!=AuthenticationService.getLoggedUser().getId()){
                return new ModelAndView("redirect:/tasks/edit");
            }
        }

        ModelMapper modelMapper = new ModelMapper();
        TasksEditVM model= modelMapper.map(task, TasksEditVM.class);

        return new ModelAndView("tasks/edit", "model", task);
    }

    @RequestMapping(value = "tasks/edit", method = RequestMethod.POST)
    public ModelAndView edit(@ModelAttribute("model") @Valid TasksEditVM model, BindingResult result) throws IllegalAccessException, InstantiationException {
        if (result.hasErrors()){
            return new ModelAndView("tasks/edit", "model", model);
        }

        model.setUserId(AuthenticationService.getLoggedUser().getId());
        ModelMapper modelMapper = new ModelMapper();
        Task task = modelMapper.map(model, Task.class);

        taskService.save(task);

        return new ModelAndView("redirect:list");
    }

    @RequestMapping(value = "tasks/delete", method = RequestMethod.GET)
    public ModelAndView delete(Integer id) throws InstantiationException, IllegalAccessException {
        if (id != null) {
            Task task = taskService.getById(id);

            if (task != null && task.getUser().getId() == AuthenticationService.getLoggedUser().getId()) {
                taskService.delete(id);
            }
        }

        return new ModelAndView("redirect:list");
    }
}