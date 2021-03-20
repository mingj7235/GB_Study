/**
 * 회원가입
 */

var check = false;

function formSubmit(){
	var form = document.joinForm;
	
	//아이디 검사
/*	if(form.memberId.value == "" || !check){
		alert("아이디를 확인해주세요.");
		form.memberId.focus();
		return false;
	}*/
	
	form.submit();
}



//외부에서 사용자가 입력한 id값을 전달받는다.
function checkId(id){
	//사용자가 id를 입력할 때 마다 Flag를 false로 초기화해준다.
	check = false;
	if(id == ""){
		$("#idCheck_text").text("아이디를 작성해주세요.");
	}else{
		//jQuery Ajax는 JSON타입으로 필요한 요소를 전달한다.
		$.ajax({
			//외부 js에서는 contextPath를 가져올 수 없기 때문에 jsp에 선언한 contextPath를 사용한다.
			url:contextPath + "/member/MemberCheckIdOk.me?id="+id,	//요청할 url
			type:"get", //method
			dataType:"text", //전달받을 데이터의 타입
			success:function(result){	//통신 성공 시 응답 값을 result로 받는다.
				if(result.trim() == "ok"){
					check = true;
					$("#idCheck_text").text("사용할 수 있는 아이디입니다.");
				}else{
					$("#idCheck_text").text("중복된 아이디입니다.");
				}
			},
			error:function(){	//통신 오류 시
				console.log("오류");
			}
		});
	}
}

//키 이벤트 함수
$("input[name='memberId']").keyup(function(event){
	var id = $("input[name='memberId']").val();
	checkId(id);
});














