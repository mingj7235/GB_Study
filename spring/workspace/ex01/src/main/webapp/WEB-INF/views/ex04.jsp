<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EX04</title>
</head>
<body>
	<h1>EX04</h1>
	<h2>
		ArrayList :
		<c:forEach var= "word" items="${words}">
			<c:out value="${word}"/> 
		</c:forEach>
	</h2>
</body>
</html>