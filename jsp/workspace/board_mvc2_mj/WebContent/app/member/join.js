/**
 * 회원가입
 */

/*var check = false;

function formSubmit() {
	var form = document.joinForm;
	
	//아이디 검사 (회원가입 버튼을 눌렀을때 확인하는 것임)
	if(form.memberId.value =="" || !check) {
		alert ("아이디를 확인해주세요.");
		form.memberId.focus();
		return false;
	}
	
	form.submit();
}

//입력이 될때마다 아이디를 체크할수있도록 만듬
function checkId (id) {
	check = false;
	if(id =="") {
		$("idCheck_text").text("아이디를 작성해주세요.");
	}else {
		//ajax를 jquery로 쓰는법  여기 안에 제이슨을 사용하는 것이다. 
		$.ajax({
			//contextPath는 joinForm에서 선언한것이다. el문으로 경로를 불러올수 없으므로, joinForm.jsp에서 컴파일을 하고, 아래에서join.js를 실행하니까 인식할수있다.
			url:contextPath+"/member/MemberCheckIdOk.me?id="+id, 
			type:"get",
			dataType:"text",
			success:function(result) {
				if(result.trim()=="ok") {
					check = true;
					$("idCheck_text").text("사용할 수 있는 아이디입니다.");
				}else {
					$("idCheck_text").text("중복된 아이디입니다.");
				}
			},
			error:function(){
				console.log("오류");
			}
		});
	}
}

//키 이벤트 함수 (keyup은 눌렀다 떼면 이다. keyup을 해야 db를 조회해야한다. )
$("input[name='memberId']").keyup(function(event){
	var id = $("input[name='memberId]").val();
	checkId(id);
});*/

/**
 * 회원가입
 */

var check = false;

function formSubmit(){
   var form = document.joinForm;
   
   //아이디 검사
   if(form.memberId.value == "" || !check){
      alert("아이디를 확인해주세요.");
      form.memberId.focus();
      return false;
   }
   
   form.submit();
}

//외부에서 사용자가 입력한 id값을 전달받는다. 
function checkId(id){
	//사용자가 id를 입력할 때 마다 Flag를 false로 초기화 해준다. 
   check = false;
   if(id == ""){
      $("#idCheck_text").text("아이디를 작성해주세요.");
   }else{
	   //jQuery Ajax는 JSON타입으로 필요한 요소를 전달한다. 
      $.ajax({
    	 //외부 js에서는 contextPath를 가져올 수 없기 때문에 jsp에 선언한 contextPath를 사용한다. 
    	//contextPath는 joinForm에서 선언한것이다. el문으로 경로를 불러올수 없으므로, joinForm.jsp에서 컴파일을 하고, 아래에서join.js를 실행하니까 인식할수있다.
         url:contextPath + "/member/MemberCheckIdOk.me?id="+id, //요청할 url
         type:"get", //method (전달 방식)
         dataType:"text", //전달받을 데이터의 타입
         success:function(result){ //요청 성공 시 응답 값을 result로 받는다. 
            if(result.trim() == "ok"){
               check = true;
               $("#idCheck_text").text("사용할 수 있는 아이디입니다.");
            }else{
               $("#idCheck_text").text("중복된 아이디입니다.");
            }
         },
         error:function(){ //통신 오류 시
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




























