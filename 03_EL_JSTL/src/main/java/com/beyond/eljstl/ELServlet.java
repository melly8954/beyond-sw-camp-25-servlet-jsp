package com.beyond.eljstl;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/el")
public class ELServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Request 영역에 데이터를 저장
        request.setAttribute("classRoom", 1);
        request.setAttribute("student", new Student("홍길동", 34, 70, 70));
        request.setAttribute("scope", "request");
        request.getRequestDispatcher("/views/el/el.jsp").forward(request, response);
    }
}
