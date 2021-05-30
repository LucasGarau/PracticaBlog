package com.liceu.userdatabase.daos;

import com.liceu.userdatabase.database.Database;
import com.liceu.userdatabase.model.Blog;
import com.liceu.userdatabase.model.User;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class BlogDAOJDBCImpl implements BlogDAO {


    @Override
    public List<Blog> getAll() {
        List<Blog> result = new ArrayList<>();
        try {
            Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement("select Blogid,BlogName,userid from blog");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Blogid = rs.getInt("Blogid");
                String BlogName = rs.getString("BlogName");
                int userid = rs.getInt("userid");

                PolicyFactory policy = new HtmlPolicyBuilder().toFactory();
                String blognamesafe = policy.sanitize(BlogName);
                    if (blognamesafe.equals("")){
                        blognamesafe="Nombre por defecto";
                    };
                result.add(new Blog(Blogid,blognamesafe,userid));
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public List<Blog> getOne(int id) {
        List<Blog> result = new ArrayList<>();
        try {
            Connection c = Database.getConnection();
            System.out.println(c);
            PreparedStatement ps = c.prepareStatement("select Blogid,BlogName,userid from blog where userid=(?)");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int Blogid = rs.getInt("Blogid");
                String BlogName = rs.getString("BlogName");
                int userid = rs.getInt("userid");

                PolicyFactory policy = new HtmlPolicyBuilder().toFactory();
                String blognamesafe = policy.sanitize(BlogName);
                if (blognamesafe.equals("")){
                    blognamesafe="Nombre por defecto";
                };

                result.add(new Blog(Blogid,blognamesafe,userid));
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    @Override
    public void add(Blog c) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into blog (BlogName,userid) values (?,?)");
            ps.setString(1, c.getNom());
            ps.setInt(2, c.getUserid());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Blog c) {

    }

    @Override
    public void update(Blog c) {

    }

    @Override
    public Blog getFromBlog(int id) {
        try {

            Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from Blog where BlogId=(?)" );
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
                rs.next();
                int Blogid = rs.getInt("Blogid");
                String BlogName = rs.getString("BlogName");
                int userid = rs.getInt("userid");

            PolicyFactory policy = new HtmlPolicyBuilder().toFactory();
            String blognamesafe = policy.sanitize(BlogName);
            if (blognamesafe.equals("")){
                blognamesafe="Nombre por defecto";
            };


                Blog blog = new Blog(Blogid,blognamesafe,userid);
                ps.close();
                return blog;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
