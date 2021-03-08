<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class = "com.koreait.beans.TABLE_MEMBER_DAO" id="dao"></jsp:useBean>

<% 
	if(dao.checkId(request.getParameter("id"))) {
		out.println("not-ok");
	}else {
		out.println("ok");
	}


%>