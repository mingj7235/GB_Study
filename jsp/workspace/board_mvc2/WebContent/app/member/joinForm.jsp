<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>회원가입 페이지</title>
   </head>
   <body>
      <form name="joinForm" action="${pageContext.request.contextPath}/member/MemberJoinOk.me" method="post">
         <center>
            <table  border="1" cellpadding="0" cellspacing="0" width="25%">
               <tr height="50px">
                  <td colspan="2" align=center>
                     <b><font size=5>회원가입 페이지</font></b>
                  </td>
               </tr>
               
              
               <tr height="40px">
                  <td align="center" width="100px">아이디</td>
                  <td><input type="text" name="memberId" style="width:280px;" />
                  <p id="idCheck_text"></p>
                  </td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">비밀번호</td>
                  <td><input type="password" name="memberPw" style="width:280px;" /></td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">이름</td>
                  <td><input type="text" name="memberName" style="width:280px;" /></td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">나이</td>
                  <td><input type="text" name="memberAge" style="width:50px; margin-left:5px;" />살</td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">성별</td>
                  <td>
                     <input type="radio" name="memberGender" value="남" checked/>남자
                     <input type="radio" name="memberGender" value="여"/>여자
                  </td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">이메일</td>
                  <td><input type="text" name="memberEmail" style="width:280px;" /></td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">우편번호</td>
                  <td>
                  <input type="text" name="memberZipcode" class="postcodify_postcode5" value="" readonly/>
                  <input type="button" id="postcodify_search_button" value="검색"><br />
                  </td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">주소</td>
                  <td>
                     <input type="text" name="memberAddress" class="postcodify_address" value="" style="width:280px;" readonly/><br />
                  </td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">상세주소</td>
                  <td>
                     <input type="text" name="memberAddressDetail" class="postcodify_details" value="" style="width:280px;" /><br />
                  </td>
               </tr>
               <tr height="40px">
                  <td align="center" width="100px">참고항목</td>
                  <td>
                     <input type="text" name="memberAddressEtc" class="postcodify_extra_info" value="" style="width:280px;" readonly /><br />
                  </td>
               </tr>
               <tr height="40px">
                  <td colspan="2" align="center">
                     <a href="javascript:formSubmit()">회원가입</a>&nbsp;&nbsp;
                     <a href="javascript:joinForm.reset()">다시작성</a>&nbsp;&nbsp;
                     <a href="${pageContext.request.contextPath}/member/MemberLogin.me">로그인</a>
                  </td>
               </tr>
            </table>
         </center>
      </form>
   </body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script>var contextPath = "${pageContext.request.contextPath}";</script>
<script src="${pageContext.request.contextPath}/app/member/join.js"></script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
</html>







