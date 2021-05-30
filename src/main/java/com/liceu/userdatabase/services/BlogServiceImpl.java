package com.liceu.userdatabase.services;

import com.liceu.userdatabase.daos.BlogDAO;
import com.liceu.userdatabase.daos.BlogDAOJDBCImpl;
import com.liceu.userdatabase.daos.UserDAO;
import com.liceu.userdatabase.daos.UserDAOJDBCImpl;
import com.liceu.userdatabase.model.Blog;
import com.liceu.userdatabase.model.User;

import java.util.List;

public class BlogServiceImpl implements BlogService {

    @Override
    public boolean addBlog(String nom, int userid) {
        try {
            BlogDAO cd = new BlogDAOJDBCImpl();
            Blog blog = new Blog(0, nom, userid);
            cd.add(blog);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Blog find(String name, String Pass) {
        BlogDAO cd = new BlogDAOJDBCImpl();
        Blog blog= null;
      //  Blog blog = cd.getFromBlog(name);
        return blog;
    }

    @Override
    public List<Blog> getAll() {
            BlogDAO cd = new BlogDAOJDBCImpl();
            List<Blog> blogs = cd.getAll();
            return blogs;
        }

    @Override
    public List<Blog> getOne(int id) {
        BlogDAO cd = new BlogDAOJDBCImpl();
        List<Blog> blogs = cd.getOne(id);
        return blogs;
    }

    @Override
    public Blog getfromblog(int id) {
        BlogDAO cd = new BlogDAOJDBCImpl();
        Blog blog = cd.getFromBlog(id);
        return blog;    }
}

