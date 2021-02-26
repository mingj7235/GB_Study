/**
 * 회원 가입 세부 설정
 */

var check = false;

//사용가능한 아이디를 수정했을 때
function modifyId(){
	//중복확인 후 수정이 불가능했던 input태그를 다시 수정가능하게 변경해준다. 
	document.joinForm.id.readOnly = false;
	
	//수정을 시도했기 때문에 회원가입 진행을 막아준다.
	check = false;
}

function sendIt(){
	//Ajax
	var httpRequest = new XMLHttpRequest();
	
	httpRequest.open("GET", "join_ok.jsp?id="+document.getElementById("id").value);
	httpRequest.send();
	
	httpRequest.onreadystatechange = function(){
		if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200){
			//요청한 파일에는 값만 존재하는 것이 처리하기 편하다.
			//responseText로 전달받은 값의 앞 뒤 공백을 없애주기 위해 trim()을 사용한다. 
			if(httpRequest.responseText.trim() == "ok"){
				//중복검사를 한 아이디 input태그에 수정을 막아준다. 
				document.joinForm.id.readOnly = true;
				//중복검사의 결과값을 화면에 뿌려준다. 
				document.getElementById("result").innerHTML = "사용가능한 아이디입니다.";
				//회원가입을 진행할 수 있도록 Flag를 true로 변경해준다. (맨 아래에 메소드로 체크해서 폼테그에서 넘길수있도록한다.)
				check = true;
			}else{
				document.getElementById("result").innerHTML = "중복된 아이디입니다.";
				//중복된 아이디라면 check를 false로 설정해준다. 
				check = false;
			}
		}
	}
}

function join(){
	var frm = document.joinForm;
	
	if(frm.id.value == ""){
		alert("아이디를 입력해주세요");
		frm.id.focus();
		return false;
	}
	
	//아이디는 4자 이상, 16자 이하로 입력
	if(frm.id.value.length < 4 || frm.id.value.length > 16){
		alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
		frm.id.focus();
		return false;
	}
	
	if(frm.name.value == ""){
		alert("이름을 입력해주세요.");
		frm.name.focus();
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
		if(!check){
			alert("아이디 중복확인을 진행해주세요");
			return false;
		}
		
		frm.submit();
		
	}
}












