package com.diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/view")
public class ViewDiaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String fileName = request.getParameter("file");

        String path = getServletContext().getRealPath("/diary");
        File file = new File(path, fileName);

        BufferedReader reader = new BufferedReader(new FileReader(file));

        String title = "", date = "", ip = "", content = "";
        String line;

        boolean isContent = false;

        while ((line = reader.readLine()) != null) {
            if (line.startsWith("Title: ")) {
                title = line.substring(7);
            } else if (line.startsWith("Date: ")) {
                date = line.substring(6);
            } else if (line.startsWith("IP: ")) {
                ip = line.substring(4);
            } else if (line.startsWith("Content:")) {
                isContent = true;
            } else if (isContent) {
                content += line + "<br>";
            }
        }
        reader.close();

        // HTML output
        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='static/bootstrap/css/bootstrap.rtl.css'>");
        out.println("<title>View Diary</title>");
        out.println("</head><body class='bg-light'>");

        out.println("<div class='container mt-5'>");
        out.println("<h2>" + title + "</h2>");
        out.println("<p><strong>Date:</strong> " + date + "</p>");
        out.println("<p><strong>IP:</strong> " + ip + "</p>");
        out.println("<hr>");
        out.println("<p>" + content + "</p>");

        out.println("<a href='index' class='btn btn-secondary mt-3'>Back</a>");
        out.println("</div>");

        out.println("</body></html>");
    }
}