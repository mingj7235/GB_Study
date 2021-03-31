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
		<title>비밀번호 변경</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">
		<style>
			 body{
				font-family: 'Sunflower', sans-serif;
			} 
			
			.title{
				font-size: 3rem;
				font-family: 'Cute Font', cursive;
				color: #ffaec9;
				margin-bottom: 3%;
			}
			
			input[type="password"], input[type="password"]:focus {
				border:0 !important;
				border-bottom: solid 1px #ffaec9 !important;
				border-radius:0;
				box-shadow: none;
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
									<div style="display: flex; justify-content: center;">
										<p class="title">비밀번호 변경</p>
									</div>
									
										<form method="post" action="#">
											<div class="row gtr-uniform" style="text-align:center;">
												<div class="col-12">
													<input type="password" name="memberPw" id="memberPw" placeholder="기존 비밀번호" style="width:30%; margin:1% auto;"/>
												</div>
												<div class="col-12">
													<input type="password" name="memberPw" id="memberPw" placeholder="새 비밀번호" style="width:30%; margin:3% auto 1% auto;"/>
												</div>
												<div class="col-12">
													<input type="password" name="memberPw" id="memberPw" placeholder="새 비밀번호 확인" style="width:30%; margin:0 auto 1% auto; "/>
												</div>
												<div class="col-12" style="padding-top:0%;">
													<input type="submit" value="비밀번호 변경" class="primary" style="width:30%; margin:1% auto;">
												</div>
												<div class="col-12" style="padding-top:0%;">
													<input type="button" value="뒤로가기" class="" style="width:30%; margin:1% auto 3% auto;" onclick="">
												</div>
											</div>
											<div style="display: flex; justify-content: center;" id="google_recaptha">
												<div class="g-recaptcha" data-sitekey="6Lf-kZQaAAAAABHmNQ793nhzjcBQTN-fY2BJZvwE"></div>
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
			<script src='https://www.google.com/recaptcha/api.js'></script>
			<script>
				function winClose() {
					 window.open('','_self').close();
				}
			</script>

	</body>
</html>