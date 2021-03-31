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
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
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
			
			.sub_text{
				color: #ffaec9;
			}
			.main_div_frame{
				display: flex;
				justify-content: center;
				margin-bottom: 30px;
			}
			
			.thum_div_frame {
				width: 70%;
				height: 200px;
				border : 1px solid black;
			}
			.detail_div_frame {
				width: 70%;
				height: 400px;
				border : 1px solid black;
			}
			
			.link_div_frame{
				width: 70%;
				height: 100px;
				border: 1px solid red;
			}
			
			.profile_img {
				border: 0.1px solid white;
				border-radius: 50%;
				margin: 0 10px;
			}
			
			.to_top:hover {
				color: 0.3s;
			}
			
			.title_profile{
				text-align: center;
				margin : 0;
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

							<!-- head section -->
								<section id="home" style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:3em;">다비와 함께 운동할까요?</h1>
										<p class="sub_text">유명 유투버들과 함께하는 홈 트레이닝 ! </p>
									</header>
									
									<div class="main_div_frame"> 
										<!-- 땅끄부부 -->
										<a href="#home1" style="color: #3d4449;">
											<div class="main_div_frame" style="margin:0;">
												<i class="fas fa-running" style="margin:0 3px; padding-top: 3px;" ></i>
												<p class="title_profile"> 땅끄부부 </p>
											</div>
											<img class ="profile_img"src="//yt3.ggpht.com/ytc/AAUvwni3JGKV46GeWxoCBjZUtbtLdMeaZOk4TAIlCzbaVw=s176-c-k-c0x00ffffff-no-rj-mo">
										</a>
										
										<!-- 힙으뜸 -->
										<a href="#home2" style="color: #3d4449;">
											<div class="main_div_frame" style="margin:0;">
												<i class="fas fa-running" style="margin:0 3px; padding-top: 3px;" ></i>
												<p class="title_profile"> 힙으뜸 </p>
											</div>
											<img class ="profile_img"src="//yt3.ggpht.com/ytc/AAUvwnhH3QCR8PYXkM0RyDjjTvVCB_86Gu70-vTj_jTUHg=s176-c-k-c0x00ffffff-no-rj-mo">
										</a>
										
										<!-- 빵느 -->
										<a href="#home3" style="color: #3d4449;">
											<div class="main_div_frame" style="margin:0;">
												<i class="fas fa-running" style="margin:0 3px; padding-top: 3px;" ></i>
												<p class="title_profile"> 빵느 </p>
											</div>
											<img class ="profile_img"src="//yt3.ggpht.com/ytc/AAUvwnhk4FEHP7ZmWOBXjhno8qdATCBQ1F86Chzj8ilycQ=s176-c-k-c0x00ffffff-no-rj-mo">
										</a>
									</div>
									
									
								</section>
								
							<!-- section 땅끄부부 -->
								<section id="home1" style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:2em;">1. 땅끄부부 </h1>
										<p class="sub_text">보기만 해도 운동하고 싶게 만드는 땅끄부부의 즐거운 케미!</p>
									</header>
									<div class="main_div_frame">
										<div class ="thum_div_frame">
											<c:import url="/app/pages/thumnail.jsp"/>
										</div>
									</div>
									<div class="main_div_frame">
										<div class ="detail_div_frame">
											디테일
										</div>
									</div>
									<div class="main_div_frame">
										<div class ="link_div_frame">
											링크
										</div>
									</div>
									
									
									
									
								</section>

							<!-- Section 힙으뜸 -->
								<section id="home2" style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:2em;">2. 힙으뜸 </h1>
										<p class="sub_text">스쿼트 대한민국 1인자 힙으뜸과 함께 신나게 홈트를! </p>
									</header>
									<div class="main_div_frame">
										<div class ="thum_div_frame">
											썸네일
										</div>
									</div>
									<div class="main_div_frame">
										<div class ="detail_div_frame">
											디테일
										</div>
									</div>
									<div class="main_div_frame">
										<div class ="link_div_frame">
											링크
										</div>
									</div>								
								</section>

							<!-- Section 빵느-->
								<section id="home3" style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:2em;">3. 빵느</h1>
										<p class="sub_text">요일별로 규칙적인 </p>
									</header>
									<div class="main_div_frame">
										<div class ="thum_div_frame">
											썸네일
										</div>
									</div>
									<div class="main_div_frame">
										<div class ="detail_div_frame">
											디테일
										</div>
									</div>
									<div class="main_div_frame">
										<div class ="link_div_frame">
											링크
										</div>
									</div>							
								</section>
							<!-- top button -->
							
							<div style="position: fixed; bottom: 20px; right:20px; border: 0.1px solid #ffe7ff;">
								<a id="to_top" href="#home" style="font-size:1em; padding: 10px;">위로가기</a>
							</div>
							
							
							
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
			<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/zaccordion.js"></script>
			<script src="${pageContext.request.contextPath}/index.js"></script>
			<script>
				
		</script>
	</body>
</html>