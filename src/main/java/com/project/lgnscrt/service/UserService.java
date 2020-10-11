package com.project.lgnscrt.service;

import com.project.lgnscrt.entity.User;
import com.project.lgnscrt.repo.UserRepository;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmailAndPassword(String name, String password) {
        return userRepository.findByNameAndPassword(name, password).orElse(null);
    }

    public User findByEmail(String name) {
        return userRepository.findByName(name).orElse(null);
    }
}
