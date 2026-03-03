<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSTL Core Tag Library</title>
</head>
<body>
    <h2>JSTL Core Tag Library</h2>

    <h3>1. 변수</h3>
    <h4>1). 변수 선언 (c:set)</h4>
    <p>
        변수를 선언하고 초기값을 대입하는 액션 태그이다.
    </p>

    <%--  pageContext.setAttribute("num1", "10") --%>
    <c:set var="num1" value="10"/>
    <%--  request.setAttribute("num2", "20") --%>
    <c:set var="num2" value="20" scope="request"/>
    <c:set var="result" value="${ num1 + num2 }" scope="session"/>
    <c:set var="colors" scope="application">
        red, blue, yellow, pink, green
    </c:set>

    num1의 값 : ${ num1 } 또는 ${ pageScope.num1}
    <br>
    num2의 값 : ${ num2 } 또는 ${ requestScope.num2}
    <br>
    result의 값 : ${ result } 또는 ${ sessionScope.result } 또는 <%= session.getAttribute("result")%>
    <br>
    colors의 값 : ${ colors } 또는 ${ applicationScope.colors }
    <br>

    <h4>2). 변수 삭제 (c:remove)</h4>
    <p>
        c:set 액션 태그로 선언한 변수를 삭제할 떄 사용하는 액션 태그이다.
    </p>

    <c:set var="result" value="99999"/>
    <c:set var="result" value="10000" scope="request"/>

    삭제 전 : ${ result } <br>

    <c:remove var="result" scope="page"/>

    첫 번째 삭제 후 : ${ result } <br>

    <c:remove var="result"/>

    두 번째 삭제 후 : ${ result } <br>

    <h3>2. 출력 (c:out)</h3>
    <p>
        클라이언트로 데이터를 출력할 때 사용하는 액션 태그이다.
    </p>

    태그를 문자열로 출력 : <c:out value="<h4>데이터 출력하기</h4>"/>
    <br>
    태그를 문자열로 출력 : <c:out value="<h4>데이터 출력하기</h4>" escapeXml="true"/>
    <br>
    태그로 해석되어 출력 : <c:out value="<h4>데이터 출력하기</h4>" escapeXml="false"/>
    <br>
    기본값 출력 : <c:out value="${ result }" default="0"/>

    <h3>3. 조건 처리 태그</h3>
    <h4>1). c:if 액션 태그</h4>
    <p>
        자바의 if 구문과 같은 역할을 하는 액션 태그이다.
    </p>


    <c:if test="${ num1 > num2 }">
    <b>num1이 num2보다 크다.</b>
    </c:if>

    <c:if test="${ num1 < num2 }">
    <b>num1이 num2보다 작다.</b>
    </c:if>

    <h4>2). c:choose 액션 태그</h4>
    <p>
        자바의 if 구문 또는 swtich 구문과 같은 역할을 하는 액션 태그이다.
    </p>
    <c:choose>
        <c:when test="${ num1 > num2 }">
            <b>num1이 num2보다 크다.</b>
        </c:when>

        <c:when test="${ num1 < num2 }">
            <b>num1이 num2보다 작다.</b>
        </c:when>

        <c:otherwise>
            <b>num1과 num2는 같다.</b>
        </c:otherwise>
    </c:choose>
</body>
</html>