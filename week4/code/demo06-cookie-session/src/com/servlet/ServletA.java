package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 1. Create a cookie named "keya" with value "valuea"
        Cookie cookie1 = new Cookie("keya", "valuea");

// 2. Set the lifetime of cookie1 to 5 minutes
// 60 seconds * 5 = 300 seconds
        cookie1.setMaxAge(60 * 5);

// 3. Set the path for cookie1
// This cookie will only be sent when accessing /d06/servletB
        cookie1.setPath("/d06/servletB");

// 4. Create another cookie named "keyb" with value "valueb"
        Cookie cookie2 = new Cookie("keyb", "valueb");

// 5. Add cookie1 to the HTTP response
// The browser will save it after receiving the response
        resp.addCookie(cookie1);

// 6. Add cookie2 to the HTTP response
        resp.addCookie(cookie2);
    }
}
