package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet2")
public class Servlet2 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Get the current session object
// If a session already exists, it will be returned.
// Otherwise, a new session will be created.
        HttpSession session = req.getSession();

// 2. Print the unique session ID
        System.out.println(session.getId());

// 3. Check whether this session is newly created
// true  -> this is a new session
// false -> this session already existed
        System.out.println(session.isNew());

// 4. Get the value of "username" from the session scope
        String username = (String) session.getAttribute("username");

// 5. Print the username obtained in servlet2
        System.out.println("servlet2 got username:" + username);
    }
}
