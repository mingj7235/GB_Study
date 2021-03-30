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
<title>recipeDetails</title>
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

ol,ul,li{
	font-family: 'Sunflower', sans-serif;
	font-size:1.0rem;
	color:black;
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
						<!-- <h2 align="center">레시피</h2> -->
					</div>
				</div>
				
				<div style="width:50%; float:left; padding-left:10%;">
					<h3 style="color: #ffb642;">
					RECIPE:
					</h3>
					<h2 style="color:#ff5a00;">
					두부김치볶음밥
					</h2>
					<h3 style="color: #ffb642;">
					칼로리 : 310kcal
					</h3>
					<h3 style="margin-bottom:10%;">
					효능 : 두부는 리놀산을 함유하고 있어 콜레스테롤을 낮춰주고 올리고당이 많아 장의 움직임을 활성화하며, 소화 흡수를 돕는 효능을 가지고 있습니다.
					</h3>
					
					<div style="width:50%; float:left;">
					<h3>재료</h3>
					<ul style="list-style-type:square; font-size:1.3rem;">
						<li>두부(1/2모)</li>
						<li>김치(적당량)</li>
						<li>달걀(2개)</li>
						<li>밥(1공기)</li>
						<li>통깨</li>
						<li>참기름</li>
						<li>간장 또는 소금</li>
					</ul>
					</div>
					<div style="width:50%;float:left;">
					<h3>
					조리법
					</h3>
					<ol style="font-size:1.3rem;">
						<li> 두부를 으깨고 전자레인지에 2분 돌립니다(두부 수분 제거).</li>
						<li> 전자레인지에 돌린 두부를 꺼내 나온 물을 버립니다.</li>
						<li> 김치를 적당한 크기로 썰어줍니다.</li>
						<li> 프라이팬에 식용유를 두르지 않은 채로 두부를 넣고 볶아줍니다.</li>
						<li> 살짝 볶은 후 소금이나 간장으로 간을 합니다.</li>
						<li> 썰어 놓은 김치를 넣고 함께 볶아줍니다.</li>
						<li> 밥 한 공기를 팬에 함께 넣어줍니다.</li>
						<li> 통깨, 참기름을 넣어 함께 볶아줍니다.</li>
					</ol>
					
					
					
					
					 
					
					
					
					
					</div>
				</div>
				<div style="width:50%;float:left;padding-left:5%;">
					<img alt="" src="img/tofu_kimchi.png" style="max-width:100%; height:auto;">
				</div>
				
				





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