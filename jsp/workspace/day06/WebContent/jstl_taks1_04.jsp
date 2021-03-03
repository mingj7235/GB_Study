<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL TASK1</title>
</head>
<body>
<!-- 
	사용자에게 이름을 입력받고 확인버튼을 눌렀을 때
	admin일 경우 "관리자", member일 경우 "일반 회원", 그 외에는 "비회원(전달받은 이름)"을 출력한다.
	
	※다른 페이지 없이 현재 페이지 하나에서만 처리하고, 결과가 출력될 때에는 input태그와 submit버튼이 나오게 해서는 안된다. 
	※form 태그의 속성은 action을 생략하면 현재페이지로 이동이된다. 
	※el과 jstl만 사용한다. (js금지)
	
	
	작업의 순서
	1. form태그 완성 (input, submit버튼
	2. param.name : 사용자가 입력한 이름. ! 이걸로 받는 것이다. 
	2-1. 비었나 안비었나 (empty param.name)으로 확인 
	2-2. 비었다면 form 태그 출력
	2-3. 안비었다면 admin, member, 비회원 검사
 -->
 	<c:choose>
 		<c:when test="${empty param.name}">
			<form>
				이름 : <input type="text" name="name"/>
				<input type="submit" value="확인">	
			</form>
		</c:when>
		<c:when test="${param.name =='admin'}">
			관리자
		</c:when>
		<c:when test="${param.name =='member'}">
			회원
		</c:when>
		<c:otherwise>
			비회원 (<c:out value=${param.name}/>)
		</c:otherwise>
	</c:choose>
	
	
	<!-- 
	이렇게 변수로 param.name을 name으로 설정해서 사용할 수도 있다. 
	<c:set var="name" value="${param.name}"/>
	  <c:choose>
      <c:when test="${empty name}">
         <form>
            이름 : <input type="text" name="name">
            <input type="submit" value="확인">
         </form>
      </c:when>
      <c:when test="${name == 'admin'}">
         관리자
      </c:when>
      <c:when test="${name == 'member'}">
         일반 회원
      </c:when>
      <c:otherwise>
         비회원 (<c:out value="${name}"/>)
      </c:otherwise>
   </c:choose>
	
	 -->
 
</body>
</html>





















