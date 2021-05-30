package com.liceu.userdatabase.services;

import com.liceu.userdatabase.model.Comment;

import java.util.List;

public interface CommentService {
    boolean addComment(String content, int userid, int blogid);
    Comment find(String username, String password);
    List<Comment> getAll(int id);
    boolean update(int id);
    List<Comment> getAnonimo(int id);}
