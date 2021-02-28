/**
 * 
 */

var check = false;

function modifyId () {
	document.signupForm.email.readOnly = false;
	check = false;
}

function checkId() {
	//Ajax로 중복 체크 해주기.
	
	var httpRequest = new XMLHttpRequest();
	var email = document.getElementById(email).value;
	httpRequest.open("GET", "signup_check.jsp?email="+email);
	httpRequest.send();
	
	httpRequest.onreadystatechange = function () {
		if(httpRequest.readyState == XMLHttpRequest.DONE && 
				httpRequest.status ==200) {
			if(httpRequest.responseText.trim() == "ok") {
				document.signupForm.email.readOnly = true;
				document.getElementById("check_id_result").innerHTML ="사용가능한 아이디입니다.";
				check = true;
			} else {
				document.getElementById("check_id_result").innerHTML ="중복된 아이디입니다.";
				check =  true;
			}
		}
	}
}

function signup() {
	
	
}