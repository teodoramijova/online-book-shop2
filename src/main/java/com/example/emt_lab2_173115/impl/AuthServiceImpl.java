package com.example.emt_lab2_173115.impl;

import com.example.emt_lab2_173115.entity.User;
import com.example.emt_lab2_173115.repository.UserRepository;
import com.example.emt_lab2_173115.service.AuthService;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;

    public AuthServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User getCurrentUser() {
        return this.userRepository.findById(100L)
                .orElseGet(() -> {
                    User user = new User();
                    user.setFirstName("emt-user");
                    return this.userRepository.save(user);
                });
    }

    @Override
    public String getCurrentUserId() {
        return this.getCurrentUser().getFirstName();
    }

}
