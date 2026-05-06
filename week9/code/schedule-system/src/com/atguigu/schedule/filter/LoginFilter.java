package com.atguigu.schedule.filters;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebFilter(urlPatterns = {"/showSchedule.html","/schedule/*"})
public class LoginFilter  implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request =(HttpServletRequest) servletRequest;
        HttpServletResponse response =(HttpServletResponse) servletResponse;
        HttpSession session = request.getSession();
        Object sysUser = session.getAttribute("sysUser");
        if(null != sysUser){
            // If the logged-in user exists in the session, it means the user has logged in, so allow the request to pass.
            filterChain.doFilter(servletRequest,servletResponse);

        }else{
            // The user is not logged in. Redirect to the login page.
            response.sendRedirect("/login.html");
        }
    }
}