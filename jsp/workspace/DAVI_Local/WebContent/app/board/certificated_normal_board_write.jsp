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
		<title>인증게시판</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
		<link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.3/css/all.min.css">
		<style>
			body{
					font-family: 'Sunflower', sans-serif;
				}
				
			h1, h2, h3, h4, h5, h6 {
					font-family: 'Sunflower', sans-serif;
				}
				
			.board_basic {
					border : 1px solid black; 
			
				}
				
			input[type="text"], 
			input[type="text"]:focus{
				border:0;
				border-bottom: solid 1px #ffaec9;
				border-radius:0;
				box-shadow: none;
			}
			
			.profile {
				border-radius: 40%;
			}
			
			.board_main_box {
			
			}
			
		</style>
		
	</head>
	<body class="is-preload">

		<!-- Wrapper -->
			<div id="wrapper">

				<!-- Main -->
					<div id="main">
						<div class="inner">

				
				<!-- body -->
				<div style="display: flex; justify-content: center;">
					<div style="width:60%; height: 850px;"> 
						<!-- 일반게시판 글쓰기 아웃라인 -->
						<div style="height: 10%; margin-top: 30px; border: 1px solid #F0E2D9;">
							<div style="display:flex; justify-content: center;">
								<img id="" name="" class="profile" src="${pageContext.request.contextPath}/images/logo_3.png" alt="" style=" margin:5px; width: 35px; height: 35px;
									cursor: pointer;" onclick="#"/>
								<textarea id="" name="" placeholder="게시글을 작성해보세요" style="border:0; border-bottom: 1px solid #ffaec9; 
									resize:none; height:40px; padding: 5px; margin: 5px;" readonly="readonly" onclick="popup()"></textarea>
								<input id="" name="" type="button" value="등록" style="margin:5px;">
							</div>
								<!-- 사진 업로드 -->
							<div style="display:flex; justify-content: center;">
								<a href="#" style="display:flex; justify-content: center; width:30%; border-bottom: none; color:#ffaec9;">
									<div style="margin: 1px;">
										<i class="fas fa-images"></i>
									</div>
									<div style="color:#9FA3A6; margin-left: 3px;">사진 첨부하기</div>
								</a>
							</div>
						</div>
					
							
						</div><!-- end 일반게시판 게시물 div박스-->
						
					</div>
						
				</div>
				
				<!-- board body end -->

				</div>
			</div>
			</div>

		<!-- Scripts -->
			<script>var contextPath = "${pageContext.request.contextPath}";</script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
			<script>
				
			
			</script>

	</body>
</html>