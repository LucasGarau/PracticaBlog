package com.liceu.userdatabase.controllers;

import com.liceu.userdatabase.model.User;
import com.liceu.userdatabase.services.PostService;
import com.liceu.userdatabase.services.PostServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(value="/updatepost")
public class UpdatePost extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/updatepost.jsp");
        PostService cs = new PostServiceImpl();
        req.setAttribute("post", cs.getFromupdate(Integer.parseInt(req.getParameter("postid"))));
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PostService cs = new PostServiceImpl();
        User user1=(User)req.getSession().getAttribute("user");
        boolean noerror = cs.update(
                req.getParameter("titol"),
                req.getParameter("cos"),
               Integer.parseInt( req.getParameter("postid"))
                   );


        if (noerror) {
            resp.sendRedirect(req.getContextPath() + "/foro?id="+req.getParameter("blogid"));
            return;
        }

        req.setAttribute("noerror", noerror);
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/jsp/updatepost.jsp");
        dispatcher.forward(req, resp);

    }
}
