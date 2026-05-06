package com.javeweb.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.Map;

@WebServlet("/servlet05")
public class Servlet05 extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Get parameters in key-value form
        // Get a single parameter value by parameter name
        String username = req.getParameter("username");
        System.out.println(username);

        String userPwd = req.getParameter("userPwd");
        System.out.println(userPwd);

        // Get multiple parameter values by parameter name
        String[] hobbies = req.getParameterValues("hobby");
        System.out.println(Arrays.toString(hobbies));

        // Get all parameter names
        Enumeration<String> pnames = req.getParameterNames();
        while (pnames.hasMoreElements()) {
            String pname = pnames.nextElement();
            String[] values = req.getParameterValues(pname);

            if (values.length > 1) {
                System.out.println(pname + "=" + Arrays.toString(values));
            } else {
                System.out.println(pname + "=" + values[0]);
            }
        }
//        // Return the map collection of all parameters
//        // key = parameter name, value = parameter value
//        Map<String, String[]> parameterMap = req.getParameterMap();
//        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
//
//        for (Map.Entry<String, String[]> entry : entries) {
//            String pname = entry.getKey();
//            String[] value = entry.getValue();
//
//            if (value.length > 1) {
//                System.out.println(pname + "=" + Arrays.toString(value));
//            } else {
//                System.out.println(pname + "=" + value[0]);
//            }
//        }

        /*
         * These APIs are used to obtain parameters in key=value format,
         * whether they are located after the URL or in the request body.
         *
         * How can we get non-key-value data in the request body?
         *
         * // Get a character input stream to read string data from the request body
         * BufferedReader reader = req.getReader();   // JSON string
         *
         * // Get a binary input stream to read binary byte data from the request body
         * ServletInputStream inputStream = req.getInputStream();   // File
         */

    }
}
