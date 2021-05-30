package com.liceu.userdatabase.services;

import com.liceu.userdatabase.model.Blog;
import com.liceu.userdatabase.model.User;

import java.util.List;

public interface BlogService {
    boolean addBlog(String BlogName, int userid);
    Blog find(String username, String password);
    List<Blog> getAll();
    List<Blog> getOne(int id);
    Blog getfromblog(int id);}

