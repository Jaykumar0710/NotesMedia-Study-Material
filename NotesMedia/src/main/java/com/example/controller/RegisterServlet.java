// RegisterServlet.java
package com.example.controller;

import com.example.dao.UserDao;
import com.example.model.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

public class RegisterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);

        UserDao userDao = new UserDao();
        if (userDao.saveUser(user)) {
            response.sendRedirect("login.jsp");
        } else {
            request.setAttribute("errorMessage", "Registration failed");
            request.getRequestDispatcher("register.jsp").forward(request, response);
        }
    }
}
