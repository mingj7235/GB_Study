/**
 * 회원 가입 세부 설정
 */

/*function sendIt() {
	//Ajax
	
	var frm = document.joinForm;
	var id = frm.id.value;
	var check = false;
	
	var httpRequest = new XMLHttpRequest();
	
	if(id.value != "") {
		httpRequest.open("GET", "join_ok.jsp?id="+id, true);
		httpRequest.send(); 
		
		httpRequest.onreadystatechange = function () {
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200) {
				document.getElementById("result").innerHTML = httpRequest.responseText;
				
				if(document.getElementById("result").innerHTML.trim() =="ok"){
					document.getElementById("id").readOnly = true;
					console.log(document.getElementById("id").readOnly);
				}else {
					
				}
			}
		}
		
	}
	
}*/

var check = false;
//사용가능한 아이디를 수정했을때 체크하는 변수 

function modifyId () {
	//클릭이벤트 메소드 (readonly를 막아줬던 것을 다시 풀어줌  id input태그에 클릭이됬을경우)
	document.joinForm.id.readOnly =false;
	check = false;
}

function sendIt(){
	//Ajax
	var frm = document.joinForm;
	var id = frm.id.value;
	var httpRequest = new XMLHttpRequest();
	
	httpRequest.open("GET", "join_ok.jsp?id=" + id, true);
	httpRequest.send();
	
	httpRequest.onreadystatechange = function () {
		if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status ==200) {
			//요청한 파일에는 값만 존재하는 것이 처리하기 편하다. 
			if(httpRequest.responseText.trim() == "ok") {
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

function join() {
//	join.jsp에있는 form 태그의 이름으로 이렇게 가져옴
	var frm = document.joinForm;
	
	if(frm.id.value =="") {
		alert("아이디를 입력해주세요");
		frm.id.focus(); //아이디가없을때 포커스를 해준ㄴ것임
		return false;
	}
	
	//아이디는 4자 이상, 16자 이하로 입력
	if(frm.id.value.length<4|| frm.id.value.length >16) {
		alert ("아이디는 4자 이상, 16자 이하로 입력해주세요.");
		fim.id.focus();
		return false;
	} 
	
	if(frm.name.value =="") {
		alser("이름을 입력해주세요.");
		frm.name.focus();
		return false;
	}
	
	if(frm.password.value =="") {
		alert("패스워드를 입력해주세요.");
		frm.password.focus();
		return false;
		
	}else { //입력한경우 정규식으로 검사
		//8자리 이상, 대문자/소문자/숫자/특수문자 모두 포함되어 있는 지 검사
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z](?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		//한글이 있는 지 검사 (자음, 모음, 그리고자음모음합쳐서 모두다 조회)
		var hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		if(!reg.test(frm.password.value)){
			//test()는 내가 작성한 정규식에 결과가 만족하면 true, 만족안되면 false다
			//정규식 조건에 맞지 않으면
			alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
			frm.password.focus();
			return false;
		}
		//같은 문자를 4번 이상 사용할 수 없다.
		else if (/(\w)\1\1\1/.text(frm.password.value)) {
			//같은 문자가 4개 이상 있다면
			alert("같은 문자를 4번 이상 사용할 수 없다.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호에 아이디가 포함되어 있을 수 없다.
		else if (frm.password.value.search(frm.id.value) > -1) { // != -1 과 같음. 포함되어있다는 의미임
			//-1은 아이디가 비밀번호에 없다는 뜻이므로 -1이 아닐 때 (아이디를 비밀번호에서 찾았을때) 들어옴
			alert("비밀번호에 아이디를 포함할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		
		//한글포함 여부
		else if (hangleCheck.test(frm.password.value)) { //true면 한글이 있다는 것임 
			//정규식 조건에 맞으면
			alert ("비밀번호에 한글을 사용할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호에 공백을 포함할 수 없다.
		else if (frm.password.value.search(/\s/) != -1) {//정규식에서 /\s/ 이 스페이스다. -1은 못찾았어요! 라는 의미임. 그래서 -1이 아니어야 공백이있다는것임
			//비밀번호에서 공백을 찾았다면
			alert("비밀번호에 공백 없이 입력해주세요.");
			frm.password.focus();
			return false;
		}
		
		//비밀번호 확인
		if (frm.password.value != frm.password_re.value){
			alert("패스워드를 확인해주세요.");
			frm.password_re.focus();
			return false;
		}
		
		//아이디 중복검사
		if(!check) {
			alert("아이디 중복확인을 진행해주세요");
			return false;
		}
		
		frm.submit();
	}
}










