<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%
    request.setAttribute("gender", "남자");
    pageContext.setAttribute("age", 24);

    System.out.println(request.getAttribute("gender"));
    System.out.println(pageContext.getAttribute("age"));

    // pageContext.forward("scopeTest3.jsp");

    response.sendRedirect("scopeTest3.jsp");
%>