package com.liceu.userdatabase.controllers;

import com.liceu.userdatabase.model.User;
import com.liceu.userdatabase.services.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/selectorforo")
public class SelectorForoServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogService cs = new BlogServiceImpl();
        req.setAttribute("blogs", cs.getAll());
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/bloglist.jsp");
        dispatcher.forward(req, resp);
    }
}
