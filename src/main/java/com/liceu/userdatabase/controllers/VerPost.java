package com.liceu.userdatabase.controllers;

import com.liceu.userdatabase.model.Post;
import com.liceu.userdatabase.model.User;
import com.liceu.userdatabase.services.CommentService;
import com.liceu.userdatabase.services.CommentServiceImpl;
import com.liceu.userdatabase.services.PostService;
import com.liceu.userdatabase.services.PostServiceImpl;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/verpost")
public class VerPost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService cs = new PostServiceImpl();
        CommentService cs2 = new CommentServiceImpl();
        req.setAttribute("post", cs.getFromId(Integer.parseInt(req.getParameter("postid"))));
        req.setAttribute("comments", cs2.getAll(Integer.parseInt(req.getParameter("postid"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/verpost.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentService cs = new CommentServiceImpl();
        User user1=(User)req.getSession().getAttribute("user");
      //  Post post1=(Post)req.getSession().getAttribute("post");
        if (user1==null){
         user1=new User(3,"Unverified","");
        }
        String bodyclean = Jsoup.clean(req.getParameter("nom"), Whitelist.relaxed());
       if (bodyclean==""){
           bodyclean="Borrado";
       }
        boolean noerror = cs.addComment(bodyclean, user1.getId(),Integer.parseInt( req.getParameter("postid")));

        if (noerror) {
            resp.sendRedirect(req.getContextPath() + "/verpost?postid="+req.getParameter("postid"));
            return;
        }

        req.setAttribute("noerror", noerror);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/verpost.jsp");
        dispatcher.forward(req, resp);

    }
}
