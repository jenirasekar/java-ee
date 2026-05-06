package com.atguigu.schedule.controller;

import com.atguigu.schedule.pojo.SysUser;
import com.atguigu.schedule.service.SysUserService;
import com.atguigu.schedule.service.impl.SysUserServiceImpl;
import com.atguigu.schedule.util.MD5Util;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/user/*")
public class SysUserController extends BaseContoller {

    // Create a service object to handle user-related business logic
    private SysUserService userService = new SysUserServiceImpl();

    /**
     * Receive user login requests and complete the login business process.
     */
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. Receive username and password from the request
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        // 2. Call the service layer to query user information by username
        SysUser loginUser = userService.findByUsername(username);

        if (null == loginUser) {

            // Redirect to the username error page
            resp.sendRedirect("/loginUsernameError.html");

        } else if (!MD5Util.encrypt(userPwd).equals(loginUser.getUserPwd())) {

            // 3. Check whether the password is correct
            // Redirect to the password error page
            resp.sendRedirect("/loginUserPwdError.html");

        } else {

            // 4. Redirect to the home page after successful login
            resp.sendRedirect("/showSchedule.html");
        }
    }

    /**
     * Receive user registration requests and complete the registration business process.
     * This is a business processing method, not a Java interface.
     */
    protected void regist(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. Receive parameters submitted by the client
        String username = req.getParameter("username");
        String userPwd = req.getParameter("userPwd");

        // 2. Encapsulate the parameters into a SysUser object
        SysUser sysUser = new SysUser(null, username, userPwd);

        // 3. Call the service layer to complete registration
        int rows = userService.regist(sysUser);

        // 4. Redirect to different pages according to the registration result
        if (rows > 0) {
            resp.sendRedirect("/registSuccess.html");
        } else {
            resp.sendRedirect("/registFail.html");
        }
    }
}