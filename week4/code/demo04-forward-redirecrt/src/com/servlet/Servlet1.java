package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * 1. Redirection is implemented through the HttpServletResponse object.
 * 2. Redirection is a client-side behavior that is visible to the client.
 * 3. The URL in the client's address bar changes.
 * 4. The client sends at least two requests, so multiple requests are generated on the client side.
 * 5. Since multiple requests are made, multiple request objects are created on the server side.
 *    Therefore, parameters in the original request cannot continue to be passed automatically.
 * 6. The target resource can be a dynamic servlet resource.
 * 7. The target resource cannot be a resource under WEB-INF.
 * 8. The target resource can be an external resource.
 */

@WebServlet("/servlet1")
public class Servlet1 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servlet1");
//        resp.sendRedirect("servlet2");
        // Response redirection
        // Set the response status code to 302 and set the Location response header at the same time
        // resp.sendRedirect("servlet2");
         resp.sendRedirect("a.html");
//        resp.sendRedirect("WEB-INF/b.html");
//        resp.sendRedirect("http://www.atguigu.com");
    }
}
