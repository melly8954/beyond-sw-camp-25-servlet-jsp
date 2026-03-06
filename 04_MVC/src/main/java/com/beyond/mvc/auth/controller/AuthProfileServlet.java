package com.beyond.mvc.auth.controller;

import com.beyond.mvc.auth.model.service.AuthService;
import com.beyond.mvc.auth.model.service.AuthServiceImpl;
import com.beyond.mvc.auth.model.vo.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="authProfileServlet", urlPatterns = "/auth/profile")
public class AuthProfileServlet extends HttpServlet {
    private final AuthService authService;

    public AuthProfileServlet() {
        this.authService = new AuthServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 로그인 여부 검사는 LoginCheckFilter에서 처리
        request.getRequestDispatcher("/views/auth/profile.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result;
        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        loginUser.setNickname(request.getParameter("nickname"));
        loginUser.setPhone(request.getParameter("phone"));
        loginUser.setEmail(request.getParameter("email"));
        loginUser.setAddress(request.getParameter("address"));

        String hobbies = request.getParameterValues("hobby") != null ?
                String.join(",", request.getParameterValues("hobby")) : null;

        loginUser.setHobbies(hobbies);

        result = authService.save(loginUser);
    }
}
