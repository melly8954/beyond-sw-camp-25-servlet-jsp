<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>영역 객체 테스트</title>
</head>
<body>
    <h2>Request 영역과 Page 영역의 비교</h2>

    Request 영역에 저장된 데이터: <%= request.getAttribute("gender") %>
    <br>
    Page 영역에 저장된 데이터: <%= pageContext.getAttribute("age")%>
</body>
</html>
