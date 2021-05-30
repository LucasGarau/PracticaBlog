package com.liceu.userdatabase.controllers;

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

@WebServlet(value="/autocomments")
public class AutorizarCommentarios extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService cs = new PostServiceImpl();
        CommentService cs2 = new CommentServiceImpl();
        req.setAttribute("blogid",req.getParameter("id"));
        req.setAttribute("comments", cs2.getAnonimo(Integer.parseInt(req.getParameter("id"))));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/AutorizarComment.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CommentService cs = new CommentServiceImpl();
        boolean noerror = cs.update(Integer.parseInt( req.getParameter("commentid")));

        if (noerror) {
            resp.sendRedirect(req.getContextPath() + "/autocomments?id="+req.getParameter("blogid"));
            return;
        }

        req.setAttribute("noerror", noerror);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/AutorizarComment.jsp");
        dispatcher.forward(req, resp);

    }
}
