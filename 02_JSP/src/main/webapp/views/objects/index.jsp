<%@ page import="java.util.Enumeration" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.Map" %>
<%@ page import="java.util.Arrays" %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>JSP 내장 객체</title>
</head>
<body>
    <h1>JSP 내장 객체</h1>
    <%--
    <%
        // 내장 객체가 사용하고 있는 이름을 가진 변수를 스크립트릿에서 사용할 수 없다.
        String out;
    %>
    --%>

    <h2>1. request</h2>
    <p>
        웹 브라우저의 요청 정보를 가지고 있는 객체이다.
    </p>

    <h4>1). 헤더와 관련된 메서드</h4>
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

    <h4>2). URL / URI, 요청 방식과 관련된 메서드</h4>
    <table border="1">
        <tr>
            <th>이름</th>
            <th>값</th>
        </tr>
        <tr>
            <td>프로토콜</td>
            <td><%= request.getProtocol()%></td>
        </tr>
        <tr>
            <td>요청 방식</td>
            <td><%= request.getMethod()%></td>
        </tr>
        <tr>
            <td>URL</td>
            <td><%= request.getRequestURL()%></td>
        </tr>
        <tr>
            <td>URI</td>
            <td><%= request.getRequestURI()%></td>
        </tr>
        <tr>
            <td>Context Path</td>
            <td><%= request.getContextPath()%></td>
        </tr>
        <tr>
            <td>Query String</td>
            <td><%= request.getQueryString()%></td>
        </tr>
    </table>

    <br><hr>

    <h2>2. response</h2>
    <p>
        웹 브라우저의 요청에 대한 응답 객체이다.
    </p>

    <h4>1). 응답 헤더와 관련된 메서드</h4>
    <%
        // response.setContentType("text/css;charset=UTF-8");
        // response.setHeader("Authorization", "Bearer fdasfcxvfrefreafsdf-rafsxcxvrefgeagdcv-erafgafw3ef3wdc");
    %>

    <h4>2). 응답 상태와 관련된 메서드</h4>
    <%
        // response.setStatus(HttpServletResponse.SC_CREATED);
        // response.setStatus(201);
        // response.setStatus(500);
        // response.sendError(500);
    %>

    <h4>3). 리다이렉트(Redirect) 관련된 메서드</h4>
    <p>
        지정한 URL로 클라이언트가 요청을 재전송한다.
    </p>
    <a href="redirect.jsp">View details (redirect.jsp)</a>

    <br><hr>

    <h2>3. pageContext</h2>
    <p>
        JSP와 관련된 다른 내장 객체를 얻어내거나 포워드(Forward)하는데 사용되는 객체이다.
    </p>

    <h4>1). 포워드(Forward)</h4>
    <p>
        지정한 경로로 서버 내부에서 요청을 전달한다.
    </p>
    <a href="forward.jsp">View details</a>

    <br><hr>

    <h2>4. session & cookie</h2>
    <p>
        웹 브라우저의 정보를 유지하기 위한 세션 정보를 저장하고 있는 객체이다.
    </p>

    <h4>1). 세션(Session)이란?</h4>
    <ol>
        <li>세션이란 서버 측의 컨테이너에서 관리되는 정보를 의미한다.</li>
        <li>세션은 클라이언트와 서버 간의 상태를 유지시켜주는 역할을 한다.</li>
        <li>세션의 정보는 클라이언트에서 접속해서 브라우저를 종료할 때까지 유지된다.</li>
    </ol>
    <%
        // 클라이언트의 요청이 없더라도 세션을 유지할 시간을 초 단위로 설정한다.
        session.setMaxInactiveInterval(60);
        session.setAttribute("user", Map.of("userId", "1", "name", "psw"));
    %>

    세션 ID : <%= session.getId() %>
    <br>
    isNew : <%= session.isNew() %>
    <br>
    생성시간 : <%= new Date(session.getCreationTime()) %>
    <br>
    최종 접속 시간 : <%= new Date(session.getLastAccessedTime()) %>
    <br>
    세션 유지 시간 : <%= session.getMaxInactiveInterval() %>초
    <br>
    <%
        Object value = session.getAttribute("user");
        Map<String, String> userInfo = (Map<String, String>) value;

        // 3. 데이터 사용
        String id = userInfo.get("userId");     // "123"
        String name = userInfo.get("name"); // "psw"
    %>
    userId : <%= id %> <br>
    name : <%= name %>
    <br>

    <h4>2). 쿠키(Cookie)란?</h4>
    <ol>
        <li>쿠키란 클라이언트 측에서 관리되는 정보를 의미한다.</li>
        <li>쿠키는 클라이언트와 서버 간의 상태를 유지시켜주는 역할을 한다. </li>
    </ol>

    <%
        // 서버에서 쿠키 생성 후 클라이언트로 전송하는 방법
        // 쿠키를 생성한다.
        Cookie cookie = new Cookie("test-cookie", "test-check");

        // 쿠키의 만료 시간을 정한다.
        // cookie.setMaxAge(10);
        cookie.setMaxAge(-1);   // 브라우저가 종료될 때까지 유지된다. (세션 쿠키)

        // 쿠키를 모든 or 특정 경로에서 사용하도록 설정한다.
        cookie.setPath("/");

        // 쿠키를 클라이언트에 전송한다.
        response.addCookie(cookie);

        // 클라이언트에서 서버로 전송한 쿠키를 얻어노는 방법
        // 1. 클라이언트로부터 전송된 모든 쿠키를 배열로 받아온다.
        Cookie[] cookies = request.getCookies();

        // 2. 반복문을 사용하여 쿠키 배열의 값을 출력한다.
        for (Cookie c : cookies) {
            out.print(c.getName() + "=" + c.getValue());
            out.print("<br>");
        }
    %>

    <h2>5. application</h2>
    <p>
        웹 애플리케이션의 실행 환경을 제공하는 서버의 정보와 서버 측 자원에 대한 정보를 저장하고 있는 객체이다.
    </p>

    <table border="1">
        <tr>
            <td>서버 정보</td>
            <td><%= application.getServerInfo()%> </td>
        </tr>
        <tr>
            <td>모듈 정보</td>
            <td><%= application.getMajorVersion()%>.<%= application.getEffectiveMajorVersion()%> </td>
        </tr>
        <tr>
            <td>웹 애플리케이션의 실제 파일 시스템 경로</td>
            <%-- <td><%= application.getRealPath("/")%> </td> --%>
            <td><%= application.getRealPath("/views/error/error404.jsp")%></td>
        </tr>
    </table>
</body>
</html>
