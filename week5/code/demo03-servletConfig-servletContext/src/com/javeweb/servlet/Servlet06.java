package com.javeweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/servlet06")
public class Servlet06 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setStatus(200);
        // Set APIs related to the response line   HTTP/1.1  200/404/405/500/...
        resp.setStatus(200);

        String info = "<h1>hello</h1>";

        // Set APIs related to response headers
        // resp.setHeader("aaa", "valuea");
        // resp.setHeader("Content-Type", "text/html");
        // resp.setHeader("content-Length", "1234");
        resp.setContentType("text/html");
        resp.setContentLength(info.getBytes().length);

        // Set APIs related to the response body
        // Get a character output stream to write text to the response body
        PrintWriter writer = resp.getWriter();
        writer.write(info);

        // Get a byte output stream to write binary data to the response body
        // ServletOutputStream outputStream = resp.getOutputStream();
    }
}
