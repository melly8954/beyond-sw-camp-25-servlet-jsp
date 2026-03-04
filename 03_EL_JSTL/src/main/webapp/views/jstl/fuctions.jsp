<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<%@ taglib uri="jakarta.tags.fmt" prefix="fmt" %>
<%@ taglib uri="jakarta.tags.functions" prefix="fn" %>
<html lang="ko">
<head>
  <meta charset="UTF-8">
  <title>JSTL Function Library</title>
</head>
<body>
  <h2>JSTL Function Library</h2>

  <c:set var="str" value="java mariadb HTML5 CSS3 Javascript Servlet JSP"/>

  원본 : ${ str }<br>
  문자열 길이 : ${ fn:length(str) } 또는 ${ str.length() }<br>
  대문자 변경 ${ fn:toUpperCase(str)} 또는 ${ str.toUpperCase() }<br>
  소문자 변경 ${ fn:toLowerCase(str)} 또는 ${ str.toLowerCase() }<br>
  원본 : ${ str }<br><br>
</body>
</html>
