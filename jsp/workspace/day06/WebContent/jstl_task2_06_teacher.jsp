<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL 실습(제어문 - 반복문)</title>
</head>
<body>
<!--
   1단 부터 100단까지 중 사용자에게 입력받은 단수로 구구단 출력하기.
   입력받은 값이 정수인지 아닌지 판단, 값을 입력했는지 안했는지 판단.
   다른 페이지 이동 없이 현재 페이지에서만 기능 구현
   자바스크립트 사용 가능(Number.isInteger(값) : boolean) 
-->
   <h2>JSTL 실습(제어문 - 반복문)</h2>
   <form name ="gugudan">
      단 수 : <input type ="text" name ="dan" placeholder="정수 입력">
      <input type="button" value="확인" onclick="sendIt()">
   </form>
   
   <c:set var="dan" value="${param.dan}"/><!-- 파라미터 저장 -->
   
   <!-- dan 에 값이 있을때 들어오게끔하는것 -->
   <c:if test="${not empty dan}">
      <c:choose>
         <%-- 입력한 값이 0보다 크고 101보다 작을 때(jsp주석으로 해야 컴파일할때 오류가안난다)--%>
         <c:when test="${dan > 0 and dan < 101}">
            <c:forEach var="i" begin="1" end="9">
            	<c:out value="${dan} * ${i} = ${dan * i}"/><br>
            </c:forEach>
         </c:when>
         <c:otherwise>
         	1이상 100이하의 값으로 입력해주세요.
         </c:otherwise>
      </c:choose>
   </c:if>
</body>
<!-- jQuery는 사용하지 않는다. -->
<script>
   //엔터 처리
   //엔터를 아예 없애는 방법
   document.addEventListener("keydown", function(key){
	   if(key.keyCode == 13) { //13번이 엔터다
		   key.preventDefault(); //누른걸 아예 막아준다. 즉, 엔터를 없애는것임 
	   }
   });
   
   //함수
   function sendIt() {
	   var frm = document.gugudan;
	   var data =frm.dan.value;
	   var check = data % 1 == 0; //boolean 타입으로 정수 인경우를 check로만들어준다.  
	   
	   if(!Number.isInteger(parseInt(data)) || data =="" || !check) {
		   alert("정수만 입력해주세요.");
		   return false;
	   }
	   frm.dan.value = parseInt(data);
	   
	   frm.submit();
	   
   }
</script>
</html>










