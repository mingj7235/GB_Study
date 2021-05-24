/**
 * javascript reply ajax module 
 */

var replyService = (function(){ //replyService는 json타입이다!
	
	//댓글 추가 
	function add (reply, callback, error) {
		console.log("add reply ...");
		$.ajax ({
			type : "post",
			url : "/replies/new",	
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function (result) {
				if(callback) {
					callback(result);
				}
			},
			error : function (xhr, status, err) {
				if(error) {
					error (err);
				}
 			}
		})
	}
	
	//댓글 목록
	function getList (param, callback, error) {
		log.info ("getList...");
		var bno = param.bno;
		var page = param.page;
		
		$.getJSON ("/replies/pages/"+bno+"/"+page+".json"  //".json"을 붙이지 않으면 xml데이터
			,function(data) {
				if(callback) {
					callback (data);
				}
			})
		.fail(function(xhr, status, err){
			if(error) {
				error(err);
			}
		})
	}
	
	//댓글 삭제
	function remove (rno, callback, error) {
		log.info("remove.....");
		$.ajax ({
			type : "delete",
			url : "/replies/" + rno,
			success : function (result) {
				if(callback) {
					callback (result);
				}
			},
			error : function (xhr, status, err) {
				if(error) {
					error(err)
				}
			}
		});
	}
	
	//댓글 수정
	function 
	
	
	return {add : add, getList : getList, remove : remove} ;
}) ();





















