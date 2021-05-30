package com.liceu.userdatabase.daos;


import com.liceu.userdatabase.model.Blog;
import com.liceu.userdatabase.model.User;

import java.util.List;

public interface BlogDAO {
    List<Blog> getAll();
    List<Blog> getOne(int id);
    void add(Blog c);
    void delete(Blog c);
    void update(Blog c);
    Blog getFromBlog(int id);
}
