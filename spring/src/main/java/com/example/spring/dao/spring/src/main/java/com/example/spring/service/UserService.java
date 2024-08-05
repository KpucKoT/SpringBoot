package com.example.spring.service;

import com.example.spring.model.User;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    void createUser(User user);

    User updateUser(int id, User user);

   void deleteUser(int id, User user);

    User getUser(int id);


}
