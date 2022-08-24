package com.example.pp_3_1_1.service;

import com.example.pp_3_1_1.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User getUserId(long id);

    void saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);
}
