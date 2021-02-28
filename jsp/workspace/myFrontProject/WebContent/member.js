/**
 * 
 */

var check = false;

function modifyId () {
	document.signupForm.id.readOnly = false;
	check = false;
}

function checkId() {
	//Ajax로 중복 체크 해주기.
	
	var httpRequest = new XMLHttpRequest();
	var id = document.getElementById("id").value;
	httpRequest.open("GET", "signup_check.jsp?id="+id);
	httpRequest.send();
	
	httpRequest.onreadystatechange = function () {
		if(httpRequest.readyState == XMLHttpRequest.DONE && 
				httpRequest.status ==200) {
			if(httpRequest.responseText.trim() == "ok") {
				document.signupForm.id.readOnly = true;
				document.getElementById("check_id_result").innerHTML ="<span style ='color:red;'>*</span>사용가능한 아이디입니다.";
				check = true;
			} else {
				document.getElementById("check_id_result").innerHTML ="<span style ='color:red;'>*</span>중복된 아이디입니다.";
				check =  true;
			}
		}
	}
}

function signup() {
	var frm = document.signupForm;
	
	if(frm.id.value == "") {
		alert("아이디를 입력해주세요");
		frm.id.focus();
		return false;
	}
	
}