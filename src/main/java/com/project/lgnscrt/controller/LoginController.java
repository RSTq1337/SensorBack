package com.project.lgnscrt.controller;

import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")

public class LoginController {

    @GetMapping("/login")
    public boolean login() {
        return true;
    }
}


