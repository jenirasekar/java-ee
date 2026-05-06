package com.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
// Get data from the request scope
        String reqMessage = (String) req.getAttribute("request");
        System.out.println("Request scope: " + reqMessage);

// Get data from the session scope
        HttpSession session = req.getSession();
        String sessionMessage = (String) session.getAttribute("session");
        System.out.println("Session scope: " + sessionMessage);

// Get data from the application scope
        ServletContext application = getServletContext();
        String appMessage = (String) application.getAttribute("application");
        System.out.println("Application scope: " + appMessage);
    }
}
