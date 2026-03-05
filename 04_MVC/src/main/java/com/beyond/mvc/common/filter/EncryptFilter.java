package com.beyond.mvc.common.filter;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;

import java.io.IOException;

/*
    서블릿 필터
        - Request, Response가 서블릿이나 JSP에 도달하기 전에 필요한 전/후 처리 작업을 수행한다.
        - FilterChain을 통해서 여러 개의 필터를 연속적으로 사용할 수 있다.

    서블릿 필터를 구현하는 방법
        - Filter 인터페이스를 구현하는 구현체 클래스를 만든다.
        - doFilter() 추상 메서드를 재정의한다.

    서블릿 필터를 등록 및 매핑하는 방법
        - web.xml 파일에 필터를 등록해서 사용할 수 있다.
        - @WebFilter 어노테이션으로 필터를 등록해서 사용할 수 있다.
 */

@WebFilter(filterName = "encryptFilter", urlPatterns = { "/auth/login", "/auth/sign-up" })
public class EncryptFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // 컨테이너가 필터를 생성할 때 초기화를 위해서 호출한다.
        System.out.println(filterConfig.getFilterName() + "필터가 생성되어 초기화 시작");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("서블릿 시작 전 코드 실행");

        // 사용자가 보낸 요청과 응답 객체를 임의로 수정할 수 없지만
        // 요청과 응답을 감싸는 Wrapper 클래스를 만들면 간접적으로 수정할 수 있다.
        EncryptPasswordWrapper wrapper = new EncryptPasswordWrapper((HttpServletRequest) request);

        // 다음 필터를 호출하거나, 서블릿, JSP를 호출한다.
        filterChain.doFilter(wrapper, response);

        System.out.println("서블릿 동작 후 코드 실행");
    }

    @Override
    public void destroy() {
        // 필터가 소멸될 때 호출한다.
        System.out.println("필터가 소멸");
    }
}
