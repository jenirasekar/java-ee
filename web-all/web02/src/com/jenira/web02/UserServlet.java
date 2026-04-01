package com.jenira.web02;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import java.io.IOException;

public class UserServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String username = request.getParameter("username");
        if("jenira".equals(username)){
            // Respond with information via the response object
            response.getWriter().write("NO");
        }else{
            response.getWriter().write("YES");
        }
    }
}