package com.example.pp_3_1_1.dao;

import com.example.pp_3_1_1.model.User;

import java.util.List;

public interface UserDao {
    List<User> getAllUsers();

    User getUserId(long id);

    void saveUser(User user);

    void deleteUser(long id);

    void updateUser(User user);
}
