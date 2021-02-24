<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET 방식의 요청</title>
</head>
<body>
	<h1>GET방식의 요청</h1>
	<%
		String city = request.getParameter("city");	
		String zipcode = request.getParameter("zipcode");
		
		if (city == null || zipcode == null) {
			response.sendRedirect("post_test.jsp");
		}else {
	%>
	<form action = "get_test.jsp" method = "get"> <!-- action을 생략하면 현재페이지, method를 생략하면 디폴트가 get 즉 지금 다 생략해도되지만, 명시적 -->
		<input type = "text" name = "city" value ="Seoul" readonly>
		<input type = "text" name = "zipcode" value = "65532" readonly>
		<button type ="submit">GET방식으로 요청 보내기!</button>
	</form>
	<p><%=city %>, <%=zipcode %></p>
	<%} %>
</body>
</html>