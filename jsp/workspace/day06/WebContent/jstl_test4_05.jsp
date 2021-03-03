<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(제어문 - 반복문)</title>
</head>
<body>
	forEach 연습 결과
	<c:forEach var="i" begin="1" end="10" step="1">
		<c:out value="${i}"/> &nbsp;&nbsp;
	</c:forEach>
	<hr>
	varStatus 연습 결과 <br>
	<c:forEach var="i" begin="1" end="10" step="1" varStatus="stat"> <!-- stat이라는 객체에 반복문에 대한 정보가 들어가있다.  -->
		index : <c:out value="${stat.index}"></c:out><br>
		count : <c:out value="${stat.count}"></c:out><br>
		begin : <c:out value="${stat.begin}"></c:out><br>
		end : <c:out value="${stat.end}"></c:out><br>
		step : <c:out value="${stat.step}"></c:out><br>
		first : <c:out value="${stat.first}"></c:out><br>
		last : <c:out value="${stat.last}"></c:out><hr>
	</c:forEach>
	
	
	
</body>
</html>
























