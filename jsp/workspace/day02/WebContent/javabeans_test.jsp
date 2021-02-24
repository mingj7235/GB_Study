<%@page import="java.util.ArrayList"%>
<%@page import="com.koreait.beans.MemberDAO"%>
<%@page import="com.koreait.beans.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<jsp:useBean class="com.koreait.beans.MemberVO" id="member"/>
<jsp:useBean class="com.koreait.beans.MemberDAO" id="dao"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자바빈즈 예제</title>
</head>
<body>
   <jsp:setProperty property="name" name="member" value="김민재"/>
   <jsp:setProperty property="birthday" name="member" value="01-13"/> <!-- html 주석은 컴파일은 되지만, 표현만안되는것이다!!! 컴파일은되는것. -->

	<!-- HTML 주석은 컴파일을 막지않고 보여지는 부분만 주석처리해준다. -->
	<%-- JSP주석은 컴파일도 주석처리된다. --%>

   <jsp:getProperty property="name" name="member"/>
   <jsp:getProperty property="birthday" name="member"/>
   
   <table>
   <%ArrayList<MemberVO> members = dao.select("김송이"); %>
   <%for(int i = 0; i<members.size(); i++) { %>
   	<tr>
   		<td><%= members.get(i).getName()%></td>
   		<td><%= members.get(i).getBirthday()%></td>
   	</tr>
   <%} %> 
   </table>
</body>
</html>