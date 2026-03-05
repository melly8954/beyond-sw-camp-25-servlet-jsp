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

@WebServlet(name="authLoginServlet", urlPatterns = "/auth/login")
public class AuthLoginServlet extends HttpServlet {
    private final AuthService authService;

    public AuthLoginServlet() {
        this.authService = new AuthServiceImpl();
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session;

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        User loginUser = authService.login(username, password);

        System.out.println(username + "," + password);

        if (loginUser != null) {
            session = request.getSession();
            session.setAttribute("loginUser", loginUser);

            // 로그인이 완료되면 메인 화면으로 리다이렉트한다.
            response.sendRedirect(request.getContextPath() + "/");
        } else {
            // 로그인이 실패에 대한 메시지를 반환하고 메인 화면으로 이동한다.

            // 1. 공용으로 사용하는 메시지 출력 페이지에 전달할 메시지와 메시지 출력 후
            // 이동할 페이지를 request 객체에 저장한다.
            request.setAttribute("msg", "아이디나 비밀번호가 일치하지 않습니다.");
            request.setAttribute("location", "/");

            // 2. request 객체의 데이터를 유지해서 메시지 출력 페이지에 전달하기 위해 forward를 실행한다.
            request.getRequestDispatcher("/views/common/msg.jsp").forward(request, response);
        }


    }
}
