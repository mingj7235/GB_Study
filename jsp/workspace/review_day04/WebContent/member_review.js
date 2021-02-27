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
	var frm = document.joinForm;
	
	if(frm.id.value == "") {
		alert ("아이디를 입력해주세요");
		//아이디에 포커스가 갈수있도록 
		frm.id.focus();
		return false;
	}
	//아이디 4자 이상, 16자 이하
	
	if(frm.id.value.length <4 || frm.id.value.length >16) {
		alert ("아이디는 4자이상, 16자 이하로 입력해주세요.");
		frm.id.focus();
		return false;
	}
	if(frm.password.value == ""){
		alert("패스워드를 입력해주세요.");
		frm.password.focus();
		return false;
	}else{
		//8자리 이상, 대문자/소문자/숫자/특수문자 모두 포함되어 있는 지 검사
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		//한글이 있는 지 검사
		var hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		if(!reg.test(frm.password.value)){
			//정규식 조건에 맞지 않으면
			alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
			frm.password.focus();
			return false;
		}
		
		//같은 문자를 4번 이상 사용할 수 없다.
		else if(/(\w)\1\1\1/.test(frm.password.value)){
			//같은 문자가 4개 이상 있다면 
			alert("같은 문자를 4번 이상 사용할 수 없다.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호에 아이디가 포함되어 있을 수 없다.
		else if(frm.password.value.search(frm.id.value) > -1){
			//-1은 아이디가 비밀번호에 없는 뜻. 
			//따라서 -1이 아닐때(아이디를 비밀번호에서 찾았을 때) 들어옴
			
			alert("비밀번호에 아이디를 포함할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		//한글
		else if(hangleCheck.test(frm.password.value)){
			//정규식 조건에 맞으면
			alert("비밀번호에 한글을 사용할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		//비밀번호에 공백을 포함할 수 없다.
		else if(frm.password.value.search(/\s/) != -1){
			//비밀번호에서 공백을 찾았다면
			alert("비밀번호에 공백 없이 입력해주세요.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호 확인
		if(frm.password.value != frm.password_re.value){
			alert("패스워드를 확인해주세요");
			frm.password_re.focus();
			return false;
		}
		
		//아이디 중복검사
		if(!check) {
			alert("아이디 중복검사를 확인해주세요");
			return false;
		}
		//form 태그가 이제 db로 넘어감
		frm.submit();
	}
}
