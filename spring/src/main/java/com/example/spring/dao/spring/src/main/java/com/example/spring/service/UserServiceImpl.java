package com.example.spring.service;

import com.example.spring.dao.UserDao;
import com.example.spring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@EnableTransactionManagement
public class UserServiceImpl implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    @Transactional
    public void createUser(User user) {
        if (0 == user.getId()) {
            userDao.createUser(user);
        }
    }

    @Override
    @Transactional
    public User updateUser(int id, User user){
        userDao.updateUser(user);
        return user;
    }


    @Override
    @Transactional
    public void deleteUser(int id, User user) {
        userDao.deleteUser(user);
    }

    @Override
    public User getUser(int id) {
        return userDao.getUser(id);
    }
}
