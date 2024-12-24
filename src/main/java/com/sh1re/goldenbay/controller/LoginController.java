package com.sh1re.goldenbay.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;



@Controller
public class LoginController {

    @PostMapping("/login")
    public String login() {
        return "/auth/login"; // Maps to login.html
    }

    @GetMapping("/login")
    public String loginGet() {
        return "login";
    }

}