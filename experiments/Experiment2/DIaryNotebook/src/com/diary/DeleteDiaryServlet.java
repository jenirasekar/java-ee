package com.diary;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.*;

@WebServlet("/delete")
public class DeleteDiaryServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String fileName = request.getParameter("file");

        String path = getServletContext().getRealPath("/diary");
        File file = new File(path, fileName);

        if (file.exists()) {
            file.delete();
        }

        response.sendRedirect("index");
    }
}