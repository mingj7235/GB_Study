<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<form action ="join_ok.jsp" name ="joinForm">
		아이디 : <input type="text" name = "id">
		<input type="button" value ="완료" onclick="sendIt()">
	</form>
</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
	function sendIt(){
		if($("input[name='id']").val() =="") {
			alert("아이디를 입력해주세요.");
			return false;
		}
		document.joinForm.submit();
	}
</script>
</html>