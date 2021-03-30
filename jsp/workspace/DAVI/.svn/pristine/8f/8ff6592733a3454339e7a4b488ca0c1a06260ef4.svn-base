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
		<title>마이 페이지</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
		<link rel="preconnect" href="https://fonts.gstatic.com">
		<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
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
					

							<!-- Content -->
								<section style="padding-top:3%;">
										<div style="display: flex; justify-content: center;">
											<p class="title">마이 페이지 </p>
										</div>
										<div style="text-align: center;">
											<hr style="width: 30%; margin: 1% auto;">
											<div>
												<input type="button" value="내 정보 수정" class="primary" style="width:30%; margin:1% auto;" onclick="popupUpdate()">
											</div>
											<div>
												<input type="button" value="비밀번호 변경 " class="primary" style="width:30%; margin:1% auto;" onclick="popupChangePw()">
											</div>
											<hr style="width: 30%; margin: 1% auto;">
											
										</div>
								</section>

						</div>
					</div>

				<!-- Sidebar -->
					<c:import url="/app/footer/footer.jsp" />

			</div>

		<!-- Scripts -->
			<script src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
			<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>
			<script>
			function popupUpdate() {
				var width = '700';
			    var height = '800';
			    var left = Math.ceil(( window.screen.width - width )/2);
			    var top = Math.ceil(( window.screen.height - height )/2); 
			    window.open('${pageContext.request.contextPath}/app/member/mypage_updateStatus.jsp', '게시물 작성', 'width='+ width +', height='+ height +', left=' + left + ', top='+ top );
			}
			
			function popupChangePw () {
				var width = '700';
			    var height = '600';
			    var left = Math.ceil(( window.screen.width - width )/2);
			    var top = Math.ceil(( window.screen.height - height )/2); 
			    window.open('${pageContext.request.contextPath}/app/member/mypage_changePw_popup.jsp', '게시물 작성', 'width='+ width +', height='+ height +', left=' + left + ', top='+ top );
			}
			
			</script>

	</body>
</html>