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
		<title>Untitled</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
    	<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/zaccordion.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
		<style>
			body{
				font-family: 'Sunflower', sans-serif;
			}
			
			h1, h2, h3, h4 {
				font-family: 'Sunflower', sans-serif;
			}
			
			.report{
				margin-bottom:10px;
				color:#ffaec9;
				font-weight:bold;
			}
			
			.report span{
				color:black;
				margin-left:5px;
				font-weight:100;
			}
			
			.graph {
				width:80%;
			}
			
			.graph__description {
			    display: flex;
			    justify-content: space-between;
			    margin-bottom: 10px;
			}

			.graph__bar{
			    height: 3px;
			    background-color: #D3D3D3;
			    margin-bottom: 15px; 
			}
			
			.graph__value{
			    width: 100%;
			    height: 3px;
			    background-color: #ffaec9;
			}
			
			.article {
				/* opacity: 0.1; */			
			}
			
			.slide-img {
				max-width: 100%;
			}
			
			@media screen and (max-width: 1400px) {
				.slide-img {
					max-width: 100%;
					height: 320px !important;
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

							<!-- main section -->
								<section style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:3em;">다비와 함께 운동할까요?</h1>
										<p>유명 유투버들과 함께하는 홈 트레이닝 !  </p>
									</header>
								</section>
								
							<!-- section -->
								<section style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:2em;">1. 땅끄부부 </h1>
										<p>보기만 해도 운동하고 싶게 만드는 땅끄부부의 즐거운 케미!</p>
									</header>
									
									<div style=" ">
										썸네일
									</div>
									
								</section>

							<!-- Section -->
								<section style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:2em;">2. 힙으뜸 </h1>
										<p>스쿼트 대한민국 1인자 힙으뜸과 함께 신나게 홈트를! </p>
									</header>
								</section>

							<!-- Section -->
								<section style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:2em;">3. 빵느</h1>
										<p>요일별로 규칙적인 </p>
									</header>
								</section>
							
						</div>
					</div>
					<c:import url="/app/footer/footer.jsp" />
			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/zaccordion.js"></script>
			<script src="${pageContext.request.contextPath}/index.js"></script>
			<script>
				/*jslint sloppy: true, white: true */
				/*globals $, document*/
				
		</script>
	</body>
</html>