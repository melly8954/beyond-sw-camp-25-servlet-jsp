<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    /*
        sendRedirect
            - 매개값으로 지정한 경로로 클라이언트에게 다시 요청하도록 응답한다.
            - 리다이렉트는 브라우저가 새로운 요청을 다시 보내는 방식으로 이전 요청과 응답 정보는 유지되지 않는다.
     */

    // response.sendRedirect("redirect_target.jsp");
    // response.sendRedirect("http://localhost:8080/jsp/views/objects/redirect_target.jsp");
    // response.sendRedirect("/jsp/views/objects/redirect_target.jsp");
    response.sendRedirect(request.getContextPath() + "/views/objects/redirect_target.jsp");
%>