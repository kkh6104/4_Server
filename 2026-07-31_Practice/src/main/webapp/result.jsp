<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
	String message="";
	if(request.getAttribute("message") != null) {
		message = "<h2>Forward 이동 성공: ["+(String)request.getAttribute("message")+"]</h2>";
	} else {
		message = "<h2>Redirect 이동 성공</h2>";
	}
%>

<%= message %>


</body>
</html>