package com.liceu.userdatabase.services;

import com.liceu.userdatabase.daos.CommentDAO;
import com.liceu.userdatabase.daos.CommentDAOImpl;
import com.liceu.userdatabase.model.Comment;

import java.util.List;

public class CommentServiceImpl implements CommentService {

    private Object Comment;

    @Override
    public boolean addComment(String content, int userid, int postid) {
        try {
            CommentDAO cd = new CommentDAOImpl();
            Comment comment = new Comment(0, content, userid , postid, null );
            cd.add(comment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean update(int id) {
        try {
            CommentDAO cd = new CommentDAOImpl();
            Comment comment = new Comment(id, null, 0 , 0, null );
            cd.update(comment);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public Comment find(String name, String password) {
        CommentDAO cd = new CommentDAOImpl();
        Comment comment = cd.getFromBlog(name);
        return comment;
    }

    @Override
    public List<Comment> getAll(int id) {
            CommentDAO cd = new CommentDAOImpl();
            List<Comment> comments = cd.getAll(id);
            return comments;
        }

    @Override
    public List<Comment> getAnonimo(int id) {
        CommentDAO cd = new CommentDAOImpl();
        List<Comment> comments = cd.getAnonimo(id);
        return comments;
    }
    }

