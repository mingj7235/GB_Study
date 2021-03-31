<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE HTML>
<html>
	<head>
		<title>자유게시판글쓰기</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<!-- 써머노트를 사용하기위해 css파일링크 -->
		<link rel="stylesheet" href="${pageContext.request.contextPath}/app/board/summernote/summernote-lite.css">
		
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
									<h2 align="center">글쓰기</h2>
									<div style="width:60%; margin: 0 auto; font-size: 1em;">
										<form method="post" action="#" name="freeBoardWriteForm">
											<div>
												<label for="subject">주제</label>
												<select name="bulletinHead" id="bulletinHead" style="width: 20%;">
													<option value="0">잡담</option>
													<option value="1">고민상담</option>
													<option value="2">팁/노하우</option>
												</select>										
											</div>
											<div style="margin: 10px 0px; width: 80%;">
												<label for="subject">제목</label>
												<input type="text" id="subject" name="bulletinTitle">
											</div>
											<div>
												<!-- 써머노트  폼 불러오기 -->
												<textarea id="summernote" name="bulletinContent"></textarea>
											</div>
											<div style="margin: 10px 0px; text-align: right;">
											<a href="javascript:freeBoardWriteForm.submit()"  style="margin-right: 15px;">글 올리기</a>
											<a href="javascript:textReset()">내용 초기화</a>											
											<!-- <input type="submit" value="글 올리기" style="margin-right: 10px;">
											<input type="button" value="내용 초기화" onclick="textReset();"> -->
											</div>									
											
										</form>
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
			<!-- 써머노트를 사용하기위한 기본 js -->
			<script src="${pageContext.request.contextPath}/app/board/summernote/summernote-lite.js"></script>
			<script src="${pageContext.request.contextPath}/app/board/summernote/lang/summernote-ko-KR.js"></script>
			<!-- 써머노트 로딩과 설정변경 파일 js -->
			<script src="${pageContext.request.contextPath}/app/board/summernote/summernoteBasic.js"></script>
			<script src="${pageContext.request.contextPath}/app/board/summernote/summernoteAdd.js"></script>
			<script>
			$(document).ready(function () {
				summernoteStart();				
			});	
			</script>
			
	</body>
</html>