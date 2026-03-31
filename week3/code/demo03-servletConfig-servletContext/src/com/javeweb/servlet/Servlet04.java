package com.javeweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Enumeration;

@WebServlet("/servlet04")
public class Servlet04 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Request line related: GET/POST   uri   http/1.1
        System.out.println(req.getMethod());      // Get the request method
        System.out.println(req.getScheme());      // Get the request scheme
        System.out.println(req.getProtocol());    // Get the request protocol and version
        System.out.println(req.getRequestURI());  // Get the request URI, the resource path within the project
        System.out.println(req.getRequestURL());  // Get the request URL, the complete path of the resource within the project

        /*
         * URI: Uniform Resource Identifier
         *      /demo03/a.html
         *      interface URI {}    Requirements/specification for resource identification
         *
         * URL: Uniform Resource Locator
         *      http://ip:port/demo03/a.html
         *      class URL implements URI {}    A concrete resource path
         */
        System.out.println(req.getLocalPort());   // The port number of this application container, e.g. 8080
        System.out.println(req.getServerPort());  // The port number used by the client when sending the request
        System.out.println(req.getRemotePort());  // The port number of the client software

        // Header related   key:value   key:value   ...
        // Get a specific request header by name
        String accept = req.getHeader("Accept");
        System.out.println("Accept:" + accept);

        // Get the names of all request headers in this request
        Enumeration<String> headerNames = req.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String hname = headerNames.nextElement();
            System.out.println(hname + ":" + req.getHeader(hname));
        }


    }
}
