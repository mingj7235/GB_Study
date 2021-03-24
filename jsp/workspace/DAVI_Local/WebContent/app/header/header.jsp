<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>header</title>
</head>
<body>
	<!-- Header -->
	<header id="header">
		<a href="index.jsp" class="logo"><strong>DAVI</strong> </a>
		<ul class="actions small">
			<!-- 세션의 아이디로그인 정보를 이용하여 if문의 조건 검색 -->
			<c:set var="check" value="1" />
			<c:if test="${check eq 1}">					
				<li><a href="#" class="button primary small">로그인</a></li>&nbsp;
				<li><a href="#" class="button small">회원가입</a></li>
			</c:if>
			<c:if test="${check eq 2}">
				<li><a href="#" class="button primary small">로그아웃</a></li>
			</c:if>						
		</ul>
	</header>
		
</body>
</html>