<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta>
		<title>MVC 게시판</title>
	</head>
	
	<body>
		<center>
			<table border="0" cellpadding="0" cellspacing="0" width="900px" >
				<tr align="right" valign="middle">
					<td>
						${session_id} 님 환영합니다.
						<a href="${pageContext.request.contextPath}/member/MemberLogOut.me">로그아웃</a>
						<%-- <a href="${pageContext.request.contextPath}/member/MemberList.me">회원 리스트보기</a> --%>
					</td>
				</tr>
			</table>
			<br />
			<br />
			
			<!-- 게시판 등록 -->
			<form action="${pageContext.request.contextPath}/board/BoardWriteOk.bo" method="post" name="boardform" enctype="multipart/form-data">
				<table width="900px" border="0" cellpadding="0" cellspacing="0">
					<tr align="center" valign="middle">
						<td><h3>MVC 게시판</h3></td>
					</tr>
				</table>
			
				<table  border="1" cellpadding="0" cellspacing="0" width="900px" >
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">제 목</div>
						</td>
						<td style="padding-left:10px;">
							<input name="boardTitle" type="text" size="50" maxlength="100" value=""/>
						</td>
					</tr>
					<tr height="30px">
						<td align="center" width="150px">
							<div align="center">글쓴이</div>
						</td>
						<td style="padding-left:10px;">
							<input name="boardId" type="text" size="10" maxlength="10" value="${session_id}" readonly />
						</td>
					</tr>
					<tr height="200px">
						<td align="center" width="150px">
							<div align="center">내 용</div>
						</td>
						<td style="padding-left:10px;">
							<textarea name="boardContent" style="width:700px; height:185px"></textarea>
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
							<a href="javascript:addBoard()">[등록]</a>&nbsp;&nbsp;
							<!-- 
								외부에서 전달된 파라미터의 종류 
								1. request객체에 setAttribute()
									requestScope에 등록된다
									사용 예) ${key}, ${requestScope.key}
									
								2. 쿼리 스트링으로 파라미터 전달
									사용 예) ${param.key}
							-->
							<a href="${pageContext.request.contextPath}/board/BoardList.bo?page=${page}">[목록]</a>&nbsp;&nbsp;
						</td>
					</tr>
				</table>
			</form>
			<!-- 게시판 등록 -->
		</center>
	</body>
	<!--
		migrate 1.2.1 버전 사용 시 반드시 jquery 3.5.1버전 적용 후 사용해야 한다.
	-->
	<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
	<script src="//code.jquery.com/jquery-migrate-1.2.1.js"></script>
	<script>
		function addBoard(){
			boardform.submit();
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











