<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>POST 방식 전송 예제</title>
</head>
<body>
	<h1>POST방식의 요청</h1>
	<form action = "get_test.jsp" method = "post">
		<input type ="text" name = "city" value = "Busan" readonly>
		<input type ="text" name = "zipcode" value = "12345" readonly>
		<button type ="submit"> POST방식으로 요청 보내기! </button>
	</form>
</body>
</html>