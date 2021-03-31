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
<style>
	.myMenu{
		list-style: none;
		position: relative;
		top:20px;
	}
	
	.myMenu li{
		float: left;		
					
	}
		
	.myMenu ul{
		list-style: none;
		position: absolute;
		display: none;
	}
	
	.myMenu ul li{
		float: none;
	}
	.myMenu ul li a{
		color: black;
	}
		
	.myMenu li:hover ul{
	display: block;}
</style>
</head>
<body>
	<!-- Header -->
	<header id="header">	
		<div class="row">
			<div class="col-4">
				<a href="${pageContext.request.contextPath}/index.jsp" class="logo">
				<img src="${pageContext.request.contextPath}/images/logo_header.png" width="78" height="35" />
				</a>	
			</div>
			
			<div class="col-8" style="display: flex; justify-content:flex-end; flex-wrap:nowrap;">				
				<ul class="myMenu" style="display:flex; justify-content:flex-end; flex-wrap:nowrap; width:40%;">
					<!-- 세션의 아이디로그인 정보를 이용하여 if문의 조건 검색 -->
					<c:set var="check" value="2" />
					<c:if test="${check eq 1}">					
						<li><a href="#">로그인</a>&nbsp;</li>
						<li><a href="#" >회원가입</a></li>
					</c:if>
					<c:if test="${check eq 2}">
						<li style="margin-right:3%;">(#)님 환영합니다.</li>								
				 	<li style="color: #ffaec9; margin-right:3%;">나의페이지
							<ul style="background:white; padding-right:3%; margin-top:1%;">
								<li style="padding-left:0;"><a href="#">나의정보수정</a></li>
								<li style="padding-left:0;"><a href="#">비밀번호변경</a></li>
								<li style="padding-left:0;"><a href="#">나의식단관리</a></li>
							</ul>
					</li>													
					<li><a href="#">로그아웃</a>&nbsp;</li>
					</c:if>
				 </ul>		
			</div>
		</div>
	</header>
</body>
</html>