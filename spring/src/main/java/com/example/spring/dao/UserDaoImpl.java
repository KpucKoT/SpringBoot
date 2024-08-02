package com.example.spring.dao;

import com.example.spring.model.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@EnableTransactionManagement
@Transactional
public class UserDaoImpl implements UserDao {

    private static int USER_ID;

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> getUsers() {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public void createUser(User user) {
        entityManager.persist(user);
        entityManager.flush();
    }

    @Override
    public void updateUser(User user) {
        entityManager.merge(user);
        entityManager.flush();
    }

    @Override
    public void deleteUser(User user) {
        entityManager.remove(entityManager.contains(user) ? user : entityManager.merge(user));
        entityManager.flush();
    }

    @Override
    public User getUser(int id) {
        return entityManager.find(User.class, id);
    }

}
