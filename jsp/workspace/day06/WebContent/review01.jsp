<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:set var ="name" value ="김민재" scope="page"/>
	<c:out value="${name}"/>
	<hr>
	
	<c:set var = "nation" scope="session">미국</c:set>
	<c:out value="nation"></c:out>
</body>
</html>