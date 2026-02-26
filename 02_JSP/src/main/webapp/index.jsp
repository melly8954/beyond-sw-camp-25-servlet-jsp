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

    <a href="/jsp/views/elements/">View details</a><br>
    <a href="/jsp/views/directive/">View details</a><br>

    <h3>3. JSP 내장 객체</h3>
    <p>
        JSP가 서블릿으로 변환될 때 자바 파일에 자동으로 추가되는 객체들을 내장 객체라고 한다.
        <br>
        즉, JSP 페이지 내부에서 개발자가 직접 선언하지 않아도 바로 사용이 가능한 객체이다.
    </p>

    <a href="/jsp/views/objects">View details</a><br>
</body>
</html>