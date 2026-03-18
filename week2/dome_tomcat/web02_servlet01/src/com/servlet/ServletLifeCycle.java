package com.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * Servlet Life Cycle
 *
 * 1. Instantiation     -> Constructor   -> At the first request or when the server starts
 * 2. Initialization    -> init()        -> After the object is constructed
 * 3. Service           -> service()     -> Executed for every request
 * 4. Destruction       -> destroy()     -> Executed when the server shuts down
 *
 * Notes:
 * 1. A Servlet is singleton by default in Tomcat.
 * 2. Member variables of a Servlet are shared among multiple threads.
 * 3. Do not modify member variables in service(),
 *    otherwise thread-safety problems may occur under concurrent access.
 */

@WebServlet("/sl")
public class ServletLifeCycle extends HttpServlet {

    public ServletLifeCycle() {
        System.out.println("Constructor");
    }

    @Override

    public void init() throws ServletException {
        System.out.println("Initialization");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        System.out.println("Service");
    }

    @Override
    public void destroy() {
        System.out.println("Destroy");
    }
}
