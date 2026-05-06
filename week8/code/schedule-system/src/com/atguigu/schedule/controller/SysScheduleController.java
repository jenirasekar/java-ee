package com.atguigu.schedule.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
 * Request path examples:
 *
 * Add schedule:      /schedule/add
 * Query schedule:    /schedule/find
 * Update schedule:   /schedule/update
 * Delete schedule:   /schedule/remove
 * ... ...
 */

@WebServlet("/schedule/*")
public class SysScheduleController extends BaseContoller {

    /**
     * Receive the request for adding a schedule.
     */
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // Print a message to test whether the request reaches this method
        System.out.println("add");
    }
}