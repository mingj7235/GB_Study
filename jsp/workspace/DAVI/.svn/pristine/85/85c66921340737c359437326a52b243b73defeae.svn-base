<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<!DOCTYPE HTML>
<!--
	Editorial by Pixelarity
	pixelarity.com | hello@pixelarity.com
	License: pixelarity.com/license
-->
<html>
	<head>
		<title>로그인</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
		<style>
			 body{
				font-family: 'Sunflower', sans-serif;
			} 
			
			@media screen and (min-width: 1400px) {
				.davi-img, .img{
					height:400px !important;
				}
			}
			
			@media screen and (max-width: 1400px) {
				.davi-img, .img{
					height:300px !important;
				}
			}
		</style>
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

							<!-- Header -->
							<c:import url="/app/header/header.jsp" />
					
							<!-- Content -->
							<section style="padding-top:3%; display:flex; justify-content:center; margin-top:5%;">
							<div class="davi-img" style="height:300px; padding-top:5%;">
								<img class="img" alt="" src="https://en.pimg.jp/060/396/702/1/60396702.jpg">
							</div>
							
							<div style="width:60%;">
								<form method="post" action="#">
									<hr style="background-color: #ffaec9; height: 3px; width:70%; margin:5% auto;">
									<h2 align="center">다비를 부를까요?</h2>	
									<div class="row gtr-uniform" style="text-align:center;">
										<div class="col-12">
											<input type="text" name="memberId" id="memberId"  placeholder="아이디" style="width:50%; margin:1% auto;" />
											<input type="password" name="memberPw" id="memberPw" placeholder="비밀번호" style="width:50%; margin:1% auto;"/>
										</div>
										
										<!-- button -->
										<div class="col-12" style="padding-top:0%;">
										<input type="submit" value="Login" class="primary" style="width:50%; margin:1% auto;">
										<div><img src="${pageContext.request.contextPath}/images/mini_logo.png" style="margin-top:2%;"><a href="findId.jsp"> 아이디/비밀번호 찾기</a></div>
										<hr style="background-color: #ffaec9; height: 3px; width:70%; margin:5% auto;">
										<div><img src="${pageContext.request.contextPath}/images/mini_logo.png"> 아직 DAVI의 회원이 아니신가요? > <a href="join.jsp">회원가입</a></div>
										</div>
									</div>
								</form>
							</div>
							</section>
						</div>
					</div>

				<!-- Sidebar -->
					<c:import url="/app/footer/footer.jsp" />

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

	</body>
</html>