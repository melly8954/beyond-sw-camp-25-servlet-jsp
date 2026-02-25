package com.beyond.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

@WebServlet("/second")
public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println(request.getContextPath());
        System.out.println(request.getServletPath());
        System.out.println(request.getServerName());
        System.out.println(request.getServerPort());
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemoteUser());

        // 1. 한글이 꺠지는 것을 방지하기 위해 응답 헤더를 설정
        response.setContentType("text/html;charset=utf-8");

        // 2. 응답 화면을 출력하기 위한 출력 스트림을 얻어온다.
        PrintWriter out = response.getWriter();

        // 3. 응답 화면 출력
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ko\">");
        out.println("<head>");
        out.println("<title>FirstServlet</title>");
        out.println("</head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>두 번째 서블릿이 반환하는 내용</h2>");
        out.println("<p>현재 시간 : " + LocalDateTime.now() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }
}
