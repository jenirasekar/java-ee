package com.jenira.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

//@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get request parameters
        String username = req.getParameter("username");
        System.out.println(username);
        // Get data in request scope
        String reqMessage = (String)req.getAttribute("reqKey");
        System.out.println(reqMessage);
        // Send response
        resp.getWriter().write("servletB response");
    }
}