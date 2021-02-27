<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class ="com.koreait.beans.TABLE_MEMBER_DAO" id="dao"/>

<% 
	if(dao.checkId(request.getParameter("id"))) {
		out.print("not-ok");
	}else {
		out.print("ok");
	}
%>