package com.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

//@WebFilter("/*") is same as <!--    <filter>-->
//<!--        <filter-name>filter2</filter-name>-->
//<!--        <filter-class>com.filters.Filter2</filter-class>-->
//<!--    </filter>-->
//          <filter-mapping>-->
//<!--        <filter-name>filter2</filter-name>-->
//<!--        <url-pattern>/*</url-pattern>-->
//<!--    </filter-mapping>-->

@WebFilter("/*")
public class Filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // Code executed before passing the request to the next filter or target resource
        System.out.println("filter2 before doFilter invoked");

// Pass the request and response to the next filter or target resource
        filterChain.doFilter(servletRequest, servletResponse);

// Code executed after the next filter or target resource has finished
        System.out.println("filter2 after doFilter invoked");
    }
}
