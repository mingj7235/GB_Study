//댓글 등록
function replyOk(bulletinNum) {
	var replyContent = $("#writeReply").val(); //댓글 내용	
	var param = {
			"replytext" : replyContent,
			"bulletinNum" : bulletinNum
	};	
	$.ajax({
		type : "post", //데이터를 보낼 방식
		url : "", //데이터를 보낼 url
		data : param, //보낼 데이터
		
		success : function() { //데이터를 보내는것이 성공했을시 출력되는 메시지
			alert("댓글이 등록되었습니다.");
			listReply(); //댓글 목록 출력
		}
	});	
}

//댓글 목록 출력
function listReply(){
    $.ajax({
        type: "get", //get방식으로 자료를 전달한다
        url: "${path}/reply/list.do?bno=${dto.bno}", //컨트롤러에 있는 list.do로 맵핑하고 게시판 번호도 같이 보낸다.
        success: function(result){ //자료를 보내는것이 성  공했을때 출력되는 메시지
            //result : responseText 응답텍스트(html)
            $("#listReply").html(result);
        }
    });
}

function replyAnd(num, level) {
	var WID = 15;	
	$("#replyLevel" + num).addClass("replyLevel-" + (level+1));
	//document.id.style.marginLeft = WID*level + 'px';
}

function replyAnswer(num, level) {	
	$("article #replyLevel" + num).each(function(index, item) {		
		$(this).addClass("replyLevel-" + level);		
	});
	
	$("#replyAnswer" + num).show();
}

