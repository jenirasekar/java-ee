package com.servlet;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

/*
* servlet 开发流程
* 1 创建javaweb项目，同时将Tomcat添加为当前项目的依赖
* 2 重写service方法 service(HttpServletRequest request, HttpServletResponse response)
* 3 在service方法中，定义业务处理代码
* 4 在web.xml中，配置servlet对应的请求映射路径
*
*
*
* */


public class UserServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //super.service(request, response);
        // 1 从request对象中获取请求中的任何信息
        String username = request.getParameter("username");

        // 2 处理业务的代码

        String info = "YES";
        if ("javaweb".equals(username)) {
            info="NO";
        }

        // 3 将要响应的数据放入response中
        // 应该设置content-type响应头
        response.setHeader("Content-Type", "text/html");
        PrintWriter writer = response.getWriter();
        writer.println(info);
    }
}
