package com.board.on.backend.controller;


import com.board.on.backend.entity.User;
import com.board.on.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/be/user/create")
    public String create() {
        return "usercreate";
    }
    @PostMapping("/be/user/createpro")
    public String createpro(Model model, User user) {
        userService.write(user);
        model.addAttribute("user", user);
        return "usercreate";
    }
    @GetMapping("/be/user/delete/{userName}")
    public String delete(@PathVariable("userName") String userName) {
        userService.deleteByName(userName);
        return "redirect:/be/user/create";
    }
}