package com.absjuniordev.controller;

import com.absjuniordev.domain.model.User;
import com.absjuniordev.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class ThymeleafController {
    @Autowired
    private UserService userService;

    @GetMapping("/hello")
    public String hello(Model model) {
        model.addAttribute("nome", "Mundo");
        return "index";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@ModelAttribute User user) {
        userService.create(user);
        return "redirect:/success";
    }

    @GetMapping("/success")
    public String showSuccessPage() {
        return "success";
    }

    @GetMapping("/list")
    public String listUsers(Model model) {
        Iterable<User> users = userService.findAll();
        model.addAttribute("users", users);
        model.addAttribute("isEmpty", !users.iterator().hasNext());
        return "clients";
    }


    @GetMapping("/detail/{id}")
    public String detailClients(@PathVariable Long id, Model model) {
        User user = userService.findById(id);
        model.addAttribute("user", user);
        return "detail-clients";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable Long id) {
        userService.deleteById(id);
        return "redirect:/list";
    }



}
