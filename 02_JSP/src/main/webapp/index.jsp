<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP (Java Server Page)</title>
</head>
<body>
    <h2>JSP (Java Server Page)</h2>

    <h3>1. JSP</h3>
    <p>
        JSP는 HTML 코드 안에서 스크립트 형태로 자바 언어를 사용하여 동적인 페이지를 생성한다.
    </p>
    <br><hr>

    <h3>2. JSP 요소(Elements)</h3>
    <p>
        JSP 페이지에서 자바 코드를 직접 기술할 수 있게 해주는 요소들이다.
    </p>

    <ol>
        <li>주석 태그</li>
        <li>지시자 태그</li>
        <li>선언문 태그</li>
        <li>스크립트릿 태그</li>
        <li>표현식 태그</li>
    </ol>

    <!-- ContextPath를 /jsp 로 설정한 경우 -->
    <%--
    <a href="/jsp/views/elements/">View details</a><br>
    <a href="/jsp/views/directive/">View details</a><br>
    --%>

    <!-- ContextPath를 실행 시점에서 얻는 경우 -->
    <a href="<%= request.getContextPath()%>/views/elements/">View details</a><br>
    <a href="<%= request.getContextPath()%>/views/directive/">View details</a><br>
    <br><hr>

    <h3>3. JSP 내장 객체</h3>
    <p>
        JSP가 서블릿으로 변환될 때 자바 파일에 자동으로 추가되는 객체들을 내장 객체라고 한다.
        <br>
        즉, JSP 페이지 내부에서 개발자가 직접 선언하지 않아도 바로 사용이 가능한 객체이다.
    </p>

    user : <%= session.getAttribute("user") %>
    <br>

    <a href="<%= request.getContextPath()%>/views/objects">View details</a><br>
    <br><hr>

    <h3>4. 영역 객체</h3>
    <p>
        - JSP 내장 객체 중 pageContext, request, session, application은 데이터를 공유할 수 있는 각각의 유효 범위(Scope)를 가진다.
        <br>
        - 공유되는 데이터를 속성(Attribute)이라고 하며, 속성이 유지되는 범위를 영역(Scope)이라고 한다.
        <br>

        <a href="<%= request.getContextPath()%>/views/scopes">View details</a><br>

    </p>
</body>
</html>