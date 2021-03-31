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
		<title>자유게시판뷰</title>
		<meta charset="utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
		<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />		
		<link rel="stylesheet" href="${pageContext.request.contextPath}/app/board/summernote/summernote-lite.css">
	</head>
	<style>
		.replyArti{
			border-top: 1px solid #ffaec9;
		}	
		
		.replycontent{
			resize: none;
			border: none;
		}
		
		.replyLevel-0{
			margin-left: 0px;
		}	
		.replyLevel-1{
			margin-left: 15px;
		}	
		.replyLevel-2{
			margin-left: 30px;
		}	
		.replyLevel-3{
			margin-left: 45px;
		}
		
	</style>
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
									<h2 align="center">상세보기</h2>										
									<div style="width:60%; margin: 0 auto; font-size: 1em;">
										<form method="post" action="#" name="freeBoardViewForm">
											<div>
												<label for="bulletinHead">주제</label>
												<select name="bulletinHead" id="bulletinHead" style="width: 20%;" disabled>
													<option value="0">잡담</option>
													<option value="1">고민상담</option>
													<option value="2">팁/노하우</option>
												</select>										
											</div>
											<div style="margin: 10px 0px; width: 80%;">
												<label for="subject">제목</label>												
												<input type="text" id="subject" name="bulletinTitle" readonly>	
											</div>
											<div>
												<!-- 써머노트  폼 불러오기 -->
												<textarea id="summernote" name="bulletinContent"></textarea>
											</div>
											<div class="row" style="margin-top:5px;">
												<div class="col-4">
													<i class="far fa-gem fa-lg" style="cursor: pointer; color : #ffaec9" onclick="changeDiamond()"></i>
													<i class="" style="display: none;"></i>													
												</div>											
												<div class="col-8" style="margin: 10px 0px; text-align: right;">													
												<a href="javascript:enable()" style="margin-right: 10px;">수정하기</a>								
												<a href="#">글 삭제</a>													
												<a href="javascript:freeBoardViewForm.submit()">수정완료</a>
												</div>									
											</div>
											<c:set var="replyNumber" value="1" />
											<c:set var="replyLevel" value="1" />
											<!-- 반복문으로 댓글 뿌리기 -->
											<c:forEach var="replyArr" items="">
												<article class="replyArti">
													<div class="row">
														<div  class="col-10">	
															<div>															
																<textarea name="readReply" class="replycontent" readonly>
	첫번째 댓글
	내용내용
																</textarea>
															</div>																						
														</div>											
														<div class="col-2" style="margin-top:15px;">														
															<a href="#" >수정하기</a><br>
															<a href="#" >삭제하기</a><br>
															
															<a href="javascript:replyAnswer(${replyNumber}, ${replyLevel})" >답변하기</a><br>
														</div>												
													</div>
													<article id="replyAnswer${replyNumber}" class="replyArti" style="display: none;">
														<h5 id="replyLevel${replyNumber}" style="margin-top:20px;">댓글 작성</h5>	
														<div class="row" style="margin-top:5px">
															<div class="col-10">
																<div id="replyLevel${replyNumber}">
																	<textarea name="writeReply" class="replycontent" placeholder="이곳에 입력하세요"></textarea>
																</div>
															</div>
															<div class="col-2" style="margin-top:30px;">
																<c:if test="${true}">
																	<a href="#" >입력하기</a>
																</c:if>											
															</div>											
														</div>										
													</article>
												</article>
											</c:forEach>
											<!-- 여기까지 1번째댓글 -->	
											<article class="replyArti">
												<div class="row">
													<div  class="col-10 commentBox">
														<div style="margin-left: 15px;">
															<textarea name="readReply" class="replycontent" readonly>
첫번째 댓글에 댓글
내용용
내용용
내용용내용용내용용내용용내용용내용용내용용내용용내용용내용용내용용내용용내용용
내용용
내용용
내용용
내용용
내용용
내용용
내용용
															</textarea>														
														</div>																						
													</div>											
													<div class="col-2" style="margin-top:20px;">
														
														<a href="#" >수정하기</a><br>
														<a href="#" >삭제하기</a><br>
														<a href="javascript:replyAnswer(${replyNumber+1}, ${replyLevel+1})" >답변하기</a><br>
													</div>												
												</div>
												<article id="replyAnswer${replyNumber+1}" class="replyArti" style="display: none;">
													<h5 id="replyLevel${replyNumber+1}" style="margin-top:20px">댓글 작성</h5>	
													<div class="row" style="margin-top:5px">
														<div class="col-10">
															<div id="replyLevel${replyNumber + 1}">
																<textarea name="writeReply" class="replycontent" placeholder="이곳에 입력하세요"></textarea>
															</div>
														</div>
														<div class="col-2" style="margin-top:30px;">
															<c:if test="${true}">
																<a href="#" >입력하기</a>
															</c:if>											
														</div>											
													</div>										
												</article>
											</article>													
											<article class="replyArti">
												<h5 style="margin-top:20px">댓글 작성</h5>	
												<div class="row" style="margin-top:5px">
													<div class="col-10">
														<textarea name="writeReply" class="replycontent" placeholder="이곳에 입력하세요"></textarea>
													</div>
													<div class="col-2" style="margin-top:30px;">
														<c:if test="${true}">
															<a href="javascript:replyOk(${bulletinNum})" >입력하기</a>
														</c:if>											
													</div>											
												</div>										
											</article>
																														
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
								
			<script src="${pageContext.request.contextPath}/app/board/js/replyBoard.js"></script>	
			
			<!-- textarea 자동 높이 조절 -->				
			<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script>					
				
			<script>
			
			autosize($("textarea"));
			$(document).ready(function () {
			summernoteView();			
			writeDisable();			
			insertContent('글내용~~~~~');	
			
			});		
			
			function enable() {		
				$('#summernote').summernote('destroy');
				summernoteStart();
				$('select').val("1").prop("selected", true);				
				document.getElementById('subject').readOnly = false;
				writeAble();
			}
			function disable() {
				document.getElementById('subject').readOnly = true;				
				writeAble();
			}
			
			var diamondCheck = true;
			
			function changeDiamond() {
				if(!diamondCheck) {
					document.
					/* display를 none으로 변경하고 다른 icon을 가져와서(채워져있는 다이아몬드 ) */
					diamondCheck = true;
					
				}
					
			}
			</script>	
	</body>
</html>