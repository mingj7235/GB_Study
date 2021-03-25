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
		<title>ID찾기</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
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
								<section>								
									<a href="#" style="text-align: center; display: block;" onfocus="this.blur()" >
                        				<img src="${pageContext.request.contextPath}/images/logo_2.png"/>
									</a>									
								
										<form method="post" action="#">
											<div class="row gtr-uniform" style="text-align:center;">
												<div class="col-12">															
													<input type="text" name="memberName" id="memberName"  placeholder="이름을 입력하세요" style="width:49%; margin:30px auto;" />															
													<input type="password" name="memberEmail" id="memberEmail" placeholder="EMAIL을 입력하세요" style="width:49%; margin:10px auto;"/>
												</div>

												<!-- button -->
												<div class="col-12">															
												<input type="submit" value="ID 찾기" class="primary" style="width:49%;">
												<hr style="background-color: #ffaec9; height: 2px;">												
												</div>												
											</div>
										</form>	
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

	</body>
</html>