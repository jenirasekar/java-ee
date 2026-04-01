package com.jenira.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

//@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //  Get a request dispatcher
        //  Forward to another servlet  OK
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
        //  Forward to a view resource OK
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("welcome.html");
        //  Forward to a resource under WEB-INF  OK
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/views/view1.html");
        //  Forward to an external resource   NO
        //RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.atguigu.com");
        //  Get request parameters
        String username = req.getParameter("username");
        System.out.println(username);
        //  Put data into request scope
        req.setAttribute("reqKey","requestMessage");
        //  Perform the forward
        requestDispatcher.forward(req,resp);
    }
}
