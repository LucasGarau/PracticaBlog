package com.liceu.userdatabase.controllers;

import com.liceu.userdatabase.model.User;
import com.liceu.userdatabase.services.UserService;
import com.liceu.userdatabase.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/setup")
public class AddRoot extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService cs = new UserServiceImpl();
        req.setAttribute("root", cs.getfromname("root"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/addroot.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService cs = new UserServiceImpl();
        User user1 = cs.addUser(
                "root",
                req.getParameter("pass"));
        if (user1 != null) {
            resp.sendRedirect(req.getContextPath() + "/selectorforo");
            return;
        }

        req.setAttribute("noerror", "noerror");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/adduser.jsp");
        dispatcher.forward(req, resp);

    }
}
