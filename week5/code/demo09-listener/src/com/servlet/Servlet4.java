package com.servlet;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

@WebServlet("/servlet4")
public class Servlet4 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        // Add attribute
        request.setAttribute("reqKey", "reqValue1");

        // Replace attribute
        request.setAttribute("reqKey", "reqValue2");

        // Remove attribute
        request.removeAttribute("reqKey");


        HttpSession session = request.getSession();

        // Add attribute
        session.setAttribute("sessKey", "sessValue1");

        // Replace attribute
        session.setAttribute("sessKey", "sessValue2");

        // Remove attribute
        session.removeAttribute("sessKey");

         session.invalidate();
    }
}