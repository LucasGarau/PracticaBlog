package com.liceu.userdatabase.daos;

import com.liceu.userdatabase.model.Blog;
import com.liceu.userdatabase.model.Post;

import java.util.List;

public interface PostDAO {
    List<Post> getAll(int id);
    void add(Post c, String id);
    void delete(int id);
    void update(Post c);
    Post getFromId(int id);
    Post getFromUpdate(int id);
    void share(String id, String idname);

}
