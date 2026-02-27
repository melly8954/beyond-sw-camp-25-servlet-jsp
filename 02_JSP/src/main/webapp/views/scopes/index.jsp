<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>영역 객체</title>
</head>
<body>
    <h1>영역 객체</h1>
    <h2>1). Session 영역과 Application 영역의 비교</h2>
    <%
        session.setAttribute("address","서울 특별시");
        application.setAttribute("name", "psw");
    %>

    <a href="scopeTest1.jsp">View details</a>


    <h2>2). Request 영역과 Page 영역의 비교</h2>

    <a href="scopeTest2.jsp">View details</a>

</body>
</html>
