package com.liceu.userdatabase.controllers;

import com.liceu.userdatabase.model.User;
import com.liceu.userdatabase.services.BlogService;
import com.liceu.userdatabase.services.BlogServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/selectorforoprivate")
public class SelectorForoPrivateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        BlogService cs = new BlogServiceImpl();
        User user1=(User)req.getSession().getAttribute("user");
        req.setAttribute("blogs", cs.getOne(user1.getId()));
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/bloglistprivate.jsp");
        dispatcher.forward(req, resp);
    }
}
