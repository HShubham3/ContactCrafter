package com.scm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.scm.entities.User;
import com.scm.forms.UserForm;
import com.scm.helpers.Message;
import com.scm.helpers.MessageType;
import com.scm.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

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
    public String processRegister(@Valid @ModelAttribute UserForm userForm, BindingResult rBindingResult,
            HttpSession session) {
        // fetch data
        // userForm
        // validate form data

        if (rBindingResult.hasErrors())
            return "register";

        // save to database

        // userservice
        // UserForm ----> User
        // User user = User.builder()
        // .name(userForm.getName())
        // .email(userForm.getEmail())
        // .password(userForm.getPassword())
        // .phoneNumber(userForm.getPhoneNumber())
        // .about(userForm.getAbout())
        // .profilePic(profilePic)
        // .build();

        User user = new User();
        user.setName(userForm.getName());
        user.setEmail(userForm.getEmail());
        user.setPassword(userForm.getPassword());
        user.setAbout(userForm.getAbout());
        user.setPhoneNumber(userForm.getPhoneNumber());
        user.setProfilePic(profilePic);

        User savedUser = userService.saveUser(user);

        // message add

        Message message = Message.builder().content("Registration successful").type(MessageType.green).build();

        session.setAttribute("message", message);

        // redirect to login

        return "redirect:/register";
    }
}
