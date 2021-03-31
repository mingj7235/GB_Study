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
    	<link href="//maxcdn.bootstrapcdn.com/font-awesome/4.1.0/css/font-awesome.min.css" rel="stylesheet">
		<link href='https://fonts.googleapis.com/css?family=Anton' rel='stylesheet' type='text/css'>
		<link href='https://fonts.googleapis.com/css?family=Neucha' rel='stylesheet' type='text/css'>
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
			}
			.detail_div_frame {
				width: 70%;
				height: 400px;
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
			
			.thumbnail_images {
				width:216px;
			}
			
			/* 슬라이드 css */
			*{margin:0; padding:0; list-style:none;}
			a{text-decoration:none; color:#666;}
			a:hover{color:#1bc1a3;}
			body, hmtl{background: #ecf0f1; font-family: 'Anton', sans-serif;}
			
			
			#slide-wrapper{
			  width:100%;
			  height:200px;
			  position:relative;
			  color:#fff;
			  text-shadow:rgba(0,0,0,0.1) 2px 2px 0px;  
			}
			
			#slider-wrap{
			  width:100%;
			  height:200px;
			  position:relative;
			  overflow:hidden;
			}
			
			#slider-wrap ul#slider{
			  width:2000px;
			  height:100%;
			  
			  position:absolute;
			  top:0;
			  left:0;   
			}
			
			#slider-wrap ul#slider li{
			  float:left;
			  position:relative;
			}
			
			#slider-wrap ul#slider li > div{
			  position:absolute;
			  top:20px;
			  left:35px;  
			}
			
			#slider-wrap ul#slider li > div h3{
			  font-size:36px;
			  text-transform:uppercase; 
			}
			
			#slider-wrap ul#slider li > div span{
			  font-family: Neucha, Arial, sans serif;
			  font-size:21px;
			}
			
			#slider-wrap ul#slider li img{
			  display:block;
			  width:100%;
			  height: 100%;
			}
			
			
			/*btns*/
			.btns{
			  position:absolute;
			  width:50px;
			  height:60px;
			  top:50%;
			  margin-top:-25px;
			  line-height:57px;
			  text-align:center;
			  cursor:pointer; 
			  background:rgba(0,0,0,0.1);
			  z-index:100;
			  
			  
			  -webkit-user-select: none;  
			  -moz-user-select: none; 
			  -khtml-user-select: none; 
			  -ms-user-select: none;
			  
			  -webkit-transition: all 0.1s ease;
			  -moz-transition: all 0.1s ease;
			  -o-transition: all 0.1s ease;
			  -ms-transition: all 0.1s ease;
			  transition: all 0.1s ease;
			}
			
			.btns:hover{
			  background:rgba(0,0,0,0.3); 
			}
			
			#next{right:-50px; border-radius:7px 0px 0px 7px;}
			#previous{left:-50px; border-radius:0px 7px 7px 7px;}
			#counter{
			  top: 30px; 
			  right:35px; 
			  width:auto;
			  position:absolute;
			}
			
			#slider-wrap.active #next{right:0px;}
			#slider-wrap.active #previous{left:0px;}
			
			
			/*bar*/
			#pagination-wrap{
			  min-width:20px;
			  margin-top: 170px;
			  margin-left: auto; 
			  margin-right: auto;
			  height:15px;
			  position:relative;
			  text-align:center;
			}
			
			#pagination-wrap ul {
			  width:100%;
			}
			
			#pagination-wrap ul li{
			  margin: 0 4px;
			  display: inline-block;
			  width:5px;
			  height:5px;
			  border-radius:50%;
			  background:#fff;
			  opacity:0.5;
			  position:relative;
			  top:0;
			  
			  
			}
			
			#pagination-wrap ul li.active{
			  width:12px;
			  height:12px;
			  top:3px;
			  opacity:1;
			  box-shadow:rgba(0,0,0,0.1) 1px 1px 0px; 
			}

			/*Header*/
			h1, h2{text-shadow:none; text-align:center;}
			h1{ color: #666; text-transform:uppercase;  font-size:36px;}
			h2{ color: #7f8c8d; font-family: Neucha, Arial, sans serif; font-size:18px; margin-bottom:30px;} 
			
			/*ANIMATION*/
			#slider-wrap ul, #pagination-wrap ul li{
			  -webkit-transition: all 0.3s cubic-bezier(1,.01,.32,1);
			  -moz-transition: all 0.3s cubic-bezier(1,.01,.32,1);
			  -o-transition: all 0.3s cubic-bezier(1,.01,.32,1);
			  -ms-transition: all 0.3s cubic-bezier(1,.01,.32,1);
			  transition: all 0.3s cubic-bezier(1,.01,.32,1); 
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
											<div id="slide-wrapper">
										      <div id="slider-wrap">
										          <ul id="slider">
										             <li>
										             <a href="https://www.youtube.com/watch?v=t70t-sklypk">
										<img class="thumbnail_images" src="https://i.ytimg.com/vi/2Uv1B3kjCOI/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCjHUx-YwnUHULAZzAw77daLoVvzg">
										             </a>
										             </li>
										             
										             <li>
										<img class="thumbnail_images" src="https://i.ytimg.com/vi/M-tD4VhczYA/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLDSHofPUtcjxJLnWqYTe8dXYiZATg">
										             </li>
										             
										             <li>
										                <div>
										                    <h3>Slide #3</h3>
										                    <span>Sub-title #3</span>
										                </div>
										<img class="thumbnail_images" src="https://i.ytimg.com/vi/M0qtCqwVskU/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCMDnQFfLq2L9NErhWcaBqOPDjudA">
										             </li>
										             
										             <li>
										                <div>
										                    <h3>Slide #4</h3>
										                    <span>Sub-title #4</span>
										                </div>
										<img class="thumbnail_images" src="https://i.ytimg.com/vi/UYHfk45Yi2c/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLCha0vWRbibrVG6R70YFcJOv7hC6Q">
										             </li>
										             
										             <li>
										                <div>
										                    <h3>Slide #5</h3>
										                    <span>Sub-title #5</span>
										                </div>
										<img class="thumbnail_images" src="https://i.ytimg.com/vi/t70t-sklypk/hqdefault.jpg?sqp=-oaymwEcCNACELwBSFXyq4qpAw4IARUAAIhCGAFwAcABBg==&rs=AOn4CLAdeJlLhQ_T-yBCNrbldHBjg3lTAA">
										             </li>
										             
										             
										          </ul>
										          
										           <!--controls-->
										          <div class="btns" id="next"><i class="fa fa-arrow-right"></i></div>
										          <div class="btns" id="previous"><i class="fa fa-arrow-left"></i></div>
										          <div id="counter"></div>
										          
										          <div id="pagination-wrap">
										            <ul>
										            </ul>
										          </div>
										          <!--controls-->  
										                 
										      </div>
										  
										   </div>
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
			//current position
			var pos = 0;
			//number of slides
			var totalSlides = $('#slider-wrap ul li').length;
			//get the slide width
			var sliderWidth = $('.thumbnail_images').width();


			$(document).ready(function(){
			  
			  
			  /*****************
			   BUILD THE SLIDER
			  *****************/
			  //set width to be 'x' times the number of slides
			  $('#slider-wrap ul#slider').width(2000);
			  
			    //next slide  
			  $('#next').click(function(){
			    slideRight();
			  });
			  
			  //previous slide
			  $('#previous').click(function(){
			    slideLeft();
			  });
			  
			  
			  
			  /*************************
			   //*> OPTIONAL SETTINGS
			  ************************/
			  //automatic slider
			  var autoSlider = setInterval(slideRight, 3000);
			  
			  //for each slide 
			  $.each($('#slider-wrap ul li'), function() { 

			     //create a pagination
			     var li = document.createElement('li');
			     $('#pagination-wrap ul').append(li);    
			  });
			  
			  //counter
			  countSlides();
			  
			  //pagination
			  pagination();
			  
			  //hide/show controls/btns when hover
			  //pause automatic slide when hover
			  $('#slider-wrap').hover(
			    function(){ $(this).addClass('active'); clearInterval(autoSlider); }, 
			    function(){ $(this).removeClass('active'); autoSlider = setInterval(slideRight, 3000); }
			  );
			  
			  

			});//DOCUMENT READY
			  


			/***********
			 SLIDE LEFT
			************/
			function slideLeft(){
			  pos--;
			  if(pos==-1){ pos = totalSlides-1; }
			  $('#slider-wrap ul#slider').css('left', -(sliderWidth*pos));  
			  
			  //*> optional
			  countSlides();
			  pagination();
			}


			/************
			 SLIDE RIGHT
			*************/
			function slideRight(){
			  pos++;
			  if(pos==totalSlides){ pos = 0; }
			  $('#slider-wrap ul#slider').css('left', -(sliderWidth*pos)); 
			  
			  //*> optional 
			  countSlides();
			  pagination();
			}



			  
			/************************
			 //*> OPTIONAL SETTINGS
			************************/
			function countSlides(){
			  $('#counter').html(pos+1 + ' / ' + totalSlides);
			}

			function pagination(){
			  $('#pagination-wrap ul li').removeClass('active');
			  $('#pagination-wrap ul li:eq('+pos+')').addClass('active');
			}
				
		</script>
	</body>
</html>