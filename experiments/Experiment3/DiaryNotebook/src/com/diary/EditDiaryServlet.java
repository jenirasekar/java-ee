package com.diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/edit")
public class EditDiaryServlet extends HttpServlet {
    private String esc(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    private File getSafeFile(String param, String diaryPath) throws IOException {
        String fileName = new File(param).getName(); // strip path separators
        File file = new File(diaryPath, fileName);
        if (!file.getCanonicalPath().startsWith(new File(diaryPath).getCanonicalPath())) {
            return null; // outside diary directory
        }
        return file;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");

        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }

        response.setContentType("text/html;charset=UTF-8");

        String fileName = request.getParameter("file");

        String path = getServletContext().getRealPath("/diary");
        File file = new File(path, fileName);

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String title = "", content = "";
        String line;
        boolean isContent = false;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Title: ")) {
                title = line.substring(7);
            } else if (line.startsWith("Content:")) {
                isContent = true;
            } else if (isContent) {
                content += line + "\n";
            }
        }
        reader.close();

        PrintWriter out = response.getWriter();

        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='static/bootstrap/css/bootstrap.rtl.css'>");
        out.println("</head><body class='bg-light'>");

        out.println("<div class='container mt-5'>");
        out.println("<h2>Edit Diary</h2>");

        out.println("<form action='edit' method='post'>");

        out.println("<input type='hidden' name='file' value='" + fileName + "'>");

        out.println("<div class='mb-3'>");
        out.println("<label>Title</label>");
        out.println("<input type='text' name='title' class='form-control' value='" + title + "'>");
        out.println("</div>");

        out.println("<div class='mb-3'>");
        out.println("<label>Content</label>");
        out.println("<textarea name='content' class='form-control' rows='6'>"
                + content + "</textarea>");
        out.println("</div>");

        out.println("<button type='submit' class='btn btn-success'>Update</button>");
        out.println("<a href='index' class='btn btn-secondary'>Back</a>");

        out.println("</form>");
        out.println("</div>");

        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();
        String user = (String) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.html");
            return;
        }

        request.setCharacterEncoding("UTF-8");

        String diaryPath = getServletContext().getRealPath("/diary");
        File file = getSafeFile(request.getParameter("file"), diaryPath);

        if (file == null || !file.exists()) {
            response.sendError(404, "Diary not found");
            return;
        }

        String title   = request.getParameter("title");
        String content = request.getParameter("content");

        // preserve original date and IP
        String date = "", ip = "";
        String line;
        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Date: ")) date = line.substring(6);
                else if (line.startsWith("IP: ")) ip  = line.substring(4);
            }
        }

        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(file), "UTF-8"))) {
            writer.write("Title: " + title + "\n");
            writer.write("Date: " + date + "\n");
            writer.write("IP: " + ip + "\n");
            writer.write("Content:\n" + content);
        }

        response.sendRedirect("index");
    }
}