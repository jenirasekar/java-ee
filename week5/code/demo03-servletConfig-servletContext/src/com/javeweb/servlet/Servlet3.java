package com.javeweb.servlet;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/servlet3")
public class Servlet3 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletContext();
                // Get the API for obtaining the real disk path of a file/directory under the project deployment location
        String path = servletContext.getRealPath("upload");
        System.out.println(path);

        // Get the context path of the deployed project, that is, the access path of the project
        // Later we will learn to use relative and absolute paths in the project to find target resources
        // Get the context path of the project, that is, the access path of the project
        String contextPath = servletContext.getContextPath();
        System.out.println(contextPath);
        String ka = (String) servletContext.getAttribute("ka");
        System.out.println(ka);

    }
}
