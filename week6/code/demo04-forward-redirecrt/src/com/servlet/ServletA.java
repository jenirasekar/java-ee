package com.servlet;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * 1. Request forwarding is implemented through the HttpServletRequest object.
 * 2. Request forwarding is a server-side behavior and is transparent to the client.
 * 3. One client request causes the server to create one pair of request and response objects.
 * 4. The client's address bar does not change.
 * 5. Request parameters can continue to be passed.
 * 6. The target resource can be a servlet dynamic resource or an HTML static resource.
 * 7. The target resource can be a protected resource under WEB-INF.
 *    This is also the only way to access resources under WEB-INF.
 * * 8. The target resource cannot be an external resource.
 */

@WebServlet("/servletA")
public class ServletA extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("servletA");
        // Forward the request to servletB
        // Get the request dispatcher
//         RequestDispatcher requestDispatcher = req.getRequestDispatcher("servletB");
//         RequestDispatcher requestDispatcher = req.getRequestDispatcher("a.html");
//         RequestDispatcher requestDispatcher = req.getRequestDispatcher("WEB-INF/b.html");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("http://www.atguigu.com");

        // Let the request dispatcher perform the forwarding operation
        requestDispatcher.forward(req, resp);

    }
}
