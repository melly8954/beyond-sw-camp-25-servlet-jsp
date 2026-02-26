package com.beyond.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Serial;
import java.util.Arrays;

@WebServlet("/method")
public class MethodServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = -2506339292342498114L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 사용자가 보낸 데이터들을 HttpServletRequest 객체를 통해서 얻어올 수 있다.
        // request.getParameter("input 태그의 name 속성의 값");
        String name = request.getParameter("name");
        String age = request.getParameter("age");
        String gender = request.getParameter("gender");
        String[] foods = request.getParameterValues("food");

        System.out.println(name);
        System.out.println(age);
        System.out.println(gender);
        System.out.println(Arrays.toString(foods));

        // 응답 화면 출력
        response.setContentType("text/html;charset=UTF-8");

        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html lang=\"ko\">");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>개인 정보 출력</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h2>개인 정보 출력</h2>");
        out.printf("%s님은 %s세 %s입니다.<br>", name, age, gender);
        out.println("좋아하는 음식은 ");
        Arrays.stream(foods).forEach(food -> out.print(food + " "));
        out.println("입니다.<br>");
        out.println("</body>");
        out.println("</html>");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }
}
