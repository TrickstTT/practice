package com.trickster.thymeleaf.controller;

import com.trickster.thymeleaf.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController {
    @RequestMapping(value = {"", "index"})
    public String goIndex(Model model){
        addUser(model);
        return "index";
    }
    private void addUser(Model model){
        List<User> users = new ArrayList<>();
        users.add(new User(1L, "Tom", 23));
        users.add(new User(2L, "Jack", 24));
        model.addAttribute("users",users);
    }
}
