package com.internship.redteam.service;

import com.internship.redteam.entity.User;
import java.util.List;

public interface UserService {

    User createUser(User user);

    User getUserByEmail(String email);

    List<User> getAllUsers();
}