/**
 * 
 */

//로그인 메소드 (아이디, 페스워드가 빈칸으로 되어있는지 아닌지 검사)
function login() {
	var frm = document.loginForm;
	
	if(frm.memberId.value == "") {
		alert ("아이디를 입력해주세요");
		frm.memberId.focus();
		return false;
	}
	
	if (frm.memberPw. value == "") {
		alert("비밀번호를 입력해주세요");
		frm.memberPw.focus();
		return false;
	}
	
	frm.submit();
	
	
}