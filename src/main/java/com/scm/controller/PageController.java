package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.services.UserService;

@Controller
public class PageController {

    @Autowired
    private UserService userService;

    @Value("@{${my.custom.profilepic}}")
    private String profilePic;

    @GetMapping("/register")
    public String getRegisterPage(Model model) {
        UserForm userForm = new UserForm();
        // userForm.setName("Shubham");
        model.addAttribute("userForm", userForm);
        return "register";
    }

    @GetMapping("/home")
    public String getHome() {
        return "home";
    }

    @GetMapping("/")
    public String getIndex() {
        return "index";
    }

    @GetMapping("/services")
    public String getServices() {
        return "services";
    }

    @GetMapping("/about")
    public String getAbout() {
        return "about";
    }

    // processing register

    @PostMapping("/do-register")
    public String processRegister(@ModelAttribute UserForm userForm) {
        // fetch data
        // userForm
        // validate form data
        // save to database

        // userservice
        // UserForm ----> User
        User user = User.builder()
                .name(userForm.getName())
                .email(userForm.getEmail())
                .password(userForm.getPassword())
                .phoneNumber(userForm.getPhoneNumber())
                .about(userForm.getAbout())
                .profilePic(profilePic)
                .build();

        User savedUser = userService.saveUser(user);

        System.out.println("User Saved : " + savedUser);

        // message
        // redirect to login

        return "redirect:/register";
    }
}
