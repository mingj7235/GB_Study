<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST (출력의 종류)</title>
</head>
<body>
	${"<script>alert('안녕')</script>"}
	
	<c:out value="<script>alert('안녕')</script>" escapeXml="false"></c:out>
	<c:out value="<script>alert('안녕')</script>"></c:out> <!-- escapeXml의 default는 true다. 즉, 명령어로 인식하지마라!!  =>  -->
</body>
</html>