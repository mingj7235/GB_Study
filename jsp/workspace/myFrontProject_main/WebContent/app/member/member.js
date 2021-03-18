/**
 * 
 */

//아이디 중복체크검사
var checkIdFlag = false;
//휴대폰 인증번호보내기 체크 검사
var checkSmsFlag = false;
//인증번호 일치 체크 검사
var checkModifyFlag = false;

/*function formSubmit(){
	   var form = document.signupForm;
	   
	   //아이디 검사
	   if(form.memberId.value == "" || !check){
	      alert("아이디를 확인해주세요.");
	      form.memberId.focus();
	      return false;
	   }
	   
	   form.submit();
	}
*/
function checkId() {
	//Ajax로 중복 체크 해주기.
	var id = document.getElementById("memberId").value;
	/*console.log(id+"체크아이디"); 등러옴*/
	checkIdFlag = false;
	if(id == "") {
		$("#check_id_result").text("아이디를 작성해주세요.");
	}else {
		$.ajax ({
			url:contextPath + "/member/MemberCheckIdOk.me?id="+id,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim()=="ok"){
					checkIdFlag=true;
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

function checkSms() {
	//Ajax로 중복 체크 해주기.
	var div = document.getElementById("phoneDiv");
	
	checkSmsFlag = false;
	var memberPhoneHead = document.getElementById("memberPhoneHead").value;
	var memberPhoneMid = document.getElementById("memberPhoneMid").value;
	var memberPhoneBottom = document.getElementById("memberPhoneBottom").value;
	var memberPhone = memberPhoneHead + memberPhoneMid + memberPhoneBottom;
	if(memberPhoneHead == "" || memberPhoneMid == "" || memberPhoneBottom =="") {
		$("#check_phone_result").text("휴대폰 인증버튼을 눌러주세요");
		
	}else {
		$.ajax ({
			url:contextPath + "/member/MemberCheckPhoneOk.me?memberPhone="+memberPhone,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim()=="ok"){
					checkSmsFlag=true;
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


function checkModifyNum () {
	//사용자가 적은것
	var modifyInput = document.getElementById("phoneIdentifyNum").value;
	checkModifyFlag = false;
	if(modifyInput == "") {
		$("check_modifyNum_result").text("인증번호를 입력해주세요");
	}else {
		$.ajax({
			url:contextPath + "/member/MemberCheckModifyOk.me?modifyInput="+modifyInput,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim()=="ok"){
					checkModifyFlag=true;
					document.getElementById("check_modifyNum_result").innerHTML ="<span style ='color:red;'>*</span> 인증번호가 확인되었습니다.";
				}else {
					document.getElementById("check_modifyNum_result").innerHTML ="<span style ='color:red;'>*</span> 인증번호를 다시 확인해주세요";
				}
			},
			error:function(){
				console.log("오류");
			}
		});
	}
}

function checkModifyNumFindId() {
	//사용자가 적은것
	var modifyInput = document.getElementById("phoneIdentifyNum").value;
	var memberEmail = document.getElementById("memberEmail").value;
	console.log("1");
	console.log(modifyInput);
	console.log(memberEmail);
	
	checkModifyFlag = false;
	if(modifyInput == "") {
		console.log("1");
		$("check_modifyNum_result").text("인증번호를 입력해주세요");
	}else {
		$.ajax({
			url:contextPath + "/member/MemberCheckModifyFindIdOk.me?modifyInput="+modifyInput+"&memberEmail="+memberEmail,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim()=="ok"){
					checkModifyFlag=true;
					document.getElementById("check_modifyNum_result").innerHTML ="<span style ='color:red;'>*</span> 인증번호가 확인되었습니다. 이메일로 아이디를 보내드렸습니다.";
				}else {
					document.getElementById("check_modifyNum_result").innerHTML ="<span style ='color:red;'>*</span> 인증번호를 다시 확인해주세요";
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
	var memberPhoneHead = document.getElementById("memberPhoneHead").value;
	var memberPhoneMid = document.getElementById("memberPhoneMid").value;
	var memberPhoneBottom = document.getElementById("memberPhoneBottom").value;
	var memberPhone = memberPhoneHead + memberPhoneMid + memberPhoneBottom;
	
	//jsp에서 잘려있는 정보를 이렇게 넣기 jsp와 자유롭게 소통
	$("input[name='memberPhone']").val(memberPhone);
	
	if(frm.memberId.value == "") {
		alert("아이디를 입력해주세요");
		frm.memberId.focus();
		return false;
	}
	
	if(frm.memberId.value.length <4 || frm.memberId.value.length >16) {
		alert("아이디는 4자 이상, 16자 이하로 입력해주세요.");
		frm.memberId.focus();
		return false;
	}
	
	if(frm.memberName.value == ""){
		alert("이름을 입력해주세요.");
		frm.memberName.focus();
		return false;
		
	} 
	var nameReg = /^[가-힣]{2,6}$/;
	if(!nameReg.test(frm.memberName.value)) {
		alert("이름은 한글로 입력해주세요");
		frm.memberName.focus();
		return false;
	} 
	if(frm.memberEmail.value =="") {
		alert("이메일을 입력해주세요");
		frm.memberEmail.focus();
		return false;
	}
	
	var mailReg = /^[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*@[0-9a-zA-Z]([-_.]?[0-9a-zA-Z])*.[a-zA-Z]{2,3}$/i;
	if(!mailReg.test(frm.memberEmail.value)) {
		alert("이메일 형식에 맞게 입력해주세요");
		frm.memberEmail.focus();
		return false;
	}
	
	if(frm.memberPw.value == ""){
		alert("패스워드를 입력해주세요.");
		frm.memberPw.focus();
		return false;
	}else{
		//8자리 이상, 대문자/소문자/숫자/특수문자 모두 포함되어 있는 지 검사
		var reg = /^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,}$/;
		//한글이 있는 지 검사
		var hangleCheck = /[ㄱ-ㅎ|ㅏ-ㅣ|가-힣]/;
		
		if(!reg.test(frm.memberPw.value)){
			//정규식 조건에 맞지 않으면
			alert("비밀번호는 8자리 이상이어야 하며, 대문자/소문자/숫자/특수문자 모두 포함해야 합니다.");
			frm.memberPw.focus();
			return false;
		}//비밀번호에 공백을 포함할 수 없다.
		else if(frm.memberPw.value.search(/\s/) != -1){
			
			//비밀번호에서 공백을 찾았다면
			alert("비밀번호에 공백 없이 입력해주세요.");
			frm.memberPw.focus();
			return false;
			
		}else if(hangleCheck.test(frm.memberPw.value)){
			//정규식 조건에 맞으면
			alert("비밀번호에 한글을 사용할 수 없습니다.");
			frm.memberPw.focus();
			return false;
		}
		//비밀번호 확인
		if(frm.memberPw.value != frm.memberPwRe.value){
			alert("패스워드를 확인해주세요");
			frm.memberPwRe.focus();
			return false;
		}
	}
	console.log(memberPhone);
	console.log(memberPhoneHead);
	console.log(memberPhoneMid);
	console.log(memberPhoneBottom);
	if(memberPhone == "" || memberPhoneMid == "") {
		alert ("핸드폰 번호를 입력해주세요.");
		frm.memberPhoneMid.focus();
		return false;
	}
	if(memberPhoneBottom == "") {
		alert ("핸드폰 번호를 입력해주세요.");
		frm.memberPhoneBottom.focus();
		return false;
	}
	var phoneReg = /^01([0|1|6|7|8|9]?)?([0-9]{3,4})?([0-9]{4})$/;
	if(!phoneReg.test(memberPhone)) {
		alert ("핸드폰 번호를 올바르게 입력해주세요");
		frm.memberPhoneMid.focus();
		return false;
	}
	
	if(!phoneReg.test(memberPhone)) {
		alert ("핸드폰 번호를 올바르게 입력해주세요");
		frm.memberPhoneMid.focus();
		return false;
	}
	
	if(!checkIdFlag){
		alert("아이디 중복확인을 진행해주세요");
		frm.memberId.focus();
		return false;
	}
	if(!checkSmsFlag){
		alert("휴대폰 인증을 진행해주세요");
		frm.memberPhoneMid.focus();
		return false;
	}
	if(!checkModifyFlag){
		alert("인증번호 확인을 진행해주세요");
		frm.phoneIdentifyNum.focus();
		return false;
	}
	
	frm.submit();
}



















