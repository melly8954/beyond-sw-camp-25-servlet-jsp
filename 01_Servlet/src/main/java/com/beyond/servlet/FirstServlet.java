package com.beyond.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.time.LocalDateTime;

/*
    서블릿을 실행시키는 방법

    1. 서블릿 클래스를 작성한다.
        - jakarta.servlet.http.HttpServlet 상속하는 하위 클래스를 생성한다.
        - doGet(), doPost(), ... 등의 메서드를 재정의한다.

    2. 서블릿 등록 및 URL을 매핑한다.
        - web.xml에 서블릿을 등록 및 매핑한다.
        - @WebServlet 어노테이션으로 서블릿을 등록 및 매핑한다.
 */
public class FirstServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -9221195916823435707L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("사용자로부터 GET 요청을 받음..");
        // 자바 코드로 응답 화면 작성

        // 1. 한글이 꺠지는 것을 방지하기 위해 응답 헤더를 설정
        response.setContentType("text/html;charset=utf-8");

        // 2. 응답 화면을 출력하기 위한 출력 스트림을 얻어온다.
        PrintWriter out = response.getWriter();

        // 3. 응답 화면 출력
        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ko\">");
        out.println("<head>");
//        out.println("<meta charset=\"utf-8\">");
        out.println("<title>FirstServlet</title>");
        out.println("</head>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>첫 번째 서블릿이 반환하는 내용</h2>");
        out.println("<p>현재 시간 : " + LocalDateTime.now() + "</p>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doPost(request, response);
    }
}
