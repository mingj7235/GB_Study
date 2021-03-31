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

							<!-- Banner -->
								<section style="padding:2% 0;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%; margin:2% 0 1.3% 0;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:3em; color:#e9b0df;">오직 나만의 다이어트 비서</h1>
										<p style="font-weight:bold;">혼자서하는 다이어트 그만! 이제 다비의 관리를 받아보세요~</p>
									</header>
										<div id="container">
											<div id="examples" style="margin-top:2%; display:flex; justify-content:center;">
												<ul id="example1">
													<li>
														<img src="https://cdn.discordapp.com/attachments/821644547493986328/826634189184172073/1.jpg" width="750" height="500" alt="" class="slide-img"/>
													</li>
													<li>
														<img src="https://cdn.discordapp.com/attachments/821644547493986328/826628746726998066/ver2.jpg" width="750" height="500" alt="" class="slide-img"/>
													</li>
													<li>
														<img src="https://cdn.discordapp.com/attachments/821644547493986328/826634191960801320/3.jpg" width="750" height="500" alt="" class="slide-img"/>
													</li>
													<li>
														<img src="https://cdn.discordapp.com/attachments/821644547493986328/826628750594015332/ver2.png" width="750" height="500" alt="" class="slide-img"/>
													</li>
													<li>
														<img src="https://cdn.discordapp.com/attachments/821644547493986328/826634192133423134/2.png" width="750" height="500" alt="" class="slide-img"/>
													</li>
													<li>
														<img src="https://cdn.discordapp.com/attachments/821644547493986328/826628752942694430/ver2.jpg" width="750" height="500" alt="" class="slide-img"/>
													</li>
												</ul>
											</div>
										</div>
								</section>

							<!-- Section -->
								<section style="padding:6% 10%;">
									<header style="display:flex; flex-direction:column; justify-content:center; align-items:center; margin-bottom:0.5%;">
										<h1 style="padding-right:10px; margin-bottom:1.5%; font-size:3em;">다비의 Daily 보고서</h1>
										<p>매일매일 관리받아보세요!</p>
									</header>
									<div class="features" style="border:20px solid #FCEEF5; padding:4% 4% 4% 0;">
										<article class="article">
											<span class="icon fa-gem"></span>
											<div class="content">
												<h3>인증 Report</h3>
												<p class="report">베스트 게시판 : <span>10개</span></p>
												<p class="report">daily 인증 : <span>80회</span></p>
												<p class="report">성공 후기 : <span>2개</span></p>
											</div>
										</article>
										<article class="article">
											<span class="icon solid fa-paper-plane"></span>
											<div class="content">
												<h3>다비의 한마디</h3>
												<p class="report">다이어트 하기로 했으면</p>
												<p class="report">마음만 먹어야지</p>
												<p class="report">자꾸 이것 저것 먹으면 되겠니?</p>
											</div>
										</article>
										<article class="article">
											<span class="icon solid fa-rocket"></span>
											<div class="content">
												<h3>각오 & 목표</h3>
												<p class="report">각오 : <span>날 무시하던 전남친에게 제대로 복수하기!</span></p>
												<p class="report">목표 : <span>20kg 감량!!</span></p>
											</div>
										</article>
										<article class="article">
											<span class="icon solid fa-signal"></span>
											<div class="content">
												<h3>다이어트 Report</h3>
												<div class="graph">
									              <div class="graph__description">
									                <span>목표: 54kg</span>
									                <span>70%</span>
									              </div>
									               <div class="graph__bar">
									                <div class="graph__value" style="width: 70%"></div>
									              </div>
									            </div>
												<div class="graph">
									              <div class="graph__description">
									                <span>인증 현황</span>
									                <span>18/20 (90%)</span>
									              </div>
									              <div class="graph__bar">
									                <div class="graph__value" style="width: 90%"></div>
									              </div>
									            </div>
											</div>
										</article>
									</div>
								</section>

							<!-- Section -->
								<section style="padding:4% 10% 4% 6%;">
									<div class="headers" style="display:flex; margin-bottom:2%;">
										<header id="best" class="major" style="margin-right:15px; cursor:pointer;">
											<h3 style="padding-right:10px;">베스트 인증 게시판</h3>
										</header>
										<h3 style="margin-right:15px;">|</h3>
										<header id="free" class="" style="margin-right:15px; cursor:pointer;">
											<h3 style="padding-right:10px;">자유 게시판</h3>
										</header>
										<h3 style="margin-right:15px;">|</h3>
										<header id="cheat" class="" style="margin-right:15px; cursor:pointer;">
											<h3 style="padding-right:10px;">치팅 모임</h3>
										</header>
									</div>
									
									<div id="best_posts" class="posts" style="width:100%; margin:auto; padding:3% 6em 3% 0; border:20px solid #FCEEF5;">
										<article style="">
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">1st</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;20901</span>
											</div>
											<a href="#" class="image"><img src="images/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">2nd</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;18902</span>
											</div>
											<a href="#" class="image"><img src="images/pic02.jpg" alt="" /></a>
											<h3>Nulla amet dolore</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">3rd</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;16239</span>
											</div>
											<a href="#" class="image"><img src="images/pic03.jpg" alt="" /></a>
											<h3>Tempus ullamcorper</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">4th</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;13289</span>
											</div>
											<a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
											<h3>Sed etiam facilis</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">5th</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;11092</span>
											</div>
											<a href="#" class="image"><img src="images/pic05.jpg" alt="" /></a>
											<h3>Feugiat lorem aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">6th</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;9999</span>
											</div>
											<a href="#" class="image"><img src="images/pic06.jpg" alt="" /></a>
											<h3>Amet varius aliquam</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum.</p>
										</article>
									</div>
									<div id="free_posts" class="posts" style="display:none;">
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">1st</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;20901</span>
											</div>
											<a href="#" class="image"><img src="images/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">2nd</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;18902</span>
											</div>
											<a href="#" class="image"><img src="images/pic02.jpg" alt="" /></a>
											<h3>Nulla amet dolore</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">3rd</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;16239</span>
											</div>
											<a href="#" class="image"><img src="images/pic03.jpg" alt="" /></a>
											<h3>Tempus ullamcorper</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">4th</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;13289</span>
											</div>
											<a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
											<h3>Sed etiam facilis</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">5th</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;11092</span>
											</div>
											<a href="#" class="image"><img src="images/pic05.jpg" alt="" /></a>
											<h3>Feugiat lorem aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.8rem; font-weight:bold;">6th</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;9999</span>
											</div>
											<a href="#" class="image"><img src="images/pic06.jpg" alt="" /></a>
											<h3>Amet varius aliquam</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
									</div>
									
									<div id="cheat_posts" class="posts" style="display:none;">
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.6rem; font-weight:bold;">서울/경기</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;20901</span>
											</div>
											<a href="#" class="image"><img src="images/pic01.jpg" alt="" /></a>
											<h3>Interdum aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.6rem; font-weight:bold;">서울/경기</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;18902</span>
											</div>
											<a href="#" class="image"><img src="images/pic02.jpg" alt="" /></a>
											<h3>Nulla amet dolore</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.6rem; font-weight:bold;">강원도</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;16239</span>
											</div>
											<a href="#" class="image"><img src="images/pic03.jpg" alt="" /></a>
											<h3>Tempus ullamcorper</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.6rem; font-weight:bold;">충청도</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;13289</span>
											</div>
											<a href="#" class="image"><img src="images/pic04.jpg" alt="" /></a>
											<h3>Sed etiam facilis</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.6rem; font-weight:bold;">전라도</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;11092</span>
											</div>
											<a href="#" class="image"><img src="images/pic05.jpg" alt="" /></a>
											<h3>Feugiat lorem aenean</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
										<article>
											<div style="margin-bottom:20px; display:flex; justify-content:space-between; align-items:flex-end;">
												<span style="color:black; font-size:1.6rem; font-weight:bold;">경상도</span>
												<span class="icon fa-gem" style="color:#ffaec9; font-size:1rem; padding-bottom:5px;">&nbsp;9999</span>
											</div>
											<a href="#" class="image"><img src="images/pic06.jpg" alt="" /></a>
											<h3>Amet varius aliquam</h3>
											<p>Aenean ornare velit lacus, ac varius enim lorem ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed nulla amet lorem feugiat tempus aliquam.</p>
										</article>
									</div>
								</section>
							
						</div>
					</div>
					<div id="sidebar" class="off">
						<c:import url="/app/footer/footer_index.jsp" />
					</div>
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
				var windowWidth = $( window ).width();
				console.log(windowWidth);
				
				$(document).ready(function () {
					var exampleEl = $("#example1"),
						navigationEl;
	
					navigationEl = $('<ul/>')
						.insertAfter(exampleEl);
					
					if(windowWidth > 1450){
					exampleEl
						.zAccordion({
							auto: true,  //Disable the (automatic) slideshow
							timeout:3000,
							slideWidth: 750,
							width: 1200,
							height: 500
						});
					}else{
						exampleEl
						.zAccordion({
							auto: true,  //Disable the (automatic) slideshow
							timeout:3000,
							slideWidth: 500,
							width: 750,
							height: 320
						});
					}
				});
		</script>
	</body>
</html>