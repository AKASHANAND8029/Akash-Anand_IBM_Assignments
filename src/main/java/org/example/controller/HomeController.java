package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
    @RequestMapping("/")
    public String goToHome()
    {
        return "welcome";
    }
    @RequestMapping("/hello")
    public String sayHello()
    {
        return "home";
    }
    @PostMapping("/displayForm")
    public String displayForm(@RequestParam("t1") String name, Model theModel)
    {
        theModel.addAttribute("NAME",name.toUpperCase());
        return "showData";
    }
}