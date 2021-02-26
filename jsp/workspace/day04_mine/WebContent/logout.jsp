<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	session.invalidate(); //전체 삭제
	//session.removeAttribute("userid"); //특정 session만 삭제
%>

<script>
	location.href = "login.jsp";
</script>