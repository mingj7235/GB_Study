<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <jsp:useBean class="com.koreait.beans.TABLE_MEMBER_DAO" id="dao"/>


<%
//응답할 데이터만 나올 수 있도록 불필요한 태그들 모두 삭제해준다.
//TABLE_MEMBER_DAO에 있는 checkId()함수의 리턴 값에 따라서
//true 라면 "중복된 아이디" body에 출력
//false라면 "사용가능한 아이디" body에 출력

if(dao.checkId(request.getParameter("id"))) {
	out.print("not-ok");
}else {
	out.print("ok");
}

%>
