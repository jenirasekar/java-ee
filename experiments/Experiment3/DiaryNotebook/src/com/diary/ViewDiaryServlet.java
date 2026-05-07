package com.diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/view")
public class ViewDiaryServlet extends HttpServlet {

    private String esc(String s) {
        if (s == null) return "";
        return s.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();

        String diaryPath = getServletContext().getRealPath("/diary");
        String fileName  = new File(request.getParameter("file")).getName();
        File file = new File(diaryPath, fileName);

        if (!file.getCanonicalPath().startsWith(new File(diaryPath).getCanonicalPath())
                || !file.exists()) {
            response.sendError(404, "Diary not found");
            return;
        }

        String title = "", date = "", ip = "", content = "";
        String line;
        boolean isContent = false;

        try (BufferedReader reader = new BufferedReader(
                new InputStreamReader(new FileInputStream(file), "UTF-8"))) {
            while ((line = reader.readLine()) != null) {
                if (line.startsWith("Title: "))       title = line.substring(7);
                else if (line.startsWith("Date: "))   date  = line.substring(6);
                else if (line.startsWith("IP: "))     ip    = line.substring(4);
                else if (line.startsWith("Content:")) isContent = true;
                else if (isContent)                   content += line + "\n";
            }
        }

        // HTML output
        out.println("<html><head>");
        out.println("<link rel='stylesheet' href='static/bootstrap/css/bootstrap.rtl.css'>");
        out.println("<title>View Diary</title>");
        out.println("</head><body class='bg-light'>");

        out.println("<div class='container mt-5'>");
        out.println("<h2>" + esc(title) + "</h2>");
        out.println("<p><strong>Date:</strong> " + esc(date) + "</p>");
        out.println("<p><strong>IP:</strong> " + esc(ip) + "</p>");
        out.println("<hr>");
        out.println("<p>" + esc(content).replace("\n", "<br>") + "</p>");

        out.println("<a href='index' class='btn btn-secondary mt-3'>Back</a>");
        out.println("</div>");

        out.println("</body></html>");
    }
}