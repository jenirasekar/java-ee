package com.javeweb.servlet;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

public class Servlet1 extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("-------------------servletConfig---------");
        ServletConfig servletConfig = getServletConfig();

        // Get the initial configuration information
        // Get the parameter value by its parameter name
        String keya = servletConfig.getInitParameter("keya");
        System.out.println("keya:" + keya);

        // Get the names of all initial parameters
        // hasMoreElements: checks whether there is a next parameter
        // If yes, it returns true; otherwise, it returns false
        // nextElement:
        // 1. gets the next element
        // 2. moves the cursor forward
        Enumeration<String> initParameterNames = servletConfig.getInitParameterNames();

        while (initParameterNames.hasMoreElements()) {
            String pname = initParameterNames.nextElement();
            System.out.println(pname + "=" + getInitParameter(pname));
        }
        System.out.println("-------------------getServletContext---------");

        ServletContext servletContext1 = servletConfig.getServletContext();
        ServletContext servletContext2 = req.getServletContext();
        ServletContext servletContext3 = getServletContext();
        System.out.println(servletContext1 == servletContext2);
        System.out.println(servletContext3 == servletContext2);

        String encoding = servletContext1.getInitParameter("encoding");
        System.out.println("encoding:" + encoding);

        Enumeration<String> parameterNames = servletContext1.getInitParameterNames();
        while (parameterNames.hasMoreElements()) {
            String pname = parameterNames.nextElement();
            System.out.println(pname + "=" + servletContext1.getInitParameter(pname));
        }

        servletContext1.setAttribute("ka","va");
//        servletContext1.setAttribute("ka","vaa");
        servletContext1.removeAttribute("ka");


    }
}
