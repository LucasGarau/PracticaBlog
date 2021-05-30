package com.liceu.userdatabase.services;

import com.liceu.userdatabase.model.Post;

import java.util.List;

public interface PostService {
    List<Post> getAll(int id);
    Post getFromId(int id);
    Post getFromupdate(int id);
    boolean addService(String blogid, String titol, String cos,int id);
    boolean erase(int id);
    boolean update( String titol, String cos,  int id);
    boolean share(String id, String idname);

}
