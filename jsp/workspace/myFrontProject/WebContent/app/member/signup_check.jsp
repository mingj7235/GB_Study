<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class = "com.koreait.app.member.dao.MemberDAO" id="dao"></jsp:useBean>

<% 
	if(dao.checkId(request.getParameter("id"))) {
		out.println("not-ok");
	}else {
		out.println("ok");
	}


%>