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

@WebServlet(value="/adduser")
public class AddUser extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/adduser.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService cs = new UserServiceImpl();
        User user = cs.addUser(
                req.getParameter("nom"),
                req.getParameter("pass"));

        if (user !=null) {
            resp.sendRedirect(req.getContextPath() + "/selectorforo");
            req.setAttribute("noerror", "noerror");
            return;
        }
        else{
            req.setAttribute("messages", "Usuario no valido");
        }

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/adduser.jsp");
        dispatcher.forward(req, resp);


    }
}
