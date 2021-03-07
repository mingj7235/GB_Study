<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta>
      <title>로그인 페이지</title>
   </head>
   <body>
   
   <!-- get방식으로 받아온 check에 false가 들어있으면 alert창 띄우기 -->
   <c:if test="${param.check == 'false'}">
		<script>alert('ID/PW를 확인해주세요.')</script>
   </c:if>
   	
   									<!-- login.js에서 submit()이 실행되면 절대경로/경로.me를 서블릿이 web.xml로 가져가서 확인함 -->
      <form name="loginForm" action="${pageContext.request.contextPath}/member/MemberLogin.me" method="post">
         <center>
            <table border="1" cellpadding="0" cellspacing="0" width="400px">
               <tr height="50px">
                  <td colspan="2" align=center>
                     <b><font size=5>로그인 페이지</font></b>
                  </td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">아이디</td>
                  <td align="center"><input type="text" name="memberId" style="width:280px;" /></td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">비밀번호</td>
                  <td align="center"><input type="password" name="memberPw" style="width:280px;" /></td>
               </tr>
               <tr height="30px">
                  <td colspan="2" align=center>
                     <a href="javascript:login()">로그인</a>&nbsp;&nbsp;
                     <a href="joinForm.jsp">회원가입</a>
                  </td>
               </tr>
            </table>
         </center>
      </form>
   </body>
   <script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<!-- 절대경로를 js에서 사용하기 위한 편법 -->
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<script src="${pageContext.request.contextPath}/app/member/login.js"></script>
</html>