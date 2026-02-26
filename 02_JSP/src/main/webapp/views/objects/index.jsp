<%@ page import="java.util.Enumeration" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP 내장 객체</title>
</head>
<body>
    <h2>JSP 내장 객체</h2>
    <%--
    <%
        // 내장 객체가 사용하고 있는 이름을 가진 변수를 스크립트릿에서 사용할 수 없다.
        String out;
    %>
    --%>

    <h3>1. request</h3>
    <p>
        웹 브라우저의 요청 정보를 가지고 있는 객체이다.
    </p>

    <h4>1). 헤더</h4>
    <%
        Enumeration<String> headerNames = request.getHeaderNames();
    %>
    <table border="1">
        <tr>
            <th>헤더 이름</th>
            <th>헤더 값</th>
        </tr>
    <%
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();
    %>
        <tr>
            <td><%= headerName %></td>
            <td><%= request.getHeader(headerName) %></td>
        </tr>

    <%
        }
    %>
    </table>
</body>
</html>
