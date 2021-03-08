<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean class = "com.koreait.beans.TABLE_MEMBER_VO" id="vo"/>
<jsp:useBean class = "com.koreait.beans.TABLE_MEMBER_DAO" id="dao"/>
<jsp:setProperty property="*" name="vo"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String url = "";
	if(dao.join(vo)) {
		url = "signup_finish.jsp?name="+URLEncoder.encode(vo.getNameMember(), "UTF-8");
	} else {
		url = "Signup.html?check=false";
	}
	response.sendRedirect(url);

%>


</body>
</html>