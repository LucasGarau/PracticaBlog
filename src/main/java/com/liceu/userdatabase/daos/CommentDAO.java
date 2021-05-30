package com.liceu.userdatabase.daos;


import com.liceu.userdatabase.model.Blog;
import com.liceu.userdatabase.model.Comment;

import java.util.List;

public interface CommentDAO {
    List<Comment> getAll(int id);
    List<Comment> getAnonimo(int id);
    void add(Comment c);
    void delete(Comment c);
    void update(Comment c);
    Comment getFromBlog(String name);
}
