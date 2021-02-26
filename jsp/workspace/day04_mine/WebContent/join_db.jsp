<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean class="com.koreait.beans.TABLE_MEMBER_VO" id="user"/>
    <jsp:useBean class="com.koreait.beans.TABLE_MEMBER_DAO" id="dao"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
	if(dao.join(user)) {
		//true : 회원가입 정상적
		
	}else {
		//false : 가입 안됬을 경우 
	}
	
	%>
</body>
</html>