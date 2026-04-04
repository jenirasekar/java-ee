package com.diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;
import java.util.*;

@WebServlet("/index")
public class DiaryListServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        // get diary folder
        String path = getServletContext().getRealPath("/diary");
        File dir = new File(path);

        if (!dir.exists()) {
            dir.mkdir();
        }

        File[] files = dir.listFiles();

        // sort files by name DESC (newest first)
        if (files != null) {
            Arrays.sort(files, (f1, f2) -> f2.getName().compareTo(f1.getName()));
        }

        // start HTML
        out.println("<!DOCTYPE html>");
        out.println("<html><head>");
        out.println("<meta charset='UTF-8'>");
        out.println("<title>Diary Notebook</title>");

        // bootstrap
        out.println("<link rel='stylesheet' href='static/bootstrap/css/bootstrap.rtl.css'>");

        out.println("</head><body class='bg-light'>");

        out.println("<div class='container mt-5'>");
        out.println("<h1 class='text-center mb-4'>📔 Diary Notebook</h1>");

        // create button
        out.println("<div class='text-end mb-3'>");
        out.println("<a href='create.html' class='btn btn-primary'>+ New Diary</a>");
        out.println("</div>");

        // table
        out.println("<table class='table table-striped table-hover shadow'>");
        out.println("<thead class='table-dark'>");
        out.println("<tr><th>Date</th><th>Title</th><th>Actions</th></tr>");
        out.println("</thead><tbody>");

        if (files != null) {
            for (File file : files) {

                BufferedReader reader = new BufferedReader(new FileReader(file));

                String title = "";
                String date = "";

                String line;
                while ((line = reader.readLine()) != null) {
                    if (line.startsWith("Title: ")) {
                        title = line.substring(7);
                    }
                    if (line.startsWith("Date: ")) {
                        date = line.substring(6);
                    }
                }
                reader.close();

                out.println("<tr>");
                out.println("<td>" + date + "</td>");
                out.println("<td>" + title + "</td>");
                out.println("<td>");
                out.println("<a href='view?file=" + file.getName() + "' class='btn btn-sm btn-success'>View</a> ");
                out.println("<a href='edit?file=" + file.getName() + "' class='btn btn-sm btn-warning'>Edit</a>");                out.println("<a href='delete?file=" + file.getName() + "' ");
                out.println("class='btn btn-sm btn-danger' ");
                out.println("onclick=\"return confirm('Delete this diary?')\">Delete</a>");
                out.println("</td>");
                out.println("</tr>");
            }
        }

        out.println("</tbody></table>");
        out.println("</div>");

        out.println("<script src='static/bootstrap/js/bootstrap.bundle.js'></script>");
        out.println("</body></html>");
    }
}