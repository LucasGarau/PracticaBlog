package com.liceu.userdatabase.controllers;



import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class TransactionFilter implements Filter {
@Override
    public void doFilter(
      ServletRequest request,
      ServletResponse response,
      FilterChain chain) throws IOException, ServletException {
 
        HttpServletRequest req = (HttpServletRequest) request;
          req.getRequestURI();

        try {
            chain.doFilter(request, response);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
        req.getRequestURI();

    }
}
