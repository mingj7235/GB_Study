<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
<title>header</title>
</head>
<body>
	<!-- Header -->
	<header id="header">	
		<a href="${pageContext.request.contextPath}/index.jsp" class="logo">
		<img src="${pageContext.request.contextPath}/images/logo_header.png" width="60" height="27" />
		</a>	
		<ul class="actions small" style="display:flex; justify-content:flex-end;">
			<!-- 세션의 아이디로그인 정보를 이용하여 if문의 조건 검색 -->
			<c:set var="check" value="2" />
			<c:if test="${check eq 1}">					
				<li><a href="#" >로그인</a></li>&nbsp;
				<li><a href="#" >회원가입</a></li>
			</c:if>
			<c:if test="${check eq 2}">
				(#)님 환영합니다.<li><a href="#">로그아웃</a></li>
			</c:if>						
		</ul>		
	</header>
		
</body>
</html>