package com.liceu.userdatabase.daos;

import com.liceu.userdatabase.database.Database;
import com.liceu.userdatabase.model.Post;
import com.liceu.userdatabase.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.commonmark.node.*;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;

public class PostDAOJDBCImpl implements PostDAO {

    @Override
    public List<Post> getAll(int id) {
        List<Post> result = new ArrayList<>();
        try {
            System.out.println(id);
            Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from post where blogid=(?)");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                int id2 = rs.getInt("PostId");
                int userid = rs.getInt("blogid");


                Parser parser = Parser.builder().build();
                HtmlRenderer renderer = HtmlRenderer.builder().build();
                String cos = rs.getString("Contenido");
                String titol = rs.getString("Titulo");

                PolicyFactory policy = new HtmlPolicyBuilder().allowElements("" +
                        "").toFactory();

                String safecos = policy.sanitize(cos);

                if (safecos.equals("")){
                    safecos="Borrado Automaticamente";
                }
                String safetitulo = policy.sanitize(titol);
                if (safetitulo.equals("")){
                    safetitulo="Borrado Automaticamente";
                }


                Node document = parser.parse(safecos);
                Node titulomarkdown = parser.parse(safetitulo);



                String date = rs.getString("Fechacreacion");
                // String modate = rs.getString("moddate");
                Date date1 = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse(date);
                Date date2;
                //  if (modate != null) {
                //     date2 = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse(modate);
                // } else {
                //     date2 = null;
                // }

                Post nota = new Post(id2, userid, renderer.render(titulomarkdown),  renderer.render(document), date1, null);
                result.add(nota);
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }


    @Override
    public void add(Post c, String id) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into post (blogid,Titulo,Contenido,Fechacreacion) values (?,?,?,?)");
            ps.setString(1, id);
            ps.setString(2, c.getTitol());
            ps.setString(3, c.getCos());
            SimpleDateFormat DateFor = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
            ps.setString(4, DateFor.format(c.getDate()));
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(int id) {

            try {
                Connection conn = Database.getConnection();
                PreparedStatement ps = conn.prepareStatement("DELETE FROM POST WHERE Postid = (?)");
                ps.setInt(1,id);
                ps.execute();
                ps.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }




    @Override
    public void update(Post c) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("Update post set Titulo=?,Contenido=? where Postid=?");
            ps.setString(1, c.getTitol());
            ps.setString(2, c.getCos());
           // SimpleDateFormat DateFor = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy");
           // ps.setString(3, DateFor.format(c.getModate()));
            ps.setInt(3, c.getId());
            //   ps.setInt(5, c.getBlogid());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Post getFromId(int id) {
        Post post = new Post();
        try {
            Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from post where Postid=(?)");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            post.setBlogid(rs.getInt("PostId"));
            post.setBlogid(rs.getInt("blogid"));

            Parser parser = Parser.builder().build();
            HtmlRenderer renderer = HtmlRenderer.builder().build();
            PolicyFactory policy = new HtmlPolicyBuilder().allowElements("" +
                    "").toFactory();
            String cos = rs.getString("Contenido");

            String safeHTML = policy.sanitize(cos);
if (safeHTML.equals("")){
    safeHTML="Automaticamente Borrado";
}
            Node document = parser.parse(safeHTML);

             String titulo = rs.getString("Titulo");

            String titulosafe = policy.sanitize(titulo);

            if (titulosafe.equals("")){
                titulosafe="Automaticamente Borrado";
            }

            Node titulomarkdown = parser.parse(titulosafe);




            post.setTitol(renderer.render(titulomarkdown));
            post.setCos(renderer.render(document));
            String date = rs.getString("Fechacreacion");
            Date date1 = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse(date);
            post.setDate(date1);
            Date date2;
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return post;
    }

    @Override
    public Post getFromUpdate(int id) {
        Post post = new Post();
        try {

            Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from post where Postid=(?)");
            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();
            rs.next();
            post.setBlogid(rs.getInt("PostId"));
            post.setBlogid(rs.getInt("blogid"));
            String cos = rs.getString("Contenido");
            post.setTitol(rs.getString("Titulo"));
            post.setCos(cos);
            String date = rs.getString("Fechacreacion");
            Date date1 = new SimpleDateFormat("HH:mm:ss dd-MM-yyyy").parse(date);
            post.setDate(date1);
            Date date2;
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return post;
    }



    @Override
    public void share(String id, String idname) {

    }
}




