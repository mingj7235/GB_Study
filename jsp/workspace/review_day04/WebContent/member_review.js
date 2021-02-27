/**
 * 
 */

var check = false;

function modifyId() {
	document.joinForm.id.readOnly = false;
	check = false;
}

function checkId() {
	//Ajax
	//아이디 중복확인은 Ajax로 비동기 통신을 통해 진행한다.
	var httpRequest = new XMLHttpRequest();
	var id = document.getElementById("id").value;
	
	httpRequest.open("GET", "join_ok.jsp?id="+id);
	httpRequest.send();
	
	httpRequest.onreadystatechange =function () {
		if(httpRequest.readyState == XMLHttpRequest.DONE) {
			if(httpRequest.status == 200) {
				if(httpRequest.responseText.trim()=="ok") {
					document.joinForm.id.readOnly = true;
					document.getElementById("result").innerHTML = "사용가능한 아이디입니다.";
					check = true;
				}else {
					document.getElementById("result").innerHTML = "중복된 아이디입니다.";
					check = false;
				}
				
			}
		}
	}
}


function join () {
	
	
	
}
