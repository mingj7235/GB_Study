<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>500</title>
</head>
<body>
	<h4><c:out value="${exception.getMessage()}"></c:out></h4>
	
	<!-- 에러메세지들을 계속 반복통해서 출력해주도록함 -->
	<ul>
		<c:forEach var="stack" items="${exception.getStackTrace()}">
			<li><c:out value="${stack}"/></li>
		</c:forEach>
	</ul>
</body>
</html>