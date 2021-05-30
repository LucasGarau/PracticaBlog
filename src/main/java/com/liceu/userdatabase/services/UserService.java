package com.liceu.userdatabase.services;

import com.liceu.userdatabase.model.User;

import java.util.List;

public interface UserService {
    User addUser(String nom, String pass);

    User find(String username, String password);
    List<User> getAll();

    User getfromname(String username);
}
