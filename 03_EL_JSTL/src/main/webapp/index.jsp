<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>EL/JSTL</title>
</head>
<body>
    <h1>EL/JSTL</h1>
    <br>

    <h2>1. EL(Expression Language)</h2>
    <p>
        표현식 태그를 대신하여 클라이언트에 출력하고자 하는 값들을 좀 더 간결하게 사용하는 방법이다.
    </p>

    <h4>1). EL 내장 객체</h4>
    <a href=<%= request.getContextPath()%>"/el">View details</a>

</body>
</html>