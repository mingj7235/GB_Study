<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%request.setCharacterEncoding("UTF-8"); %>
    <jsp:useBean class="com.koreait.beans.TABLE_MEMBER_VO" id="m_vo"/>
    <jsp:useBean class="com.koreait.beans.TABLE_MEMBER_DAO" id="m_dao"/>
    <!-- 반드시 파라미터의 KEY(name)값과 해당 객체의 필드명이 일치해야 정확한 값이 들어간다. 위의id와 아래의 name !! 이렇게해야 매핑이된다.-->
    <jsp:setProperty property="*" name="m_vo" />
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
</head>
<body>
	<%
		String url = "";
		
		if(m_dao.join(m_vo)) {
			
			url = "join_finish.jsp?name=" +URLEncoder.encode(m_vo.getName(), "UTF-8");
									/* response를 사용할때는 인코딩을해줘야 한글이 깨지지 않는다.  */
		} else {
			url = "join.jsp?check=false";
		}
		//전송하기
		response.sendRedirect(url);
	%>
</body>
</html>