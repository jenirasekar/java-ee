package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * Base controller class.
 * It is used to dispatch requests to different business methods according to the request path.
 */
public class BaseContoller extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Get the request URI, for example: /schedule/add
        String requestURI = req.getRequestURI();

        // Split the URI by "/"
        String[] split = requestURI.split("/");

        // Get the last part of the URI as the method name
        String methodName = split[split.length - 1];

        // Get the runtime class of the current controller
        Class aClass = this.getClass();

        try {
            // Get the method according to the method name and parameter types
            Method declaredMethod = aClass.getDeclaredMethod(
                    methodName,
                    HttpServletRequest.class,
                    HttpServletResponse.class
            );

            // Allow access to protected or private methods
            declaredMethod.setAccessible(true);

            // Invoke the target business method
            declaredMethod.invoke(this, req, resp);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}