package com.filters;

import jakarta.servlet.*;

import java.io.IOException;

public class LifeCycleFilter implements Filter {
    /*
     * 1 Constructor   -> constructor   -> called when the project starts          -> once
     * 2 Initialization -> init         -> called after the filter is created      -> once
     * 3 Filtering      -> doFilter     -> called on every matching request        -> many times
     * 4 Destruction    -> destroy      -> called when the server is shutting down -> once
     */
    public LifeCycleFilter() {
        // Constructor: called when the filter object is created
        System.out.println("Constructor");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // Initialization method: called after the filter is created
        System.out.println("Initialization");

        // Read the initialization parameter from the filter configuration
        System.out.println(filterConfig.getInitParameter("dateTimePattern"));
    }

    @Override
    public void doFilter(ServletRequest servletRequest,
                         ServletResponse servletResponse,
                         FilterChain filterChain) throws IOException, ServletException {
        // Core filtering method: called whenever a matching request is intercepted
        System.out.println("doFilter method");

        // Let the request continue to the next filter or target resource
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {
        // Destroy method: called before the filter is removed
        System.out.println("destroy method");
    }
}
