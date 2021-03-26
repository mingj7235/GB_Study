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
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.3/css/all.css" integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk" crossorigin="anonymous">
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
			
			input[type="checkbox"] + label {
				font-family: 'Sunflower', sans-serif;
				font-weight: bold;
				font-size: 0.85em;
			}
			
			input[type="checkbox"] + label:before {
				content: '\f00c';
				border: solid 1px #ffaec9;
				color: #ffaec9;
			}
			
			input[type="button"]{
				font-size:0.9rem;
			}
			
			.up_box{
				padding: 5px 0 5px 8px;
    			border: solid 1px #e6e6e6;
    			background: #f9f9f9;
			}
			
			.down_box{
				padding: 12px 12px 15px 14px;
    			border-bottom: solid 1px #e6e6e6;
    			border-right: solid 1px #e6e6e6;
    			border-left: solid 1px #e6e6e6;
			}
			
			#term{
				width : 100%; 
				height : 12
				0px; 
				resize: none;
				border: none;
			}
			
			.fas{
				font-size:1.3rem;
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
							<header id="header">	
								<a href="${pageContext.request.contextPath}/index.jsp" class="logo">
								<img src="${pageContext.request.contextPath}/images/logo_header.png" width="60" height="27" />
								</a>	
							</header>

							<!-- Content -->
							<div style="display:flex; flex-direction:column; align-items:center;">
								<div style="margin:4% 0;">
									<p class="title">JOIN US<sup style="margin-left:5px;"><i class="fas fa-heart"></i></sup><i class="fas fa-heart"></i></p>
								</div>
								<div style="width:43%;">
									<div class="col-6 col-12-small" style="margin-top: 10px; padding-left:8px;">
										<input type="checkbox" id="agreeAll" name="agreeAll">
										<label for="agreeAll">이용약관, 개인정보 수집 및 이용에 모두 동의합니다.</label>
									</div>
									<div class="terms" style="margin-bottom:20px;">
										<div class="up_box">
											<div class="col-6 col-12-small" style="margin-top: 10px;">
												<input type="checkbox" id="agree01" name="agree01">
												<label for="agree01">이용약관</label>
											</div>
										</div>
										<div class="down_box">
											<textarea name="term" id="term" disabled>
											</textarea>
										</div>
									</div>
									
									<div class="terms" style="margin-bottom:40px;">
										<div class="up_box">
											<div class="col-6 col-12-small" style="margin-top: 10px;">
												<input type="checkbox" id="agree02" name="agree02">
												<label for="agree02">개인정보수집 및 이용</label>
											</div>
										</div>
										<div class="down_box">
											<textarea name="term" id="term" disabled>
											</textarea>
										</div>
									</div>
								</div>
								
								<div class="btns">
									<div class="col-12">
										<ul class="actions" style="width:100%;">
											<li><input type="button" value="동의" class="primary" style="width:150px;" /></li>
											<li><input type="button" value="비동의" style="width:150px;"/></li>
										</ul>
									</div>
								</div>
							</div>		

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