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
		<title>게시물 작성 </title>
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
			
			.board_content:focus {
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
				<div style="display: flex; justify-content: center; margin:10px 0; padding-top: 5px;">
					<h1>게시물 만들기</h1>
				</div>
				<form action="#">
					<div style="display: flex; justify-content: center;">
						<div style="width: 80%; height: 420px; border: 1px solid #F0E2D9;">
							<!-- 게시글 작성자 프로필, 닉네임, 제목 -->
							<div style="display : flex; justify-content: center; height: 40px;">
								<div style="width:10%;">
								<img id="" name="" class="profile" src="${pageContext.request.contextPath}/images/logo_3.png" alt="" style="margin:5px; width: 35px; height: 35px;
									cursor: pointer;" onclick="#"/> <!-- 프로필 사진 클릭시 해당 계정으로 이동 -->
								</div>
								<div id="" style="width:10%; padding-top: 10px; margin-left: 5px;">(#)</div>
								<div style="width:80%; text-align: right; padding-top: 10px; padding-right: 10px; color:#ffaec9;">
									<i class="fas fa-ellipsis-h" onclick="#" style="cursor: pointer;"></i>
								</div>	
							</div>

							<!-- 게시글 제 -->
							<div style="display:flex; justify-content: center;">
								<textarea class="board_content" id="" name="" placeholder="게시글 제목" style="border:0; border-bottom: 1px solid #ffaec9; 
									resize:none; height:40px; padding: 5px; margin: 5px;"></textarea>
							</div>
						
							<!-- 게시글 본문 -->
							<div style="display:flex; justify-content: center;">
								<textarea class="board_content" id="" name="" placeholder="게시글을 작성해보세요 :)" style="border:0; border-bottom: 1px solid #ffaec9; 
									resize:none; height:250px; padding: 5px; margin: 5px;"></textarea>
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
							<div style="display:flex; justify-content: center;">
								<input id="" name="" type="button" value="미리보기" style="box-shadow: none; font-size: 1em;" onclick="preview()">
								<input id="" name="" type="submit" value="인증하기" style="box-shadow: none; font-size: 1em;" onclick="">
							</div>
						</div>
							
					</div><!-- end 일반게시판 게시물 div박스-->
				</form>
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
			function preview() {
				var width = '500';
			    var height = '700';
			    var left = Math.ceil(( window.screen.width - width )/2);
			    var top = Math.ceil(( window.screen.height - height )/2); 
			    window.open('${pageContext.request.contextPath}/app/board/certificated_normal_board_preview.jsp', '미리보기', 'width='+ width +', height='+ height +', left=' + left + ', top='+ top );
				
			}
			
			</script>

	</body>
</html>