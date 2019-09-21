package com.yesipov;

import com.yesipov.dao.UserDao;
import com.yesipov.model.User;

import java.io.IOException;
import java.util.List;

public class UserService implements Storage {
    UserDao userDao = new UserDao();

    @Override
    public void removeAll() {
        userDao.removeAll();
    }

    @Override
    public void removeUser(int id) throws IOException {
        userDao.removeUser(id);
    }

    @Override
    public void removeUserByName(String name) throws IOException {
        userDao.removeUserByName(name);
    }

    @Override
    public void addUser(User user) throws IOException {
        userDao.addUser(user);
    }

    @Override
    public void updateUser(User user) throws IOException {
        userDao.updateUser(user);
    }

    @Override
    public User getUser(int id) throws IOException {
        return userDao.getUser(id);
    }

    @Override
    public List<User> getAllUsers() throws IOException {
        return userDao.getAllUsers();
    }

    public void close() {
        userDao.close();
    }

    public int getMinId() {
        return userDao.getMinId();
    }
}
