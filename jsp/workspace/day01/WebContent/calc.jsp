<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>계산기 실습</title>
</head>
<body>
<!-- 	<form action="Result" method = "post">
		<input name = "num1" value = "" type="text" placeholder="첫번째 숫자">
		<select name = "oper">
			<option selected> 연산자 선택 </option>
			<option > + </option>
			<option > - </option>
			<option > * </option>
			<option > / </option>
		</select>
		<input name = "num2" value = "" type="text" placeholder="두번째 숫자">
		<button type="submit">연산 결과 확인</button>
	</form> -->
	
	<form action = "Result" method = "post">
		<input name = "input" value = "" type = "text" placeholder="수식 입력">
		<button type = "submit">연산결과 확인</button>
	</form>
</body>
</html>