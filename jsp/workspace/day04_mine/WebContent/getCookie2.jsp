<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠키 출력, 쿠키 삭제</title>
</head>
<body>
<%
   String cookie = request.getHeader("Cookie");
   String id = null;
   
   if(cookie != null){
      Cookie[] cookies = request.getCookies();
      for(Cookie c : cookies){
         if(c.getName().equals("id")){
            id = c.getValue();
            break;
         }
      }
%>

   <p>아이디 : <%=id %></p>
   
<%
      for(Cookie c : cookies){
         c.setMaxAge(0);
         response.addCookie(c);
      }
   }
%>
   <a href="delete_check.jsp">쿠키 삭제 확인</a>

</body>
</html>