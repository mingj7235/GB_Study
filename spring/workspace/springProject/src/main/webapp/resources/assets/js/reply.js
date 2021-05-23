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
			success : function (result) {
				if(callback) {
					callback(result);
				}
			},
			error : function (xhr, status, err) {
				if (error) {
					error (err);
				}
			}
		})
	}
	
	function getList (param, callback, error) {
			
		var bno = param.bno;
		var page = param.page;

		$.getJSON ("/replies/list/" + bno + "/" + page + ".json",
			function (data) {
				if(callback) {
					callback (data.replyCnt, data.list)
				}
			}
		).fail (function (xhr, status, err){
			if(error) {
				error (err);
			}
		})
	}
	
	function getReply (rno, callback, error) {
		
		$.getJSON ("/replies/" + rno + ".json",
			function (result) {
				if(callback) {
					callback (result);
				}
			}
		).fail (function (xhr, status, err) {
			if (error) {
				error(err);
			}
		})
		
		
	}
	
	function remove (rno, callback, error) {
		$.ajax ({
			type : "delete",
			url : "/replies/" + rno,
			success : function (result) {
				if (callback) {
					callback (result);
				}
			},
			error : function (xhr, status, err) {
				if (error) {
					error (err);					
				}
			}
			
		})
	}
	
	function update (reply, callback, error) {
		
		console.log('들어오니');
		
		var rno = reply.rno;
		$.ajax ({
			type : "put",
			url : "/replies/" + rno,
			data : JSON.stringify(reply),
			contentType : "application/json; charset=utf-8",
			success : function (result) {
				if(callback) {
					callback (result);
				}
			},
			error : function (xhr, status, err) {
				if (error){
					error(err);
				}
			}
			
		})
	} 
	
		
	
	
	
	return {add : add, getList : getList, getReply : getReply, remove : remove, update : update}
		
	
	
		
})(); 















