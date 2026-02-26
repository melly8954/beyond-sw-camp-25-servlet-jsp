package com.beyond.servlet;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.Serial;

@WebServlet("/life")
public class LifeServlet extends HttpServlet {
    @Serial
    private static final long serialVersionUID = 2750396848932308516L;

    public LifeServlet() {
        System.out.println("LifeServlet 객체 생성");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("LifeServlet init() 메서드 호출");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LifeServlet service() 메서드 호출");

        // 요청 방식에 따라 doGet(), doPost(), ... 등 메서드 호출
        super.service(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LifeServlet doGet() 메서드 호출");
    }

    @Override
    public void destroy() {
        System.out.println("LifeServlet destroy() 메서드 호출");
    }
}
