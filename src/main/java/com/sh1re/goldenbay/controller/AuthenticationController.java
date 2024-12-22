package com.sh1re.goldenbay.controller;

import com.sh1re.goldenbay.dto.LoginRequest;
import com.sh1re.goldenbay.dto.LoginResponse;
import com.sh1re.goldenbay.security.JwtUtil;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthenticationController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;


    public AuthenticationController(AuthenticationManager authenticationManager, JwtUtil jwtUtil,
                                    UserDetailsService userDetailsService) {
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword())
        );

        String jwt = jwtUtil.generateToken(userDetailsService.loadUserByUsername(loginRequest.getUsername()));
        return ResponseEntity.ok(new LoginResponse(jwt));
    }

//    @GetMapping("/login")
//    public ResponseEntity<LoginResponse> JwtParser(LoginResponse loginResponse) {
//        return ResponseEntity.ok(new LoginResponse())
//    }
}
