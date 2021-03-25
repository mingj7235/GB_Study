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
								<section style="padding-top:3%;">
								
									<a href="${pageContext.request.contextPath}/index.jsp" style="text-align: center; display: block; margin-left:32%; margin-right:32%; border:0;">
										<img src="${pageContext.request.contextPath}/images/logo_2.png"  style="max-width:100%; height:auto;"/>
									</a>
							
								
										<form method="post" action="#">
														<div class="row gtr-uniform" style="text-align:center;">
															<div class="col-12">
																<input type="text" name="memberId" id="memberId"  placeholder="아이디를 입력하세요." style="width:49%; margin-top: 3%;margin-left: 25.5%;" />
																<input type="password" name="memberPw" id="memberPw" placeholder="비밀번호를 입력하세요." style="width:49%; margin-top: 3%;margin-left: 25.5%;"/>
															</div>

															<!-- button -->
															<div class="col-12">
															<input type="submit" value="Login" class="primary" style="width:49%; margin-top:1%; margin-bottom:1%;">
															<div><img src="${pageContext.request.contextPath}/images/mini_logo.png" style="margin-top:2%;"><a href="findId.jsp">아이디/비밀번호 찾기</a></div>
															<hr style="background-color: #ffaec9; height: 2px; width:49%; margin-left:25.5%; margin-top:2%; margin-bottom:3%;">
															<div><img src="${pageContext.request.contextPath}/images/mini_logo.png">아직 DAVI의 회원이 아니신가요? > <a href="join.jsp">회원가입</a></div>
															</div>
														</div>
													</form>

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