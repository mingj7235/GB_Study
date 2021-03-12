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
      <c:if test="${session_id eq null}">
         <script>
            alert("로그인 후 이용해주세요");
            location.replace("${pageContext.request.contextPath}/member/MemberLogin.me");
         </script>
      </c:if>
      
      <!-- JSTL로 BoardListOkAction을 통해 전달된 데이터 받기 -->
      <c:set var ="list" value ="${boardList}"/>
      <c:set var ="totalCnt" value ="${totalCnt}"/>
      <c:set var ="startPage" value ="${startPage}"/>
      <c:set var ="endPage" value ="${endPage}"/>
      <c:set var ="nowPage" value ="${nowPage}"/>
      
      <center>
         <table border="0" cellpadding="0" cellspacing="0" width="900px" >
            <tr align="right" valign="middle">
               <td>
                  ${session_id} 님 환영합니다.
                  <a href="">로그아웃</a>
               </td>
            </tr>
         </table>
         <br />
         <br />
         
         <!-- 게시판 리스트 -->
         <table width="900px" border="0" cellpadding="0" cellspacing="0">
            <tr align="center" valign="middle">
               <td><h3>MVC 게시판</h3></td>
            </tr>
            <tr align="right" valign="middle">
 				<!-- jstl로 가져온 값을 그대로 꽂아넣기 -->           
               <td>글 개수 : <c:out value="${totalCnt}"/> 개</td>
            </tr>
         </table>
         
         <table border="1" cellpadding="0" cellspacing="0" width="900px" >
            <tr align="center" valign="middle">
               <td width="8%" height="26">
                  <div align="center">번호</div>
               </td>
               <td width="50%">
                  <div align="center">제목</div>
               </td>
               <td width="14%">
                  <div align="center">작성자</div>
               </td>
               <td width="17%">
                  <div align="center">날짜</div>
               </td>
               <td width="11%">
                  <div align="center">조회수</div>
               </td>
            </tr>
            <c:choose>
            <c:when test="">
	            <c:forEach>
	            </c:forEach>
            
            </c:when>
            <c:otherwise>
            
            </c:otherwise>
            </c:choose>
            
         </table>
         <br/>
         <table border="0" cellpadding="0" cellspacing="0" width="900px">
            <tr align="right" valign="middle">
               <td><a href="">[글쓰기]</a></td>
            </tr>
         </table>
      </center>
   </body>
</html>