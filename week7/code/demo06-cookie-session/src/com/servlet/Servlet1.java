package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        xxx/servlet1?username=javaweb
        // Example request: xxx/servlet1?username=javaweb

// 1. Get the request parameter "username"
        String username = req.getParameter("username");

// 2. Get the current session object
// If this is the first visit, the server will create a new session.
// Otherwise, it will return the existing session.
        HttpSession session = req.getSession();

// 3. Print the unique session ID
        System.out.println(session.getId());

// 4. Check whether this session is newly created
// true  -> this is a new session
// false -> this session already existed
        System.out.println(session.isNew());

// 5. Store the username in the session scope
// It can be accessed later in other Servlets or JSP pages
        session.setAttribute("username", username);

// 6. Set the response content type and character encoding
        resp.setContentType("text/html;charset=UTF-8");

// 7. Send "done" back to the browser
        resp.getWriter().write("done");
    }
}
