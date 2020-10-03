package com.project.lgnscrt.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins="http://localhost:4200")

public class LoginController {

    @PostMapping("/login")
    public Principal user(Principal user) {
        return user;
    }
}


