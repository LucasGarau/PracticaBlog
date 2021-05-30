package com.liceu.userdatabase.daos;


import com.liceu.userdatabase.model.User;

import java.util.List;

public interface UserDAO {
    List<User> getAll();
    User add(User c);
    void delete(User c);
    void update(User c);
    User getFromUser(String name,String password);
    User getfromname(String name);
}
