package com.liceu.userdatabase.controllers;
import com.liceu.userdatabase.model.User;
import com.liceu.userdatabase.services.*;
import org.jsoup.Jsoup;
import org.jsoup.safety.Whitelist;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/foro")
public class ListpostServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService cs = new PostServiceImpl();
        BlogService cs2 = new BlogServiceImpl();



        req.setAttribute("blog", cs2.getfromblog(Integer.parseInt(req.getParameter("id"))));
        req.setAttribute("listpost", cs.getAll(Integer.parseInt(req.getParameter("id"))));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/listforo.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService cs = new PostServiceImpl();
        boolean noerror = cs.erase(Integer.parseInt( req.getParameter("postid")));

        if (noerror) {
            resp.sendRedirect(req.getContextPath() + "/foro?id="+req.getParameter("blogid"));
            return;
        }

        req.setAttribute("noerror", noerror);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/listforo.jsp");
        dispatcher.forward(req, resp);

    }
}
