package com.jenira.web02;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class ServletLifeCycle extends HttpServlet {
    public ServletLifeCycle(){
        System.out.println("Constructor");
    }

    @Override
    public void init() throws ServletException {
        System.out.println("Initialization method");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("service method");
    }

    @Override
    public void destroy() {
        System.out.println("Destruction method");
    }
}
