<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>

<%
    /*
        forward
            - 매개값으로 지정한 경로로 서버 내부에서 요청을 전달한다.
            - 동일한 request와 response 객체를 사용하므로 요청과 응답 정보가 유지된다.
     */
    // 컨텍스트 루트(webapp)를 기준으로 경로를 지정해야 한다.
    // pageContext.forward("forward_target.jsp");
    pageContext.forward("/views/objects/forward_target.jsp");
%>