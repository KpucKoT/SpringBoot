package com.example.spring.dao;

import com.example.spring.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public class UserDaoImpl implements UserDao{

    @PersistenceContext
    private EntityManager entityManager;


    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }


    public void createUser(User user) {
        entityManager.persist(user);
    }


    public void updateUser(User user) {
        entityManager.merge(user);
    }


    public void deleteUser(User user) {
        //entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        entityManager.remove(user);
    }


    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }


}
