package com.nbms.bank.controllers;

import com.nbms.bank.entitis.User;
import com.nbms.bank.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {

    @Autowired
    private UserService service;

    @GetMapping("/login")
    public String login(){

        return "login";
    }
    @GetMapping("/sign")
    public String signin(){

        return "login";
    }
    @GetMapping("/signup")
    public String signup(Model model){
        model.addAttribute("user",new User());
        return "signup";
    }
    @PostMapping("/signup")
    public String register(@Valid @ModelAttribute User user, BindingResult bindingResult){
        if(bindingResult.hasErrors())
        {
            return "signup";
        }

        User usr = service.save(user);
        if(usr!=null)
        return "redirect:/login";
        else
            return "signup";

        // if succeed registration you should show alert
    }
    
}
