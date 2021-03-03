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

<c:choose>
	<c:when test="${empty param.memberName }">
		<form>
			이름 : <input type="text" name="memberName">
			<input type="submit" value="check">		
		</form>
	</c:when>
	<c:when test="${param.memberName =='admin'}">
		관리자
	</c:when>
	<c:otherwise>
		<c:out value="${param.memberName}"/>님이 접속시도 했습니다. 
	</c:otherwise>
</c:choose>

</body>
</html>