<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Board</title>
<meta charset="utf-8" />
<meta name="viewport"
	content="width=device-width, initial-scale=1, user-scalable=no" />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="/resources/assets/css/main.css" />
</head>
<body class="is-preload">
	<!-- Main -->
	<div id="main">
		<div class="wrapper">
			<div class="inner">

				<!-- Elements -->
				<header class="major">
					<h1>Board</h1>
					<p>게시글 등록</p>
				</header>
				<!-- controller에서 (/get, /modify해놓은 get 메소드에서 )cri를 받아서 보낸다. -->
				<h3>
					<a href="/board/list${cri.getListLink()}" class="button small">목록
						보기</a>
				</h3>
				<div class="content">
					<div class="form">
						<form action="/board/remove">
							<input type="hidden" name="pageNum" value="${cri.pageNum}">
							<input type="hidden" name="amount" value="${cri.amount}">
							<input type="hidden" name="type" value="${cri.type}"> <input
								type="hidden" name="keyword" value="${cri.keyword}">
							<div class="fields">
								<div class="field">
									<h4>번호</h4>
									<input name="bno" type="text" value="${board.bno}" readonly />
								</div>
								<div class="field">
									<h4>제목</h4>
									<input name="title" type="text" value="${board.title}" readonly />
								</div>
								<div class="field">
									<h4>내용</h4>
									<textarea name="content" rows="6" style="resize: none" readonly>${board.content}</textarea>
								</div>
								<div class="field">
									<h4>작성자</h4>
									<input name="writer" type="text" value="${board.writer}"
										readonly />
								</div>
							</div>
							<ul class="actions special">
								<li><input type="button" class="button" value="수정"
									onclick="location.href='/board/modify${cri.getListLink()}&bno=${board.bno}'" />
									<input type="submit" class="button" value="삭제" /></li>
							</ul>

							<!-- 댓글부분-->
							<ul class="icons">
								<li><span class="icon solid fa-envelope"></span> <strong>댓글</strong>
								</li>
							</ul>
							<a style="width: 100%" href="javascript:void(0)"
								class="button privmary small register">댓글 등록</a>
							<div class="fields register-form" style="display: none;">
								<div class="field">
									<h4>작성자</h4>
									<input type="text" name="replyer" placeholder="Replyer">
								</div>
								<div class="field">
									<h4>댓글</h4>
									<textarea rows="6" name="reply" placeholder="reply"
										style="resize: none;"></textarea>
								</div>
								<div class="field regBtn">
									<a href="javascript:void(0)"
										class="button primary small finish">등록</a> <a
										href="javascript:void(0)" class="button primary small cancel">취소</a>

								</div>
							</div>
							<ul class="replies">
							</ul>

							<div class="paging" style="text-align: center;">
							
							</div>


						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Scripts -->
	<script src="/resources/assets/js/jquery.min.js"></script>
	<script src="/resources/assets/js/jquery.dropotron.min.js"></script>
	<script src="/resources/assets/js/browser.min.js"></script>
	<script src="/resources/assets/js/breakpoints.min.js"></script>
	<script src="/resources/assets/js/util.js"></script>
	<script src="/resources/assets/js/main.js"></script>
	<script src="/resources/assets/js/reply.js"></script>
</body>
<script>
   //테스트
   	//$(document).ready(function() { 
   		/* console.log(replyService.name); */
   		/* console.log("----------");
   		console.log("JS TEST"); */
   															/* jsp에서는 el문을 그대로 사용가능하다,  */
   															
   															/* 매개변수 json, callback, error (error는 안넘) */
   		/* replyService.add({reply : "JS TEST", replyer:"tester", bno : "${board.bno}"}, 
   				function(result){ 
   					alert("RESULT : " + result);
   		});  */
   		
   		
/*    		replyService.getList ({bno : "${board.bno}", page:2},
   			function(data) {
   				console.log(data);
   		});  */
   		
   		/* replyService.remove(1, function (result) {
   			if(result == "success") {
	   			alert("DELETE:" result);
   			}
   		}.function(err) {
   			alert("error");
   		}
   		) */
   		
/*    		replyService.modify({rno : 1, reply : "Modified Reply"}, function(result) {
   			alert("Modifiy : " + result);
   		}); */
   		
   		/* replyService.get(1, function (result){
   			console.log(result);
   		}) */
   		
   	//}); 
   </script>

