/**
 * 
 */

var check = false;

function formSubmit(){
	   var form = document.signupForm;
	   
	   //아이디 검사
	   if(form.memberId.value == "" || !check){
	      alert("아이디를 확인해주세요.");
	      form.memberId.focus();
	      return false;
	   }
	   
	   form.submit();
	}

function checkId() {
	//Ajax로 중복 체크 해주기.
	var id = document.getElementById("memberId").value;
	check = false;
	if(id == "") {
		$("#check_id_result").text("아이디를 작성해주세요.");
	}else {
		$.ajax ({
			url:contextPath + "/member/MemberCheckIdOk.me?id="+id,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim()=="ok"){
					check=true;
					document.getElementById("check_id_result").innerHTML ="<span style ='color:red;'>*</span> 사용가능한 아이디입니다.";
				}else {
					document.getElementById("check_id_result").innerHTML ="<span style ='color:red;'>*</span> 중복된 아이디입니다.";
				}
			},
			error:function(){
				console.log("오류");
			}
				
			
		});
	}
	
	//jQuery가 아닌 방법으로 Ajax
	/*var httpRequest = new XMLHttpRequest();
	console.log(document.getElementById("id").value);
	httpRequest.open("GET", "signup_check.jsp?id="+document.getElementById("id").value);
	httpRequest.send();
	
	httpRequest.onreadystatechange = function () {
		if(httpRequest.readyState == XMLHttpRequest.DONE && 
				httpRequest.status ==200) {
			if(httpRequest.responseText.trim() == "ok") {
				document.signupForm.id.readOnly = true;
				document.getElementById("check_id_result").innerHTML ="<span style ='color:red;'>*</span> 사용가능한 아이디입니다.";
				check = true;
			} else {
				document.getElementById("check_id_result").innerHTML ="<span style ='color:red;'>*</span> 중복된 아이디입니다.";
				check =  true;
			}
		}
	}*/
}

function checkPhone() {
	//Ajax로 중복 체크 해주기.
	var div = document.getElementById("phoneDiv");
	var memberPhoneHead = document.getElementById("memberPhoneHead").value;
	var memberPhoneMid = document.getElementById("memberPhoneMid").value;
	var memberPhoneBottom = document.getElementById("memberPhoneBottom").value;
	
	var memberPhone = memberPhoneHead + memberPhoneMid + memberPhoneBottom;
	
	check = false;
	console.log("들어옴");
	console.log(memberPhoneHead);
	console.log(memberPhoneMid);
	console.log(memberPhoneBottom);
	
	if(memberPhoneHead == "" || memberPhoneMid == "" || memberPhoneBottom =="") {
		$("#check_phone_result").text("휴대폰 인증버튼을 눌러주세요");
		
	}else {
		$.ajax ({
			url:contextPath + "/member/MemberCheckPhoneOk.me?memberPhone="+memberPhone,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim()=="ok"){
					check=true;
					//여기에 인증번호 버튼 로직을 짜야하는것인가..?
					document.getElementById("check_phone_result").innerHTML ="<span style ='color:red;'>*</span> 인증번호가 전송되었습니다.";
				}else {
					document.getElementById("check_phone_result").innerHTML ="<span style ='color:red;'>*</span> 이미 등록된 번호입니다. 확인해주세요.";
				}
			},
			error:function(){
				console.log("오류");
			}
			
		});
	}

}

function signup() {
	var frm = document.signupForm;
	var phonenum = document.signupForm.phonenum_head.value + document.signupForm.phonenum_mid.value + document.signupForm.phonenum_bottom.value;
	
	if(frm.id.value == "") {
		alert("아이디를 입력해주세요");
		frm.id.focus();
		return false;
	}
	
	if(frm.id.value.length <4 || frm.id.value.length >16) {
		alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
		frm.id.focus();
		return false;
	}
	
	if(frm.nameMember.value == ""){
		alert("이름을 입력해주세요.");
		frm.nameMember.focus();
		return false;
		
	} 
	var nameReg = /^[가-힣]{2,6}$/;
	if(!nameReg.test(frm.nameMember.value)) {
		alert("이름은 한글로 입력해주세요");
		frm.nameMember.focus();
		return false;
	} 
	if(frm.email.value =="") {
		alert("이메일을 입력해주세요");
		frm.email.focus();
		return false;
	}
	
	var mailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(!mailReg.test(frm.email.value)) {
		alert("이메일 형식에 맞게 입력해주세요");
		frm.email.focus();
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
		}//비밀번호에 공백을 포함할 수 없다.
		else if(frm.password.value.search(/\s/) != -1){
			
			//비밀번호에서 공백을 찾았다면
			alert("비밀번호에 공백 없이 입력해주세요.");
			frm.password.focus();
			return false;
			
		}else if(hangleCheck.test(frm.password.value)){
			//정규식 조건에 맞으면
			alert("비밀번호에 한글을 사용할 수 없습니다.");
			frm.password.focus();
			return false;
		}
		//비밀번호 확인
		if(frm.password.value != frm.password_re.value){
			alert("패스워드를 확인해주세요");
			frm.password_re.focus();
			return false;
		}
	}
	if(phonenum == "") {
		alert ("핸드폰 번호를 입력해주세요.");
		frm.phonenum_mid.focus();
		return false;
	}
	var phoneReg = /^([0-9]{3,4})?([0-9]{4})$/;
	console.log(phonenum);
	if(!phoneReg.test(phonenum)) {
		alert ("핸드폰 번호를 올바르게 입력해주세요");
		frm.phonenum_mid.focus();
		return false;
		
	}
	
	if(!check){
		alert("아이디 중복확인을 진행해주세요");
		frm.id.focus();
		return false;
	}
	
	frm.submit();
}


















