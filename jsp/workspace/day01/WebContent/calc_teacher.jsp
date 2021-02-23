<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>JSP로 만든 페이지</h1>
	<form action = "Result_teacher">
		<p>수식을 입력하세요(두 정수의 사칙연산만 가능합니다) </p>
		<input type="text" name ="input"> <!-- name을 서블릿에서 파라미터의 key 값으로 사용한다. -->
		<button type="submit">확인</button>
	</form>
</body>
</html>