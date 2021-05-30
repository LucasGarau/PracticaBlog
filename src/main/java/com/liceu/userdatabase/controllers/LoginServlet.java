package com.liceu.userdatabase.controllers;

import com.liceu.userdatabase.model.User;
import com.liceu.userdatabase.services.UserService;
import com.liceu.userdatabase.services.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {




    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

    @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("nom");
        String password = request.getParameter("pass");
        UserService userService = new UserServiceImpl();
        ArrayList<String> messages = new ArrayList<String>();

        if (username == null || username.isEmpty()) {
            messages.add("Please enter username");
        }

        if (password == null || password.isEmpty()) {
            messages.add("Please enter password");
        }

        if (messages.isEmpty()) {
            User user = userService.find(username, password);

            if (user != null) {
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "/selectorforoprivate");
                return;
            } else {
                messages.add("Unknown login, please try again");
            }
        }

        request.setAttribute("messages", messages);
        request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
    }

}