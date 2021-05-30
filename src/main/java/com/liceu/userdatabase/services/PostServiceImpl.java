package com.liceu.userdatabase.services;

import com.liceu.userdatabase.daos.PostDAO;
import com.liceu.userdatabase.daos.PostDAOJDBCImpl;
import com.liceu.userdatabase.model.Post;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import static java.lang.Integer.parseInt;

public class PostServiceImpl implements PostService {
    @Override
    public List<Post> getAll(int id) {
        PostDAO cd = new PostDAOJDBCImpl();
        List<Post> notas = cd.getAll(id);
        return notas;
    }

    @Override
    public Post getFromId(int id) {
        PostDAO cd = new PostDAOJDBCImpl();
        Post post = cd.getFromId(id);
        return post;
    }

    @Override
    public Post getFromupdate(int id) {
        PostDAO cd = new PostDAOJDBCImpl();
        Post post = cd.getFromUpdate(id);
        return post;
    }


    @Override
        public boolean addService(String blogid, String titol, String cos,int id) {
        try {
            PostDAO cd = new PostDAOJDBCImpl();
            Post nota = new Post(0, 0, titol,cos,new Date(),null);
            cd.add(nota,blogid);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean erase(int postid) {
        try {
            PostDAO cd = new PostDAOJDBCImpl();
            cd.delete(postid);
            return true;
        } catch (Exception e) {
            return false;
        }


    }

    @Override
    public boolean update( String titol, String cos,  int id) {
        try {
            PostDAO cd = new PostDAOJDBCImpl();
            SimpleDateFormat parser=new SimpleDateFormat("EEE MMM d HH:mm:ss zzz yyyy", Locale.ENGLISH);
            //Date date1 = (Date)parser.parse(date);
            Post post = new Post( id, titol,cos);

            cd.update(post);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    @Override
    public boolean share(String id, String idname) {
        try {
            PostDAO cd = new PostDAOJDBCImpl();
            cd.share(id,idname);
            return true;
        } catch (Exception e) {
            return false;
        }

    }

}
