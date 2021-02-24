<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 예제</title>
</head>
<body>
	<form action ="object_ok.jsp" name = "join">
		<fieldset>
			<legend>개인 정보</legend>
			<input type ="text" name = "name">
			<input type ="date" name = "birthday">
			<input type ="button" value="확인" onclick ="sendIt()">
		</fieldset>
	</form>
</body>
<script src="//code.jquery.com/jquery-3.5.1.min.js"></script>
<script>
/* 
	이전 상태로 되돌리고 싶을 때에는
	이전 전체 body를 저장한 후 덮어쓰는 방법을 주로 사용한다. (통째로 다시그리는게 훨신 빠름)
*/
	$("input[name='name']").click(function(){
		$("input[name='name']").removeAttr("style"); /* 클릭시 원상복구 */
		$("input[name='name']").removeAttr("placeholder"); /* 클릭시 원상복구 */
	})
	$("input[name='birthday']").click(function(){
		$("input[name='birthday']").removeAttr("style"); /* 클릭시 원상복구 */
	})
	
	function sendIt() {
		var frm = document.join; /* form태그의 name */
		var check = false;
		
		
		if(frm.name.value == "") {
			$("input[name='name']").css('border-color', 'red');
			$("input[name='name']").attr('placeholder', '성함을 입력하세요');
			check = true;
		}
		if(frm.birthday.value == "") {
			$("input[name='birthday']").css('border-color', 'red');
			check = true;
		}
		
		if(check) {return false;}
		
		frm.submit(); /* action이 되는 것!  */
	}
</script>
</html>