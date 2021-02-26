<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인</title>
</head>
<body>
	<%
		String userid = null;
		if(session.getAttribute("userid") != null) {
			//로그인 성공했다는 의미임
			userid = (String)session.getAttribute("userid");
	%>
	<p><%=userid %>님 환영합니다.</p>
	<p><a href="logout.jsp">[로그아웃]</a></p>
	<% 		
		}else {
			//세션이 비어있으므로 처음 실행하면 여기로 들어온다.! 그래서 form태그로 들어오게된다. 
	%>
	<form action = "login_ok.jsp" method="post" name = "loginForm">
		<p><label>아이디 : <input type="text" name ="userid"></label></p>
		<p><label>비밀번호 : <input type="password" name ="pwd"></label></p>
		<p><input type="button" value ="로그인" onclick="sendIt()"></p>
	</form>
	<%
		}
	%>
</body>
<script>
	var frm = document.loginForm;
	
	function sendIt () {
		if(frm.userid.value == "") {
			alert("아이디를 입력해주세요.");
			frm.userid.focus();
			return false;
		}
		
		if(frm.pwd.value == "") {
			alert("비밀번호를를 입력해주세요.");
			frm.pwd.focus();
			return false;
		}
		
		frm.submit();
	}
</script>
</html>