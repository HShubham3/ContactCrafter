package com.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {

    @RequestMapping("/home")
    public String getHome() {
        return "home";
    }

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }

    @RequestMapping("/services")
    public String getServices() {
        return "services";
    }

    @RequestMapping("/about")
    public String getAbout() {
        return "about";
    }
}
