package com.sh1re.goldenbay.controller;

import jakarta.servlet.http.HttpServletResponse; 
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.IOException;

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

//    @GetMapping("/login")
//    public void login(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/auth/login");
//    }
}

//package com.sh1re.goldenbay.controller;

//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.AuthenticationException;
//import org.springframework.web.bind.annotation.*;
//
//import java.io.IOException;
//
//@RestController
//@RequestMapping("/auth")
//public class LoginController {

//    @Autowired
//    private AuthenticationManager authenticationManager;

//    @GetMapping("/login")
//    public void login(HttpServletResponse response) throws IOException {
//        response.sendRedirect("/auth/login");
//    }

//    @PostMapping("/login")
//    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
//        try {
//            Authentication authentication = authenticationManager.authenticate(
//                    new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
//            );
//            // Generate JWT token or handle successful authentication
//            return ResponseEntity.ok("Login successful");
//        } catch (AuthenticationException e) {
//            return ResponseEntity.status(401).body("Invalid credentials");
//        }

//    }
//}