<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
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
		<center>
			<c:if test="${session_id eq null}">
				<script>
					alert("로그인 후 이용해주세요");
					location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
				</script>
			</c:if>
			<table border="0" cellpadding="0" cellspacing="0" width="900px" >
				<tr align="right" valign="middle">
					<td>
						${session_id} 님 환영합니다.
						<a href="${pageContext.request.contextPath}/member/MemberLogout.me">로그아웃</a>
					</td>
				</tr>
			</table>
			<br />
			<br />
			<form action="${pageContext.request.contextPath}/board/BoardModifyOk.bo" method="post" name="modifyForm" enctype="multipart/form-data">
				<input type="hidden" name="boardNum" value="${b_vo.getBoardNum()}">
				<input type="hidden" name="page" value="${page}">
				<table width="900px" border="0" cellpadding="0" cellspacing="0">
					<tr align="center" valign="middle">
						<td><h3>MVC 게시판</h3></td>
					</tr>
				</table>
				
				<table width="900px" border="1" cellpadding="0" cellspacing="0">
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">제 목</div>
						</td>
						<td style="padding-left:10px;">
							<input name="boardTitle" type="text" size="50" maxlength="100" value="${b_vo.getBoardTitle()}" />
						</td>
					</tr>
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">글쓴이</div>
						</td>
						<td style="padding-left:10px;">
							<input name="boardId" type="text" size="10" maxlength="10" value="${b_vo.getBoardId()}" readonly/>
						</td>
					</tr>
					<tr height="200px">
						<td align="center" width="150px">
							<div align="center">내 용</div>
						</td>
						<td style="padding-left:10px;">
							<textarea name="boardContent" style="width:700px; height:185px; resize:none;">${b_vo.getBoardContent()}</textarea>
						</td>
					</tr>
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">파일 첨부</div>
						</td>
						<td style="padding-left:10px;">
							<input type="file" name="boardFile1">
							<input type="button" onclick="cancleFile('boardFile1')" value="첨부 삭제">
						</td>
					</tr>
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">파일 첨부</div>
						</td>
						<td style="padding-left:10px;">
							<input type="file" name="boardFile2">
							<input type="button" onclick="cancleFile('boardFile2')" value="첨부 삭제">
						</td>
					</tr>
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">파일 첨부</div>
						</td>
						<td style="padding-left:10px;">
							<input type="file" name="boardFile3">
							<input type="button" onclick="cancleFile('boardFile3')" value="첨부 삭제">
						</td>
					</tr>
				</table>
				
				<table border="0" cellpadding="0" cellspacing="0" width="900px">
					<tr align="right" valign="middle">
						<td>
							<a href="javascript:modifyBoard()">[수정]</a>&nbsp;&nbsp;
							<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${page}">[목록]</a>&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</form>
		</center>
	</body>
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.js"></script>
	<script>
		function modifyBoard(){
			modifyForm.submit();
		}
		function cancleFile(fileTagName){
			if($.browser.msie){//ie일 때
				//첨부파일 업로드 전의 태그를 복사해 놓고, 초기화 시 복사된 태그를 덮어 씌워준다.
				$("input[name='" + fileTagName + "']").replaceWith($("input[name='" + fileTagName + "']").clone(true));
			}else{//그 외 브라우저
				$("input[name='" + fileTagName + "']").val("");
			}
		}
	</script>
</html>










