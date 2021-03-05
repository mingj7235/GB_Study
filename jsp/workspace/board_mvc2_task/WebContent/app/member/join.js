var check = false;

function formSubmit() {
	var form = document.joinForm;
	
	if(form.memberId.value =="" || !check) {
		alert("아이디를 확인해주세요.");
		form.memberId.focus();
		return false;
	}
	form.submit();
}

function checkId (id) {
	check = false;
	
	if(id == "") {
		$("#idCheck_text").text("아이디를 입력하셈");
	}else {
		$.ajax({
			url:contextPath + "/member/MemberCheckIdOk.me?id"+id,
			type:"get",
			dataType:"text",
			success:function(result){
				if(result.trim() =="ok") {
					check = true;
					$("#idCheck_text").text("사용가능");
				}else {
					$("#idCheck_text").text("중복된 아이디");
				}
			},
			error:function(){
				console.log("오류");
			}
		});
	}
}

$("input[name='memberId]").keyup(function(event){
	var id = $("input[name='memberId']").val();
	checkId(id);
});
	
