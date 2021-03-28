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
								<c:import url="/app/header/header.jsp" />
				
				<!-- body -->
				<div style="display: flex; justify-content: center;">
					<div style="width:70%;"> 
						<!-- 일반게시판 글쓰기 아웃라인 -->
						<div style="height: 80px; margin-top: 30px; border: 1px solid #F0E2D9;">
							<div style="display:flex; justify-content: center;">
								<img id="" name="" class="profile" src="${pageContext.request.contextPath}/images/logo_3.png" alt="" style=" margin:5px; width: 35px; height: 35px;
									cursor: pointer;" onclick="#"/>
								<textarea id="" name="" placeholder="게시글을 작성해보세요" style="border:0; border-bottom: 1px solid #ffaec9; resize:none; height:40px; padding: 5px; margin: 5px;"></textarea>
								<input id="" name="" type="button" value="등록" style="margin:5px;">
							</div>
								<!-- 사진 업로드 -->
							<div style="display:flex; justify-content: center;">
								<a href="#" style="display:flex; justify-content: center; width:30%; border-bottom: none; color:#ffaec9;">
									<div style="margin: 1px;"><i class="fas fa-images"></i></div>
									<div style="color:#9FA3A6; margin-left: 3px;">사진 첨부하기</div>
								</a>
							</div>
						</div>
					
						<!-- 일반게시판 전체 아웃라인 -->
						<div style="height: 85%; margin-top: 20px; margin-bottom: 50px; border: 1px solid #f0e2d9;">
							<!-- 작성자 -->
							<div style="display : flex; justify-content: center; height: 30px;">
								<div style="width:10%;">
								<img id="" name="" class="profile" src="${pageContext.request.contextPath}/images/logo_3.png" alt="" style="margin:5px; width: 35px; height: 35px;
									cursor: pointer;" onclick="#"/> <!-- 프로필 사진 클릭시 해당 계정으로 이동 -->
								</div>
								<span id="" style="width:10%; padding-top: 10px;">(#)</span>
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
								<img src="${pageContext.request.contextPath}/images/logo_3.png" style="display:inline-block; width:100%; height:100%; position:absolute; top:0; left:0; background-color:rgba(255,174,201);">
							</div>
							
							<!-- 아이콘들 (다이아몬드, 댓글아이콘등) -->
							<div style="display : flex; justify-content: flex-start; height: 35px; padding: 5px;">
								<div style="font-size: 0.9rem; padding-top: 2px;">
									<i class="far fa-gem fa-lg" style="cursor: pointer; color : #ffaec9" onclick="#"></i>
									<%-- <img src="${pageContext.request.contextPath}/images/mini_logo.png" onclick="#" style="cursor: pointer;"> --%>
								</div>
								<div style="font-size: 0.95rem;">
									<!-- comment input must fill it -->
									<i class="far fa-comment fa-lg" style="cursor: pointer; color : #ffaec9; margin-left: 9px;" onclick="#"></i>
								</div>
							</div>
							 
							<!-- 좋아요 숫자  -->
							<div style="display : flex; justify-content: flex-start; height: 30px; padding: 5px;">
								<div>좋아요</div>
								<div id="diamond_num">#</div>
								<div>개</div>
							</div>
							
							<!-- 본문  -->					
							<div style="display : flex; justify-content: flex-start; height: 30px; padding: 5px;">
								<div id="" style="width: 20%;">글쓴이 </div>
								<div id="" style="width: 70%;">본문내용</div>
								<textarea rows="" cols="" style="display: none;">본문내용</textarea>
								<div id="" style="width: 10%; text-align: right; margin: 0 5px;">
									<i class="far fa-plus-square" onclick="#" style="cursor: pointer;"></i>
								</div>
							</div>
							
							<!-- 댓글 -->
							
							<%--  
							<c:if test="">
								<c:forEach>
							
							--%>
									<div style="display : flex; justify-content: flex-start; height: 30px; padding: 5px;">
										<div style="width: 20%;">댓글쓴이</div>
										<div style="width: 70%;">댓글</div>
										<input type="button" value="게시" style="box-shadow: none; width: 10%; margin: 0 5px; color: rgba(var(--d69,0,149,246),0.3) !important;">
									</div>

							<%--  
							</c:forEach>
								</c:if>
							
							--%>
							
							<!-- 댓글 입력 칸 -->
							
							<div style="display : flex; justify-content: flex-start; height: 30px; padding: 5px;">
								<div style="width: 20%; padding-top: 5px;">접속아이디 </div>
								<input type="text" placeholder="댓글을 작성해주세요" style="width:70%; border:0; border-bottom: 1px solid #ffaec9;"/>
								<input type="button" value="등록" style="width:10%; margin: 0 5px; box-shadow: none; color: rgba(var(--d69,0,149,246),0.3) !important">
							</div>
							
						</div><!-- end 일반게시판 게시물 div박스-->
						
					</div>
						
				</div>
				
				<!-- board body end -->

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
			<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
			<script>
				var check = false;
			
			</script>

	</body>
</html>