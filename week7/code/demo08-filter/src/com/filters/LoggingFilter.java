package com.filters;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
 * 1 Implement the Filter interface
 * 2 Override the filtering method
 * 3 Configure the filter
 *     web.xml
 *     annotation
 */
public class LoggingFilter implements Filter {
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    /*
     * Method for filtering requests and responses
     * 1 Before the request reaches the target resource, it first passes through this method
     * 2 This method can decide whether the request should continue to the target resource,
     *   and it can also send a response directly to the client inside this method
     * 3 After the request reaches the target resource and before the response is returned,
     *   it will pass through this method again
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        /*
         * 1 Functional code before the request reaches the target resource
         *     Check whether the user has logged in
         *     Check whether the permission requirements are satisfied
         *     ...
         *
         * 2 Pass-through code
         *
         * 3 Functional code before the response is sent
         *   before HttpServletResponse is converted into an actual HTTP response
         */

// Downcast the parameters to HttpServletRequest and HttpServletResponse
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

// Print a log before the request reaches the target resource
        String requestURI = request.getRequestURI();
        String dateTime = dateFormat.format(new Date());
        String beforeLogging = requestURI + " was accessed at " + dateTime;
        System.out.println(beforeLogging);

        long t1 = System.currentTimeMillis();

// Let the request continue
        filterChain.doFilter(servletRequest, servletResponse);

        long t2 = System.currentTimeMillis();

// Print a log before the response is returned
        String afterLogging = requestURI + " request at " + dateTime + " took " + (t2 - t1) + " milliseconds";
        System.out.println(afterLogging);



//        System.out.println("loggingFilter before doFilter invoked");
//        filterChain.doFilter(servletRequest,servletResponse);
//        System.out.println("loggingFilter after doFilter invoked");
    }
}
