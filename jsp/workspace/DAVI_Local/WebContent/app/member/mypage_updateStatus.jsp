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
		<title>내 정보 수정</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap" rel="stylesheet">
		<link href="https://fonts.googleapis.com/css2?family=Cute+Font&display=swap" rel="stylesheet">
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
			
			.join-unit{
				display: flex;
				justify-content: center;
				margin-bottom:40px;
				
			}
			
			input[type="text"], input[type="text"]:focus,
			input[type="password"], input[type="password"]:focus,
			input[type="email"], input[type="email"]:focus,
			textarea, textarea:focus{
				border:0 !important;
				border-bottom: solid 1px #ffaec9 !important;
				border-radius:0;
				box-shadow: none;
			}
			
			.fas{
				font-size:1.3rem;
			}
			
			::placeholder {
				font-size:1.1em;
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
							
								
							<!-- Content -->
							<div style="display:flex; flex-direction:column; align-items:center;">
								<div style="margin:5% 0;">
									<p class="title">내 정보 수정</p>
								</div>
								<hr style="width:45%; border-bottom: solid 3px #ffaec9; margin-top:0; margin-bottom:4%;">
								<form method="post" action="#" style="width:45%;">
									
									<div class="join-unit">
										<div class="join-unit_input" style="width:80%;">
											<input type="text" name="memberId" id="memberId" placeholder="닉네임"/>
										</div>
									</div>
									
									<div class="join-unit">
										<div class="join-unit_input" style="width:80%;">
											<input type="email" name="memberId" id="memberId" placeholder="이메일 주소"/>
										</div>
									</div>
									
									<div class="join-unit">
										<div class="join-unit_input" style="width:80%;">
											<input type="text" name="memberId" id="memberId" placeholder="휴대폰 번호"/>
										</div>
									</div>
									
									<div class="join-unit">
										<div class="join-unit_input" style="width:80%;">
											<input type="text" name="memberId" id="memberId" placeholder="신장 (165)"/>
										</div>
									</div>
									
									<div class="join-unit">
										<div class="join-unit_input" style="width:80%;">
											<input type="text" name="memberId" id="memberId" placeholder="체중 (50)"/>
										</div>
									</div>
									
									<div class="join-unit">
										<div class="join-unit_input" style="width:80%;">
											<textarea rows="" cols="" style="resize: none;" placeholder="각오"></textarea>
											<!-- <input type="text" name="memberId" id="memberId" placeholder="각오"/> -->
										</div>
									</div>
									
									<div class="join-unit">
										<div class="join-unit_input" style="width:80%;">
											<textarea rows="" cols="" style="resize: none;" placeholder="목표"></textarea>
											<!-- <input type="text" name="memberId" id="memberId" placeholder="목표"/> -->
										</div>
									</div>
									
									<hr style="width:100%; border-bottom: solid 3px #ffaec9; margin-top:10%; margin-bottom:8%;">
									
									<div class="btns">
										<div class="col-12">
											<ul class="actions" style="width:100%; display:flex; justify-content:center;">
												<li><input type="submit" value="변경하기" class="primary" style="width:150px;" /></li>
												<li><input type="button" value="취소" style="width:150px;"onclick="winClose()"/></li>
											</ul>
										</div>
									</div>
									
								</form>
							</div>		

						</div>
					</div>

				<!-- Sidebar -->

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			<script>
				function winClose() {
					 window.open('','_self').close();
				}
			</script>

	</body>
</html>