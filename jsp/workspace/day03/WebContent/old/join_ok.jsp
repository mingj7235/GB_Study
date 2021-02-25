<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean class="com.koreait.beans.TABLE_MEMBER_VO" id="member"/>
    <jsp:useBean class="com.koreait.beans.TABLE_MEMBER_DAO" id="dao"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결과</title>
</head>
<body>
<!-- DB에서 조회 -->
<!-- out.print를 사용하여 조회 결과 출력 -->
	
	<%
	//중복인지 아닌지를 join.jsp로 전달해준다. 
	
	response.sendRedirect("join.jsp?check="+dao.checkId(request.getParameter("id")));
	/* get방식이므로 이렇게 보낼수있다. ?가 url있는걸 쿼리스트링이라고한다. */
	
/* 	if(dao.checkId(request.getParameter("id"))) {
		out.print("아이디가 중복입니다.");
	} else {
		out.print("사용가능한 아이디입니다.");
	} */
	%>	
	
</body>
</html>