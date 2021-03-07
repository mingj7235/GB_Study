/**
 * 로그인
 */


function login(){
	var form = document.loginForm;
	//id가 비어있을 경우 실행
	if(form.memberId.value == ""){
		alert("아이디를 입력해주세요.");
		//memberId라는 name을 가진 input 태그에 커서를 놓는다.
		form.memberId.focus();
		return false;
	}
	
	//pw가 비어있을 경우 실행
	if(form.memberPw.value == ""){
		alert("비밀번호를 입력해주세요.");
		//memberPw라는 name을 가진 input 태그에 커서를 놓는다.
		form.memberId.focus();
		return false;		
	}
	
	form.submit();
}