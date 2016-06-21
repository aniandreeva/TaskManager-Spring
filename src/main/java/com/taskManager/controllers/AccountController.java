package com.taskManager.controllers;

import com.taskManager.models.User;
import com.taskManager.services.AuthenticationService;
import com.taskManager.services.modelService.UserService;
import com.taskManager.viewModels.account.AccountLoginVM;
import com.taskManager.viewModels.account.AccountRegisterVM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class AccountController {

    @Autowired
    UserService userService;

    @RequestMapping("/")
    public ModelAndView home() {
        return new ModelAndView("redirect:account/login");
    }

    @RequestMapping(value = "account/login", method = RequestMethod.GET)
    public ModelAndView login() {
        AccountLoginVM model = new AccountLoginVM();

        return new ModelAndView("account/login", "model", model);
    }

    @RequestMapping(value = "account/login", method = RequestMethod.POST)
    public ModelAndView login(@ModelAttribute("model") @Valid AccountLoginVM model, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("account/login", "model", model);
        }

        AuthenticationService.setLoggedUser(userService.getByUsernameAndPassword(model.getUsername(), model.getPassword()));

        if (AuthenticationService.getLoggedUser() != null) {
            return new ModelAndView("redirect:/tasks/list");
        } else {
            result.reject("model", "Invalid username or password!");

            return new ModelAndView("account/login", "model", model);
        }
    }

    @RequestMapping(value = "account/register", method = RequestMethod.GET)
    public ModelAndView register() {
        return new ModelAndView("account/register", "model", new User());
    }

    @RequestMapping(value = "account/register", method = RequestMethod.POST)
    public ModelAndView register(@ModelAttribute("model") @Valid AccountRegisterVM model, BindingResult result) {
        if (result.hasErrors()) {
            return new ModelAndView("account/register", "model", model);
        }

        User user = new User();

        if (userService.isUserExist(user)) {
            result.reject("model", "User already exists!");

            return new ModelAndView("account/register", "model", model);
        }

        user.setUsername(model.getUsername());
        user.setPassword(model.getPassword());

        userService.save(user);

        return new ModelAndView("redirect:/account/login");
    }

    @RequestMapping(value = "account/logout", method = RequestMethod.GET)
    public ModelAndView logout() {
        AuthenticationService.logout();

        return new ModelAndView("redirect: login");
    }
}