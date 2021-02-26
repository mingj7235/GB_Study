<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	
	<!-- 만약 회원가입에 실패해서 join.jsp로 왔다면, check 파라미터에 false가 담겨있다. -->
	<!-- 하단의 JS부분에서 처리해준다. joinCheck를 dom으로 꽂아서 사용한다.  -->
	<input type ="hidden" value = "<%= request.getParameter("check")%>" name = "joinCheck"><!-- join_db에서 로그인 실패시 여기로돌아옴 joincheck는 아래 js에서사용-->
	
	<!-- method를 post로 바꿔주면 url이 안더러웜 -->
	<form action="join_db.jsp" name="joinForm" method="post">
		<p>
			<!-- 아이디를 입력하는 input테그를 클릭하면 사용자가 수정을 시도하는것으로 판단하여 modifyId() 함수를 onclick이벤트에 달아줘서 member.js에서 작동하게해준다. -->
			<label>아이디 : <input type="text" name="id" id="id" onclick="modifyId()"></label>
			<input type="button" value="중복 확인" onclick="sendIt()">
		</p>
		<p id="result"></p>
		<p>
			<label>이름 : <input type="text" name="name"></label>
		</p>
		<p>
			<label>패스워드 : <input type="password" name="password"></label>
		</p>
		<p>
			<label>패스워드 확인 : <input type="password" name="password_re"></label>
		</p>
		<p>
			성별 :<label><input type="radio" name="gender" value="남자" checked></label>
			<label><input type="radio" name="gender" value="여자"></label>
		</p>
		<p>
			우편번호 : <input type="text" name="zipcode" class="postcodify_postcode5" value="" readonly/>
			<input type="button" id="postcodify_search_button" value="검색"><br />
		</p>
		<p>
			주소 : <input type="text" name="address" class="postcodify_address" value="" readonly/><br />
		</p>
		<p>
			상세 주소 : <input type="text" name="addressDetail" class="postcodify_details" value="" /><br />
		</p>
		<p>
			참고 항목 : <input type="text" name="addressEtc" class="postcodify_extra_info" value="" /><br />
		</p>
		<p>
			<input type="button" value="가입 완료" onclick="join()">
		</p>
	</form>
</body>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1/jquery.min.js"></script>
<script src="//d1p7wdleee1q2z.cloudfront.net/post/search.min.js"></script>
<script src="member.js"></script>
<script>
	if($("input[name='joinCheck']").val()=='false') {
		alert("회원가입 실패. 잠시후 다시 시도해주세요.");
	}
</script>
<script> $(function() { $("#postcodify_search_button").postcodifyPopUp(); }); </script>
</html>

















