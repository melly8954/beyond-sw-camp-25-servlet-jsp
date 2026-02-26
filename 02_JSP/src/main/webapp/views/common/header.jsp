<%@ page import="java.time.LocalDate" %>
<%@ page import="java.time.format.DateTimeFormatter" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    String today = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy년 MM월 dd일"));

    // 에러 페이지 확인을 위한 코드
    // int result = 10 / 0;
%>
<header>
    <h2> 지시자 태그 </h2>
    <p>
        오늘은 <%= today%>입니다.
    </p>
</header>