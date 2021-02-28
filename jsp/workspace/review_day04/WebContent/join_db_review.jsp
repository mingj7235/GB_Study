<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8"); %>
<jsp:useBean id="vo" class="com.koreait.beans.TABLE_MEMBER_VO"/>
<jsp:useBean id="dao" class="com.koreait.beans.TABLE_MEMBER_DAO"/>
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
	if(dao.join(vo)){
		url = "join_finish_review.jsp?name="+URLEncoder.encode(vo.getName(),"UTF-8");
	}else {
		url = "join_review?check=false";
	}
	response.sendRedirect(url);
%>

</body>
</html> 