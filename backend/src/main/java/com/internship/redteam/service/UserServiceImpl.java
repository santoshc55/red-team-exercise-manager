package com.internship.redteam.service;

import com.internship.redteam.entity.User;
import com.internship.redteam.repository.UserRepository;
import com.internship.redteam.exception.UserNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(User user) {

        if (user.getEmail() == null || user.getEmail().isEmpty()) {
            throw new RuntimeException("Email cannot be empty");
        }

        return userRepository.save(user);
    }

    @Override
    public User getUserByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new UserNotFoundException("User not found"));
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
}