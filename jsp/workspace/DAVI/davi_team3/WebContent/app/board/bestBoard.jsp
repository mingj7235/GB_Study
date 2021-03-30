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
<title>bestBoard</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link
	href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap"
	rel="stylesheet">
<link
	href="https://fonts.googleapis.com/css2?family=Black+Han+Sans&display=swap"
	rel="stylesheet">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.15.3/css/all.css"
	integrity="sha384-SZXxX4whJ79/gErwcOYf+zWLeJdY/qpuqC4cAa9rOGUstPomtqpuNWT9wdPEn2fk"
	crossorigin="anonymous">
<style>
a.image {
	 position: relative; 
	 width: 100%;
	 height: 0; 
	 padding-bottom: 100%;
}

span.ranking {
	color: black; 
	font-size: 1.6rem; 
	font-weight: bold;
}
#dia {
	color: #ffaec9; 
	font-size: 0.95rem; 
	padding-bottom: 5px;
}

body {
	font-family: 'Sunflower', sans-serif;
}

.title {
	font-size: 3rem;
	font-family: 'Cute Font', cursive;
	color: #ffaec9;
	margin-bottom: 3%;
}

h1, h2, h3, h4 {
	font-family: 'Sunflower', sans-serif;
}

.report {
	margin-bottom: 10px;
	color: #ffaec9;
	font-weight: bold;
}

.report span {
	color: black;
	margin-left: 5px;
	font-weight: 100;
}

.graph {
	width: 80%;
}

.graph__description {
	display: flex;
	justify-content: space-between;
	margin-bottom: 10px;
}

.graph__bar {
	height: 3px;
	background-color: #D3D3D3;
	margin-bottom: 15px;
}

.graph__value {
	width: 100%;
	height: 3px;
	background-color: #ffaec9;
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

				<!-- Section -->
				<div
					style="display: flex; flex-direction: column; align-items: center;">
					<div style="margin: 4% 0;">
						<h2 align="center">베스트 게시판</h2>
					</div>
				</div>
				<section style="padding-top: 60px; width: 70%; margin: auto;"">

					<div id="best_posts" class="posts">
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">1st</span>
								<span class="icon fa-gem" id="dia">&nbsp;20901</span>
							</div>
							<div>
								<a href="#" class="image">
								<img
									src="${pageContext.request.contextPath}/images/비서.jpg"
									alt=""
									style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							</div>
							<h3>나 너무 다이어트 잘해</h3>
							<p>진짜 잘하네</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">2nd</span>
								<span class="icon fa-gem" id="dia">&nbsp;18902</span>
							</div>
							<a href="#" class="image">
								<img
								src="${pageContext.request.contextPath}/images/pic.gif" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" />
							</a>
							<h3>gif</h3>
							<p>gif 테스트</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">3rd</span>
								<span class="icon fa-gem" id="dia">&nbsp;16239</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/logo_1.png" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>베스트 글</h3>
							<p>베스트 글이에요~</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">4th</span>
								<span class="icon fa-gem" id="dia">&nbsp;13289</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>다이어트 최고</h3>
							<p>살이 넘 잘 빠져~</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">5th</span>
								<span class="icon fa-gem" id="dia">&nbsp;11092</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>Feugiat lorem aenean</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">6th</span>
								<span class="icon fa-gem" id="dia">&nbsp;9999</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>Amet varius aliquam</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">7th</span>
								<span class="icon fa-gem" id="dia">&nbsp;8816</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>Amet varius aliquam</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">8th</span>
								<span class="icon fa-gem" id="dia">&nbsp;8711</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>Amet varius aliquam</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">9th</span>
								<span class="icon fa-gem" id="dia">&nbsp;7621</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>Amet varius aliquam</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">10th</span>
								<span class="icon fa-gem" id="dia">&nbsp;5741</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>Amet varius aliquam</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">11th</span>
								<span class="icon fa-gem" id="dia">&nbsp;3742</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>Amet varius aliquam</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
						</article>
						<article>
							<div
								style="margin-bottom: 20px; display: flex; justify-content: space-between; align-items: flex-end;">
								<span class="ranking">12th</span>
								<span class="icon fa-gem" id="dia">&nbsp;756</span>
							</div>
							<a href="#" class="image"><img
								src="${pageContext.request.contextPath}/images/비서.jpg" alt=""
								style="display: inline-block; width: 100%; height: 100%; position: absolute; top: 0; left: 0;" /></a>
							<h3>Amet varius aliquam</h3>
							<p>Aenean ornare velit lacus, ac varius enim lorem
								ullamcorper dolore. Proin aliquam facilisis ante interdum. Sed
								nulla amet lorem feugiat tempus aliquam.</p>
						</article>
					</div>
				</section>

			</div>
		</div>

		<!-- Sidebar -->
		<c:import url="/app/footer/footer.jsp" />
	</div>

	<!-- Scripts -->
	<script
		src="${pageContext.request.contextPath}/assets/js/jquery.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/browser.min.js"></script>
	<script
		src="${pageContext.request.contextPath}/assets/js/breakpoints.min.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/util.js"></script>
	<script src="${pageContext.request.contextPath}/assets/js/main.js"></script>

</body>
</html>