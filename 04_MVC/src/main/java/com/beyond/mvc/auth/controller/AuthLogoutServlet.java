package com.beyond.mvc.auth.controller;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name="authLogoutServlet", urlPatterns = "/auth/logout")
public class AuthLogoutServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        /* 로그아웃 순서
            1. 세션 객체를 얻어온다.
            2. 세션을 삭제한다.
            3. 세션 삭제 후 메인 화면으로 리다이렉트한다.
         */
        HttpSession session = request.getSession();
        session.invalidate();
        response.sendRedirect(request.getContextPath() + "/");
    }
}
