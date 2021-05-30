package com.liceu.userdatabase.daos;

import com.liceu.userdatabase.database.Database;
import com.liceu.userdatabase.model.User;
import org.apache.commons.codec.digest.DigestUtils;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDAOJDBCImpl implements UserDAO {


    @Override
    public List<User> getAll() {
        List<User> result = new ArrayList<>();
        try {
            Connection c = Database.getConnection();
            System.out.println(c);
            PreparedStatement ps = c.prepareStatement("select id,nom from users");
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String nom = rs.getString("nom");
                result.add(new User(id,nom));
            }
            ps.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
    public User add(User c) {
        try {

            Connection conn = Database.getConnection();
            PreparedStatement ps = conn.prepareStatement("insert into users (nom,pass) values (?,?)");
          //  String pass = Crypt.crypt(c.getPass());


           // System.out.println(pass);
            ps.setString(1, c.getNom());
            ps.setString(2, DigestUtils.md5Hex(c.getPass()));
            ps.execute();
            ps.close();
            return c;
        } catch(SQLIntegrityConstraintViolationException e) {
            System.out.println("Nombre de usuario ya en uso");
            return null;
    } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

    @Override
    public void delete(User c) {

    }

    @Override
    public void update(User c) {

    }

    @Override
    public User getFromUser(String name, String password) {
        try {
            User user = new User();
            Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from users where nom=(?) and pass=(?)" );
            ps.setString(1,name);
            ps.setString(2,DigestUtils.md5Hex(password));
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {

                int id = rs.getInt("id");
                String userid = rs.getString("nom");
                String pass = rs.getString("pass");
                if (userid.equals(name) & pass.equals(DigestUtils.md5Hex(password))) {
                    user.setId(id);
                    user.setNom(userid);
                    user.setPass(pass);
                } else {
                    return null;
                }
                ps.close();
                return user;
            } else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }

    @Override
    public User getfromname(String name) {
        try {

            Connection c = Database.getConnection();
            PreparedStatement ps = c.prepareStatement("select * from users where nom=(?)" );
            ps.setString(1, name);
            ResultSet rs = ps.executeQuery();
            if ( rs.next()) {

                User user = new User(rs.getInt("id"), rs.getString("nom"), null);
                ps.close();
                return user;
            }
            else return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;

        }
    }
}
