<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%-- isErrorPage="true" %> --%>
<html>
<head>
    <title>Error Page</title>
</head>
<body>
    <h2>에러가 발생했습니다. 관리자에게 문의해 주세용.</h2>
    <button onclick="history.back();">이전 페이지로</button>
    <br>

    <%--
    <%= exception %><br>
    <%= exception.getMessage() %><br>
    <%= exception.getClass().getName() %><br>
    --%>
</body>
</html>
