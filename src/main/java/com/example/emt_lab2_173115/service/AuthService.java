package com.example.emt_lab2_173115.service;

import com.example.emt_lab2_173115.entity.User;

public interface AuthService {
    User getCurrentUser();
    String getCurrentUserId();
}

