<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 실습(제어문 - 반복문)</title>
</head>
<body>

<!-- 
	1단부터 100단까지 중 사용자에게 입력받은 단수로 구구단 출력하기.
	입력받은 값이 정수인지 아닌 지 판단, 값을 입력했는지 안했는지 판단.
	다른 페이지 이동 없이 현재 페이지에서만 기능 구현
	자바스크립트 사용가능 (Number.isInteger(값) : boolean)
 -->

	<h2>JSTL 실습(제어문 -반복문)</h2>
	<form>
	단 수 : <input type="text" name ="num" id ="num">
	<input type="button" onclick ="checkNum()">
	</form>
	
	<c:set var="num" value="${param.num}"/> <!-- 파라미터 저장 -->
		<c:choose>
			<!-- 입력한 값이 0보다 크고 101보다 작을 때 -->
			<c:when test="${num>0 || num <101 }">
				<c:forEach var="i" begin="1" end="9">
					<c:out value="${num*i}"/>
				</c:forEach>
			</c:when>
			<c:otherwise>
				0보다 크고 101보다 작은 값을 입력해주세요.
			</c:otherwise>
		</c:choose>
</body>
<script>
	//엔터 처리 
	//정수인지 아닌지 판단
	function checkNum () {
		if(!Number.isInteger(parseInt(document.getElementById("num")))) {
			alert("숫자를 입력해주세요");
			return false;
		}
		if(document.getElementById("num").value == ""){
			alert("값을 입력해주세요");
			return false;
		}
	}
</script>
</html>