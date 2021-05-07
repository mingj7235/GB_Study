<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX03</title>
</head>
<body>
	<h1>EX03</h1>
	<h2>
		ArrayList :
		<c:forEach var= "data" items="${datas}">
			<c:out value="${data}"/> 
		</c:forEach>
	</h2>
</body>
</html>