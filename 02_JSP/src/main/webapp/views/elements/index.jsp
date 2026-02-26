<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP 요소 (Elements)</title>
</head>
<body>
    <h2>JSP 요소 (Elements)</h2>
    <!-- HTML 주석 -->
    <%-- JSP 주석 --%>
    <%--
       두 주석의 차이점
       페이지 소스 보기 혹은 개발자 도구 HTML 주석은 확인 가능하고 JSP 주석은 확인이 불가능하다.
    --%>

    <%-- 선언문 태그 --%>
    <%!
        // 필드 선언
        private String name = "홍길동";

        // 메서드 선언
        public String getName() {
            return this.name;
        }
    %>

    <%-- 스크립트릿 태그 --%>
     <%
         // 자바 코드 작성
         int sum = 0;

         for (int i = 1; i <= 10; i++) {
             sum += i;
     %>
    <h3>안녕하세요.</h3>
    <%

         }
        System.out.println(sum);
    %>

    <%-- 표현식 태그 --%>
    저의 이름은 <% out.print(name); %>입니다.
    <br>
    저의 이름은 <%= name %>입니다.
    <br>

    1부터 10까지의 합은 <%= sum%>입니다.
</body>
</html>
