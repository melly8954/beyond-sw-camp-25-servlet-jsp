package com.beyond.mvc.auth.controller;

import com.beyond.mvc.auth.model.service.AuthService;
import com.beyond.mvc.auth.model.service.AuthServiceImpl;
import com.beyond.mvc.auth.model.vo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name="authLoginServlet", urlPatterns = "/auth/login")
public class AuthLoginServlet extends HttpServlet {
    private final AuthService authService;

    public AuthLoginServlet() {
        this.authService = new AuthServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = authService.login(username, password);

        System.out.println(loginUser);

        response.sendRedirect(request.getContextPath() + "/");
    }
}
