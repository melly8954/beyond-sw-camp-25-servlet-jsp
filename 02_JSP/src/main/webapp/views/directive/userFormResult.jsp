<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">
<%
    String name = request.getParameter("name");
    String age = request.getParameter("age");
    String gender = request.getParameter("gender");
    String[] foods = request.getParameterValues("food");

    System.out.println(name);
    System.out.println(age);
    System.out.println(gender);
    System.out.println(Arrays.toString(foods));
%>
<head>
    <meta charset="UTF-8">
    <title>개인 정보 출력</title>
</head>
<body>
    <h2>개인 정보 출력</h2>

    <%= name %> 님은 <%= age %>세, 성별은 <%= gender %>입니다.
    <br>

    좋아하는 음식은
    <%
        for (String food : foods) {
            out.print(food + ' ');
        }
    %>
</body>
</html>
