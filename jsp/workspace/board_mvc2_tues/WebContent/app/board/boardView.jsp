<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>MVC 게시판</title>
	</head>
	<body>
		<c:set var="b_vo" value="${b_vo}"/>
		<c:set var="replies" value="${replies}"/>
		<c:set var="files" value="${files}"/>
		<center>
		<c:choose>
			<c:when test="${session_id eq null}">
			<script>
				alert("로그인 후 이용해주세요");
				location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
			</script>
			</c:when>
			<c:otherwise>
			<table border="0" cellpadding="0" cellspacing="0" width="900px" >
				<tr align="right" valign="middle">
					<td>
						${session_id} 님 환영합니다.
						<a href="${pageContext.request.contextPath}/member/MemberLogout.me">로그아웃</a>
					</td>
				</tr>
			</table>
			</c:otherwise>
			</c:choose>
			<br />
			<br />
		
			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="center" valign="middle">
					<td><h3>MVC 게시판</h3></td>
				</tr>
			</table>
				
			<table width="900px" border="1" cellpadding="0" cellspacing="0">
				<tr height="30px">
					<td align="center" width="150px">제 목</td>
					<td style="padding-left:10px;">${b_vo.getBoardTitle()}</td>
				</tr>
				
				<tr height="30px">
					<td  align="center" width="150px">아이디</td>
					<td style="padding-left:10px;">${b_vo.getBoardId()}</td>
				</tr>
				
				<tr height="200px">
					<td align="center" width="150px">내 용</td>
					<td valign="top" style="padding-top:10px; padding-left:10px;">${b_vo.getBoardContent()}</td>
				</tr>
				
				<c:if test="${files != null}">
					<tr height="30px">
						<td align="center">첨부파일</td>
						<td>
							<c:forEach var="file" items="${files}">
								<a href="${pageContext.request.contextPath}/board/FileDownload.bo?fileName=${file.getFileName()}">${file.getFileName()}</a>
							</c:forEach>
						</td>
					</tr>
				</c:if>
			</table>
			<table width="900px" border="0" cellpadding="0" cellspacing="0">
				<tr align="right" valign="middle">
					<td>
						<c:if test="${b_vo.getBoardId() eq session_id}">
							<a href="${pageContext.request.contextPath}/board/BoardModify.bo?boardNum=${b_vo.getBoardNum()}&page=${page}">[수정]</a>
							<a href="javascript:deleteBoard()">[삭제]</a>
						</c:if>
						<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${page}">[목록]</a>
					</td>
				</tr>
			</table>
			<form name="deleteBoard" method="post" action="${pageContext.request.contextPath}/board/BoardDeleteOk.bo">
				<input type="hidden" name="boardNum" value="${b_vo.getBoardNum()}">
				<input type="hidden" name="page" value="${page}">
			</form>
			
			<!-- 댓글  -->
			<form action="${pageContext.request.contextPath}/board/BoardReplyOk.bo" method="post" name="boardReply">
				<input type="hidden" name="boardNum" value="${b_vo.getBoardNum()}">
				<input type="hidden" name="page" value="${page}">
				<table>
					<tr height="200px">
						<td align="center" width="80px">
							<div align="center">댓 글</div>
						</td>
						<!-- 댓글 추가 -->
						<td style="padding-left: 10px;">
							<textarea name="replyContent" style="width:750px; height:85px; resize:none;"></textarea>
							<a href="javascript:insertReply()">[등록]</a>
						</td>
					</tr>
					<!-- 댓글 목록 -->
					<c:choose>
						<c:when test="${replies != null and fn:length(replies) > 0 }">
							<c:forEach var="reply" items="${replies}">
								<tr>
									<td align="center" width="150px">${replies.getMemberId()}</td>
									<td valign="top" style="padding-left:10px;">
										<textarea class="re" style="width:750px; height:85px; resize:none;" readonly>${reply.getReplyContent()}</textarea>
										<c:if test="${session_id eq reply.getMemberId()}">
											<a>[수정]</a>
											<a style="display:none;">[수정 완료]</a> 
											<a>[삭제]</a>
										</c:if>
									</td>
								</tr>
							</c:forEach>
						</c:when>
						<c:otherwise>
							<tr align="center">
								<td align="center" width="150px;">댓글이 없습니다.</td>
							</tr>
						</c:otherwise>
					</c:choose>
				</table>
			</form>
		</center>
	</body>
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="https://rawgit.com/jackmoore/autosize/master/dist/autosize.min.js"></script> 
	<script>
		autosize($("textarea.re"));
		function deleteBoard(){
			//만약 이미 사용중인 객체명을 사용하고 싶다면(form태그 name)
			//1. name을 다른 이름으로 수정해준다.
			//2. DOM으로 가져온다.
			document.getElementsByName("deleteBoard")[0].submit();
		}
		
		function insertReply(){
			if($("textarea[name='replyContent']").val() =="") {
				alert("댓글을 작성해주세요");
				return false;
			}	
			boardReply.submit();
		}
	</script>
</html>









