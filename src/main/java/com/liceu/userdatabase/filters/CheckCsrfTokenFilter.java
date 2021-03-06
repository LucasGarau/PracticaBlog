package com.liceu.userdatabase.filters;

import com.google.common.cache.Cache;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebFilter(urlPatterns = {"/updatepost","/addpost","/addblog"})
public class CheckCsrfTokenFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpSession session = req.getSession();

        if (req.getMethod().equalsIgnoreCase("POST")) {
            String tokenFromRequest = req.getParameter("_csrftoken");
            Cache<String, Boolean> tokenCache = (Cache<String, Boolean>) session.getAttribute("tokenCache");
            if ((tokenCache == null) || (tokenCache.getIfPresent(tokenFromRequest) == null)) {
                throw new ServletException("Error CSRF");
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
