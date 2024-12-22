package com.sh1re.goldenbay.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard() {

        //DEBUG statement
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        System.out.println("Authentication done for: " + auth);

        return "dashboard"; // Maps to dashboard.html
    }
}
