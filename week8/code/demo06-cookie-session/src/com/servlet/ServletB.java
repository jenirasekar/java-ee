package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletB")
public class ServletB extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Get all cookies sent by the browser
        Cookie[] cookies = req.getCookies();

// 2. Check whether cookies exist
        if (cookies != null) {

            // 3. Loop through all cookies
            for (Cookie cookie : cookies) {

                // 4. Print each cookie's name and value
                System.out.println(cookie.getName() + ":" + cookie.getValue());
            }

        } else {

            // 5. Print a message if no cookies are found
            System.out.println("no cookie");
        }
    }
}
