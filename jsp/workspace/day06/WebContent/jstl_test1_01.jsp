<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TEST(변수)</title>
</head>
<body>
	<h2>JSTL TEST(변수)</h2>
	<c:set var="name" value="홍길동" scope="page"/> <!-- 변수명 name 변수값 홍길동 스코프 현재페이지 -->
	<c:out value="${name}"/>
	<br> \${name} ===> &dollar;${name} <!-- ${name} ===> $홍길동     이렇게 출력됨 -->
	
	<hr>
	<c:set var="nation" scope="session">한국</c:set>  <!-- 이렇게 태그 사이에 value를 넣을수도있다.  -->
	<%-- <c:remove var="nation" scope="session"/> --%> <!-- 사라지게할 변수의 var와 scope를 맞춰줘야한다. -->
	
	nation 삭제 후 값은 >> [<c:out value="${nation}" default="국가정보없음"/>] >> 변수값이 삭제됨 <!-- default는 value가 없을때 기본으로 나오게만들어줌 (c:out의 기능) -->
	
	<br>
	<c:set var="data1" value="10"/>
	<c:set var="data2" value="${20}"/>
	<c:set var="data3">30.5</c:set>
	
	총합은 ${data1 + data2 + data3} <!-- EL문 안에서 이렇게 연산이 가능하다. -->
	
	
</body>
</html>