<script>
   	$(document).ready(function () {
   		var bno = "${board.bno}"; //bno는 많이 쓰므로 이렇게 scope를 확대해서 변수로 저장
   		var pageNum = 1;
   		showList(); //처음에 상세보기를 실행했을 때, 댓글 상세보기를 해줘야한다. 
		
   			//위의3가지 bno, pageNum, showList()는 최초에 상세보기르 ㄹ눌렀으 ㄹ때만 작동하는 것이다. 
   		
   		$(".register").on("click", function (e){
   			e.preventDefault();	
   			$(".register-form").show(); //display : none 을 변경 
   			$(this).hide(); //누른 버튼 즉, register 버튼을 hide
   		})
   		
   		
   		$(".cancel").on("click", function(e){
   			e.preventDefault();
   			$(".register-form").hide();
   			$(".register").show();
   		})
   		
   		$(".finish").on("click", function(e){
   			e.preventDefault();
   			
   			//여기에 이제 댓글 모듈을 사용해서 등록한다.
   			//그러기전에 일단, 댓글과 작성자의 값을 가져온다. 
   			var reply = $("textarea[name='reply']").val(); //.text()인경우 데이터를 가져오지 못한다. 
   						// 이유 : textarea에서 이미 작성한 글을 가져올 때에는 .text(), .val() 둘다 가능
   						//하지만, 랜더링 후 입력한 값을 가져올 때에는반드시 val() 을 사용해야한다.
   						//즉, 사용자에게 입력받은것을 가져오려면 val()을 사용해서 값을 가져와야한다. 
   					
   			var replyer = $("input[name='replyer']").val();
   			
   			replyService.add({bno: bno, reply : reply, replyer: replyer},//댓글모듈 -> reply.js의 replyService객체의 add function의 매개변수 reply로 json형태로 들어간다.
   					function(result){
   						alert(result);
   			}); 
   			
   		});
   		
   		//두개의 함수를 사용해서 댓글의 화면을 구성하는 것이다.
   		//댓글의 목록 = > showList
   		//댓글의 페이징 처리 => showReplyPage
   		
   		function showReplyPage (replyCnt) {
   			var str = ""; //누적연결해서 html코드를 쓸 것 
   			var replyPaging = $(".paging");
   			var endNum = Math.ceil(pageNum/ 10.0) * 10 ; 
   			var startNum = endNum - 9;
   			var realEnd = Math.ceil(replyCnt / 10.0);
   			
   			//if(endNum > replyCnt / 10.0) {
   			if(endNum > realEnd) {
   				//realEnd는 실제 게시물 
   				endNum = realEnd;
   			}
   			var prev = startNum != 1;
   			var next = endNum * 10 < replyCnt; //이번에는 replyCnt와 비교하는 것. board에서는 realend와 비교했다. 
			
   			
   			//js에서 미디어 쿼리를 사용하는 법 
   			if(matchMedia("screen and (max-width:918px)").matches) {
   				//918px보다 작을 때 
	   			if (pageNum != 1) {
	   				str += "<a class='changePage' href='"+(pageNum - 1) + "'><code>&lt;</code></a>"	
	   			}
	   			
					str += "<code>"+ i +"</code>"	
	   			
	   			if (pageNum != realEnd) {
	   				str += "<a class='changePage' href='"+(pageNum + 1) + "'><code>&gt;</code></a>"	
	   			}
   				
   			}else {
   				//918px보다 클 때 	
	   			
	   			if (prev) {
	   				str += "<a class='changePage' href='"+(startNum - 1) + "'><code>&lt;</code></a>"	
	   			}
	   			
	   			for(let i = startNum; i <= endNum; i++) {
	   				
					if(pageNum == i) {			
						str += "<code>" + i + "</code>";
						continue;
					}
					str += "<a class='changePage' href='"+ i + "'><code>"+ i +"</code></a>"	
	   			}
	   			
	   			if (next) {
	   				str += "<a class='changePage' href='"+(endNum + 1) + "'><code>&gt;</code></a>"	
	   			}
   			
   			}
   			
   			replyPaging.html(str); //paging div 박스의 html값에 이것을 계속 교체해주는 것이다. ajax로 ! 
   		}
   			
   		$(".changePage").on("click", function(e){
   			e.preventDefault();
   			
   			pageNum=$(this).attr("href"); //문자열일 가능성이 높다. (parseint해야할 수도 있다 )
   			showList(pageNum);
   		})	
   		
   		
   		
   		function showList (page) {
   			//여기에서 ajax 통신을 할 것이다. 
   			//여기에서는 목록을 만든다. 
   			var replyUL = $(".replies"); //댓글목록을 뿌릴 ul 테그 
   			replyService.getList({bno:bno, page: page || 1}, //reply.js의 getList는 bno와 page를 필요로한다.
   				function(replyCnt, list){
					if(list == null || list.length == 0) {
						replyUL.html("등록된 댓글이 없습니다.");
						return;
					}
					
					var str = "";
					
					for(let i = 0, len = list.length; i < len; i ++) { //조건식 안에서 len을 선언해서 range에서 사용하는 방법
						//data라는 속성 -> data("rno") 즉, rno라는 key값을 전달하면 value를 가져올 수 있다. 	
						str += "<li data-rno='"+list[i].rno+"'>";
						str += "<strong>" +list[i].replyer+"</strong>";
						str += "<p class='reply"+list[i].rno +"'>" + list[i].reply + "</p>";
						str += "<div sytle='text-align:right;'>";
						str += "<a class='modify' href='"+list[i].rno+"'>수정</a>&nbsp;";
						str += "<a class='remove' href='"+list[i].rno+"'>삭제</a>";
						str += "</li>";
					}
					
					replyUL.html(str);
					showReplyPage(replyCnt);
					
   			}); 
   			
   		}
   		
   		
   		
   	})
   
   </script>

</html>








