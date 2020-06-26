package com.example.emt_lab2_173115.service;

import com.example.emt_lab2_173115.entity.Book;
import com.example.emt_lab2_173115.entity.User;
import com.example.emt_lab2_173115.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service("userService")
public class UserService {

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public User findByConfirmationToken(String confirmationToken) {
        return userRepository.findByConfirmationToken(confirmationToken);
    }

    public User findByUsernameAndPassword(String username, String password) {
        List<User> users = userRepository.findAll();
        for (User user:users) {
            if(user.getFirstName().equals(username) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    public void saveUser(User user) {
        userRepository.save(user);
    }

}