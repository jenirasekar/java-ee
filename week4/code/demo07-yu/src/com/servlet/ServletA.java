package com.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Store data in the request scope
        req.setAttribute("request", "requestMessage");

// Store data in the session scope
        HttpSession session = req.getSession();
        session.setAttribute("session", "sessionMessage");

// Store data in the application scope
        ServletContext application = getServletContext();
        application.setAttribute("application", "applicationMsessage");

// Get data from the request scope
        String reqMessage = (String) req.getAttribute("request");
        System.out.println("Request scope: " + reqMessage);

// Forward the request
        req.getRequestDispatcher("servletB").forward(req, resp);
    }
}
