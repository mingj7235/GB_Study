/**
 * 
 */



var replyService = (function(){

	function add (reply, callback, error) {
		$.ajax ({
			type : "post",
			url : "/replies/new",
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function(result) {
				if(callback) {
					callback (result);
				}
				
			},
			error : function (xhr, status, er) {
				if(error) {
					error (er);
				}
			}
		});
	};
	
	function getList (param, callback, error) {
		
		var bno = param.bno;
		var page = param.page;
		
		$.getJSON ("/replies/list" + bno + "/"  + page + ".json",
			function (data) {
				if (callback) {
					callback (data.replyCnt, data.list);
				}
			}
		), fail (function (xhr, status, err) {
			if(error) {
				error(err);
			}
		})
		
	};
	
	
	function getReply (rno, callback, error) {
		
		$.getJSON ("/" + rno + ".json",
			function (data) {
				if(callback) {
					callback(data);
				}
			}
		), fail(function(xhr, status, err) {
			if(error) {
				error(err);
			}
		})
		
	};
	
	
	
	
	return {add : add, getList : getList}
		
	
	
		
})(); 















