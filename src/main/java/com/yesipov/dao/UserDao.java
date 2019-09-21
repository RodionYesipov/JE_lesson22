package com.yesipov.dao;

import com.yesipov.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Queue;

public class UserDao {
    private SessionFactory sessionFactory;

    public UserDao() {
        sessionFactory = new Configuration().configure().buildSessionFactory();
    }

    public void close() {
        sessionFactory.close();
    }

    public void addUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        }
    }

    public void updateUser(User user) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.update(user);
            transaction.commit();
        }
    }

    public User getUser(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("FROM User WHERE id = :id ", User.class)
                    .setParameter("id", id)
                    .getSingleResult();
        }
    }

    public List<User> getAllUsers() {
        try (Session session = sessionFactory.openSession()) {
            return session
                    .createQuery("FROM User", User.class)
                    .list();
        }
    }

    public void removeUserByName(String name) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session
                    .createQuery("DELETE FROM User WHERE name = :name ")
                    .setParameter("name", name)
                    .executeUpdate();
            transaction.commit();
        }
    }

    public void removeUser(int id) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session
                    .createQuery("DELETE FROM User WHERE id = :id ")
                    .setParameter("id", id)
                    .executeUpdate();
            transaction.commit();
        }
    }

    public void removeAll() {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            String hql = String.format("DELETE FROM %s", User.class.getSimpleName());
            Query query = session.createQuery(hql);
            query.executeUpdate();
            transaction.commit();
        }
    }

    public int getMinId() {
        try (Session session = sessionFactory.openSession()) {
            return (int) session
                    .createQuery("SELECT MIN(id) FROM User")
                    .getSingleResult();
        }
    }
}
