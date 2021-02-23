<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>include 디렉티브 태그 예제</title>
</head>
<body>
	<!-- 헤더영역 -->
	<%@ include file = "header.jsp" %> <!-- 인클루드 디렉티브 태그 -->
	<hr>
	<h4>------------------------현재 페이지 영역----------------------</h4>
	<hr>
	<!-- 푸터영역 -->
	<jsp:include page = "footer.jsp" %> <!-- 액션 태그-->
</body>
</html>