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

							<!-- Header -->
				
				<!-- body -->
				<div style="display: flex; justify-content: center;">
					<article style="width:80%; margin-bottom: 60px;"> 
						<!-- 일반게시판 전체 아웃라인 -->
						<div style="margin-top: 50px; padding-bottom:30px; border: 1px solid #f0e2d9;">
							<!-- 작성자 -->
							<div style="display : flex; justify-content: center; height: 30px;">
								<div style="width:10%;">
								<img id="" name="" class="profile" src="${pageContext.request.contextPath}/images/logo_3.png" alt="" style="margin:5px; width: 35px; height: 35px;
									cursor: pointer;" onclick="#"/> <!-- 프로필 사진 클릭시 해당 계정으로 이동 -->
								</div>
								<div id="" style="width:10%; padding-top: 10px; margin-left: 5px;">(#)</div>
								<div style="width:80%; text-align: right; padding-top: 10px; padding-right: 10px; color:#ffaec9;">
									<i class="fas fa-ellipsis-h" onclick="#" style="cursor: pointer;"></i>
								
								</div>
							</div>
							
							<!-- 게시판 제목 -->
							<div style="height: 30px; padding-top: 5px; margin:5px;">
								<p3>글 제목</p3>
							</div>
							
							<!-- 사진 -->
							<div style="position:relative; width:100%; height: 0; padding-bottom:100%; ">
								<img src="${pageContext.request.contextPath}/images/logo_3.png" style="display:inline-block; width:100%; height:100%; position:absolute; top:0; left:0; ">
							</div>
							
							<!-- 아이콘들 (다이아몬드, 댓글아이콘등) -->
							<div style="display : flex; justify-content: flex-start; height: 35px; padding: 5px;">
								<div style="font-size: 0.9rem; padding-top: 2px;">
									<i class="far fa-gem fa-lg" style="cursor: pointer; color : #ffaec9" onclick="changeDiamond()"></i>
									<i class="" style="display: none;"></i>
								</div>
								<div style="font-size: 0.95rem;">
									<i class="far fa-comment fa-lg" style="cursor: pointer; color : #ffaec9; margin-left: 9px;" onclick="#"></i>
								</div>
							</div>
							 
							<!-- 좋아요 숫자  -->
							<div style="display : flex; justify-content: flex-start; height: 30px; padding: 5px;">
								<div>좋아요</div>
								<div id="diamond_num" style="color: #ffaec9;">#</div>
								<div>개</div>
							</div>
							
							<!-- 본문  -->					
							<div style="display : flex; justify-content: flex-start; height: 30px; padding: 5px;">
								<div id="" style="width: 20%;">글쓴이 </div>
								<div id="" style="width: 70%;">본문내용</div>
								<textarea rows="" cols="" style="display: none;">본문내용</textarea>
								<div id="" style="width: 10%; text-align: right; margin: 0 5px;">
									<i class="far fa-plus-square" onclick="#" style="cursor: pointer; color: #ffaec9;"></i>
								</div>
							</div>
							
							
						</div><!-- end 일반게시판 게시물 div박스-->
						
					</article>
						
				</div>
				
				<!-- board body end -->

				</div>
			</div>
				<!-- Sidebar -->
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