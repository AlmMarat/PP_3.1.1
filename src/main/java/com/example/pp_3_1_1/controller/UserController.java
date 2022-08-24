package com.example.pp_3_1_1.controller;

import com.example.pp_3_1_1.model.User;
import com.example.pp_3_1_1.service.UserService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

@Controller
@RequestMapping(value = "/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String allUsers(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        return "/users";
    }

    @PostMapping
    public String addUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:/users";
    }

    @GetMapping("/new")
    public String newUser (@ModelAttribute ("user") User user) {
        return "/new";
    }

    @DeleteMapping(value = "/{id}")
    public String removeUser(@PathVariable("id") int id) {
        userService.deleteUser(id);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String updateUserForm(Model model, @PathVariable ("id") long id) {
        model.addAttribute("user", userService.getUserId(id));
        return "/edit";
    }

    @PatchMapping("/{id}")
    public String updateUserFrom(@ModelAttribute ("user") User user, @PathVariable("id") long id) {
        userService.updateUser(user);
        return "redirect:/users";
    }

    @GetMapping("/show/{id}")
    public String showUser(Model model, @PathVariable ("id") long id) {
        model.addAttribute("user", userService.getUserId(id));
        return "/show";
    }
}