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

@WebServlet(name="authDeleteServlet", urlPatterns = "/auth/delete")
public class AuthDeleteServlet extends HttpServlet {
    private final AuthService authService;

    public AuthDeleteServlet() {
        this.authService = new AuthServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int result;

        HttpSession session = request.getSession();
        User loginUser = (User) session.getAttribute("loginUser");

        result = authService.delete(loginUser.getNo());

        if (result > 0) {
            // 회원탈퇴 성공
            session.invalidate();
            request.setAttribute("msg", "정상적으로 탈퇴되었습니다.");
            request.setAttribute("location", "/");
        } else {
            // 회원탈퇴 실패
            request.setAttribute("msg", "탈퇴에 실패하였습니다.");
            request.setAttribute("location", "/auth/profile");
        }

        request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
