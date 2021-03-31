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
		<title>회원 정보 입력</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
		<style>
			 body{
				font-family: 'Sunflower', sans-serif;
			} 
			
			input[type="text"], input[type="text"]:focus{
				border:0 !important;
				border-bottom: solid 1px #ffaec9 !important;
				border-radius:0;
				box-shadow: none;
			}
			
			@media screen and (min-width: 1400px) {
				.davi-img, .img{
					height:400px !important;
				}
			}
			
			@media screen and (max-width: 1400px) {
				.davi-img, .img{
					height:350px !important;
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
							<section style="padding-top:3%; display:flex; justify-content:center; align-items:center; margin-top:5%;">
							<div class="davi-img" style="height:400px;">
								<img class="img" alt="" src="https://en.pimg.jp/060/396/701/1/60396701.jpg">
							</div>
							
							<div style="width:60%;">
								<form method="post" action="#">
									<hr style="background-color: #ffaec9; height: 3px; width:70%; margin:7% auto;">
									<h2 align="center">다비가 도와드릴께요!</h2>	
									<div class="row gtr-uniform" style="text-align:center;">
										<div class="col-12">
											<input type="text" name="memberName" id="memberName"  placeholder="키 (숫자만 입력)" style="width:50%; margin:1% auto;" />
											<input type="text" name="memberEmail" id="memberEmail" placeholder="몸무게 (숫자만 입력)" style="width:50%; margin:1% auto;"/>
											<input type="text" name="memberEmail" id="memberEmail" placeholder="목표 몸무게 (숫자만 입력)" style="width:50%; margin:1% auto;"/>
											<textarea name="demo-message" id="demo-message" placeholder="내가 되고 싶은 모습" rows="6" style="width:50%; margin:2% auto; height:80px; border:1px solid #ffaec9; "></textarea>
											<textarea name="demo-message" id="demo-message" placeholder="각오" rows="6" style="width:50%; margin:2% auto; height:80px; border:1px solid #ffaec9; "></textarea>
										</div>
										
										<!-- button -->
										<div class="col-12" style="padding-top:0%;">
										<input type="submit" value="제출하기" class="primary" style="width:50%; margin:1% auto;">
										<hr style="background-color: #ffaec9; height: 3px; width:70%; margin:7% auto; margin-bottom:5%;">
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