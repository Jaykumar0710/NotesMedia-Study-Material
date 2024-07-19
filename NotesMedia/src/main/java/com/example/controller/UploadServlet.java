package com.example.controller;

import com.example.dao.MaterialDao;
import com.example.model.Material;
import com.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.servlet.http.Part;

import java.io.File;
import java.io.IOException;

@MultipartConfig
public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String title = request.getParameter("title");
        String description = request.getParameter("description");
        
        // Ensure the file part is retrieved correctly
        Part filePart = request.getPart("file");
        if (filePart == null) {
            response.getWriter().write("No file uploaded!");
            return;
        }

        String filename = filePart.getSubmittedFileName();
        String uploadPath = getServletContext().getRealPath("") + File.separator + "uploads";

        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }

        filePart.write(uploadPath + File.separator + filename);

        Material material = new Material();
        material.setTitle(title);
        material.setDescription(description);
        material.setFilename(filename);

        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user != null) {
            material.setUserId(user.getId());
        }

        MaterialDao materialDao = new MaterialDao();
        if (materialDao.saveMaterial(material)) {
            response.sendRedirect("materials.jsp");
        } else {
            request.setAttribute("errorMessage", "Upload failed");
            request.getRequestDispatcher("upload.jsp").forward(request, response);
        }
    }
}