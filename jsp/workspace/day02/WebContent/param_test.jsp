<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!-- 데이터를 전달하는 곳에서 인코딩 설정을 해준다. -->
<%request.setCharacterEncoding("UTF-8"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>param 액션 태그</title>
</head>
<body>
	<h3>param 액션 태그</h3>
	<hr>
	<!-- 
	param은 컴파일을 통해 서블릿으로 변하는 과정에서
	get방식인 쿼리 스트링으로 각 요소가 URL에 붙는다. 
	따라서 param뒤 혹은 forward안에 주석을 작성하면
	쿼리 스트링에 붙어버린다.
	되도록 forward태그 밖에 주석을 작성해준다. 	
	 -->
	<jsp:forward page="paramP.jsp">
		<jsp:param value="admin" name="id"/>
		<jsp:param value="관리자" name="name"/>
	</jsp:forward>
</body>
</html>