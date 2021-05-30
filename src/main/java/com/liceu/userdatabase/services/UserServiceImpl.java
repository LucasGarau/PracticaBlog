package com.liceu.userdatabase.services;

import com.liceu.userdatabase.daos.UserDAO;
import com.liceu.userdatabase.daos.UserDAOJDBCImpl;
import com.liceu.userdatabase.model.User;

import java.util.List;

public class UserServiceImpl implements UserService {

    @Override
    public User addUser(String nom, String pass) {
        try {
            UserDAO cd = new UserDAOJDBCImpl();
            User user = new User(0, nom, pass);
          User user1 =  cd.add(user);
          return user1;

        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public User find(String username, String password) {
        try {
            UserDAO cd = new UserDAOJDBCImpl();
            User user = cd.getFromUser(username, password);
            return user;
        }catch (Exception e) {
            return null;
        }
    }

    @Override
    public List<User> getAll() {
            UserDAO cd = new UserDAOJDBCImpl();
            List<User> users = cd.getAll();
            return users;
        }

    @Override
    public User getfromname(String username) {
        UserDAO cd = new UserDAOJDBCImpl();
        User user = cd.getfromname(username);
        return user;
    }
    }

