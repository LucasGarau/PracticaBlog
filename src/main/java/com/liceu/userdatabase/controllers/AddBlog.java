package com.liceu.userdatabase.controllers;

import com.liceu.userdatabase.model.User;
import com.liceu.userdatabase.services.BlogService;
import com.liceu.userdatabase.services.BlogServiceImpl;
import com.liceu.userdatabase.services.PostService;
import com.liceu.userdatabase.services.PostServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/addblog")
public class AddBlog extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addblog.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogService cs = new BlogServiceImpl();
        User user1=(User)req.getSession().getAttribute("user");
        boolean noerror = cs.addBlog(
                req.getParameter("nom"),
                     user1.getId());
        if (noerror) {
            resp.sendRedirect(req.getContextPath() + "/selectorforo");
            return;
        }

        req.setAttribute("noerror", noerror);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addblog.jsp");
        dispatcher.forward(req, resp);

    }
}
