<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ajax와 통신할 페이지</title>
</head>
<body>
<%
	String city = request.getParameter("city");
	String zipcode = request.getParameter("zipcode");
	
	out.println("도시 : " + city);
	out.println("우편주소 : " + zipcode);
%>
</body>
</html>