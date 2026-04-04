package com.diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/createDiary")
public class CreateDiaryServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String title = request.getParameter("title");
        String content = request.getParameter("content");

        // get current time
        String time = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String displayTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

        // get user IP
        String ip = request.getRemoteAddr();

        // get real path to store files
        String path = getServletContext().getRealPath("/diary");
        File dir = new File(path);
        if (!dir.exists()) {
            dir.mkdir();
        }

        // file name
        File file = new File(dir, time + ".txt");

        // write content to file
        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write("Title: " + title + "\n");
        writer.write("Date: " + displayTime + "\n");
        writer.write("IP: " + ip + "\n");
        writer.write("Content:\n" + content);
        writer.close();

        // redirect back to main page
        response.sendRedirect("index");
    }
}