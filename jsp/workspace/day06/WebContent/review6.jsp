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

<form name="gugudan">
	단수 : <input type="text" name="dan" placeholder="정수입력">
	<input type="button" value="구구단계산" onclick="cal()">
</form>

	<c:set var="dan" value="${param.dan}"/>
	<c:if test="${not empty dan}">
		<c:choose>
			<c:when test="${dan > 0 and dan <101 }">
				<c:forEach var="i" begin="1" end="9">
					<c:out value="${dan} x ${i } = ${dan * i}"/> <br>
				</c:forEach>
			</c:when>		
			<c:otherwise>
				1이상 100이하 값으로 입력하셈
			</c:otherwise>
		</c:choose>
	</c:if>


</body>
<script>
	document.addEventListener("keydown", function (key){
		if(key.keyCode == 13) {
			key.preventDefault();
		}
	});

	function cal() {
		var frm = document.gugudan;
		var data = frm.dan.value;
		var check = data % 1 == 0;
		
		if(!Number.isInteger(parseInt(data)) || data == "" || !check) {
			alert("정수를 입력해주세요");
			return false;
		}
		
		frm.dan.value = parseInt(data);
		
		frm.submit();
	
	}

</script>
</html>