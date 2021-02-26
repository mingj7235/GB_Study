<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <<jsp:useBean class = "com.koreait.beans.TABLE_MEMBER_DAO" id="m_dao"></jsp:useBean>
    <%
    //파라미터로 login에서 날라온다. 이걸 받자! 
    	String userid = request.getParameter("userid");
    	String pwd = request.getParameter("pwd");
    %>
<%
	if(m_dao.login(userid, pwd)) {
		//로그인 성공
		session.setAttribute("userid", userid); //세션에 추가할때 키값과 밸류값으로 setattribute로 저장한다.
		response.sendRedirect("login.jsp");
	}else {
		//로그인 실패
		   %>
		   <script>
		      alert("로그인 실패");
		      location.href="login.jsp";
		   </script>
		<%}%>


