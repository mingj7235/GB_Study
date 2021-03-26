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
		<title>회원가입</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
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
				
				<!-- body -->
				<div style="display: flex; justify-content: center;">
					<div style="width:70%;"> 
						<!-- 일반게시판 글쓰기 아웃라인 -->
						<div style="height: 80px; border: 1px solid green; margin-top: 30px">
						
						</div>
					
						<!-- 일반게시판 전체 아웃라인 -->
						<div style="height: 1000px; border: 1px solid red; margin-top: 10px; margin-bottom: 50px;">
							<!-- 작성자 -->
							<div class="board_basic" style="display : flex; justify-content: center; height: 50px;">
								<div style="border: solid 1px blue; width: 20%;" >profile photo</div>
								<div style="border: solid 1px blue; width: 60%;">user name</div>
								<div style="border: solid 1px blue; width: 20%;">ellipsis</div>
								
							</div>
							
							<!-- 게시판 제목 -->
							<div class="board_basic" style="height: 30px;">
							title
							</div>
							
							<!-- 사진 -->
							<div class="board_basic" style="position:relative; width:100%; height: 0; padding-bottom:100%; border:solid 1px red;">
								<img src="#" style="display:inline-block; width:100%; height:100%; position:absolute; top:0; left:0; background-color:rgba(0,0,0,.7);">
							</div>
							
							<!-- 아이콘들 (좋아요, 댓글등) -->
							<div class="board_basic" style="height: 50px">
							icons
							</div>
							
							<!-- 좋아요 숫자  -->
							<div class="board_basic" style="height: 30px">
							like
							</div>
							
							<!-- 본문  -->					
							<div class="board_basic" style="display : flex; justify-content: flex-start; height: 30px">
								<div style="border: solid 1px blue; width: 20%;">user name</div>
								<div style="border: solid 1px blue; width: 60%;">contents</div>
								<div style="border: solid 1px blue; width: 20%;">ellipsis</div>
							</div>
							
							<!-- 댓글 -->
							
							<%--  
							<c:if test="">
								<c:forEach>
							
							--%>
									<div class="board_basic" style="display : flex; justify-content: flex-start; height: 30px">
										<div style="border: solid 1px blue; width: 20%;">user name</div>
										<div style="border: solid 1px blue; width: 70%;">comments</div>
										<div style="border: solid 1px blue; width: 10%;">icon</div>
									</div>

							<%--  
							</c:forEach>
								</c:if>
							
							--%>
							
							<!-- 댓글 입력 칸 -->
							
							
						
						</div>
					</div>
					
				</div>






				</div>
			</div>
				<!-- Sidebar -->
				<c:import url="/app/footer/footer.jsp" />		
			</div>

		<!-- Scripts -->
			<script>var contextPath = "${pageContext.request.contextPath}";</script>
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
			<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
			<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>

	</body>
</html>