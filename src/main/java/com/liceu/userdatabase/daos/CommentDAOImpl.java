package com.liceu.userdatabase.daos;

import com.liceu.userdatabase.database.Database;
import com.liceu.userdatabase.model.Comment;
import org.commonmark.node.Node;
import org.commonmark.parser.Parser;
import org.commonmark.renderer.html.HtmlRenderer;
import org.owasp.html.HtmlPolicyBuilder;
import org.owasp.html.PolicyFactory;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class CommentDAOImpl implements CommentDAO {


    @Override
    public List<Comment> getAll(int id) {
        List<Comment> result = new ArrayList<>();
        try {
            Connection c = Database.getConnection();

            PreparedStatement ps = c.prepareStatement("select comments.postid,comments.commentID,comments.content,comments.userid,users.nom from comments INNER JOIN users ON comments.userid = users.id where postid=(?) AND userid !=3");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                Parser parser = Parser.builder().build();
                HtmlRenderer renderer = HtmlRenderer.builder().build();
                String content = rs.getString("content");
                Node document = parser.parse(content);

                result.add(new Comment(rs.getInt("commentID"),renderer.render(document),rs.getInt("userid"),rs.getInt("postid"),rs.getString("nom")));
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }

    public List<Comment> getAnonimo(int id) {
        List<Comment> result = new ArrayList<>();
        try {
            Connection c = Database.getConnection();

            //select comments.postid,comments.commentID,comments.content,comments.userid,post.Titulo from comments INNER JOIN post ON comments.postid = post.Postid where userid=3 AND blogid=2;
            PreparedStatement ps = c.prepareStatement("select comments.postid,comments.commentID,comments.content,comments.userid,post.Titulo from comments INNER JOIN post ON comments.postid = post.Postid where userid=3 and blogid=(?)");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {

                PolicyFactory policy = new HtmlPolicyBuilder().toFactory();
                String blognamesafe = policy.sanitize(rs.getString("titulo"));
                if (blognamesafe.equals("")){
                    blognamesafe="Nombre por defecto";
                };

                result.add(new Comment(rs.getInt("commentID"),rs.getString("content"),rs.getInt("userid"),rs.getInt("postid"),blognamesafe));
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public void add(Comment c) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into comments (content,userid,postid) values (?,?,?)");
            System.out.println(c.getCos());
            ps.setString(1, c.getCos());
            ps.setInt(2, c.getUserid());
            ps.setInt(3, c.getPostid());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void delete(Comment c) {

    }

    @Override
    public void update(Comment c) {
        try {
            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("Update comments set userid=2 where commentID=?");
            ps.setInt(1, c.getId());
            ps.execute();
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Comment getFromBlog(String name) {
        try {

            Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from Blog where BlogName=(?)" );
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
                rs.next();
            Comment comment =new Comment(rs.getInt("commentID"),rs.getString("content"),rs.getInt("userid"),rs.getInt("postid"),null);
                ps.close();
                return comment;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
