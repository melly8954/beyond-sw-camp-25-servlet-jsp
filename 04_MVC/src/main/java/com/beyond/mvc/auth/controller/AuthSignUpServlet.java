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

@WebServlet(name="authSignUpServlet", urlPatterns = "/auth/sign-up")
public class AuthSignUpServlet extends HttpServlet {
    private final AuthService authService;

    public AuthSignUpServlet() {
        this.authService = new AuthServiceImpl();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 회원가입 페이지로 전환
        request.getRequestDispatcher("/views/auth/sign-up.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String hobbies = request.getParameterValues("hobby") != null ?
                String.join(",", request.getParameterValues("hobby")) : null;

        User user = User.builder()
                .username(request.getParameter("username"))
                .password(request.getParameter("password"))
                .nickname(request.getParameter("nickname"))
                .phone(request.getParameter("phone"))
                .email(request.getParameter("email"))
                .address(request.getParameter("address"))
                .hobbies(hobbies)
                .build();

        int result = authService.save(user);

        if (result > 0) {
            // 회원가입 성공
            request.setAttribute("msg", "회원가입 성공");
            request.setAttribute("location", "/");
        } else {
            // 회원가입 실패
            request.setAttribute("msg", "회원가입 실패");
            request.setAttribute("location", "/auth/sign-up");
        }

        request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
    }
}
