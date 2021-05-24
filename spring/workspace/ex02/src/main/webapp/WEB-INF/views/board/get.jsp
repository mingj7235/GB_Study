<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <script>
   //테스트용
//      $(document).ready(function(){
         //console.log(replyService.name);
         
/*          console.log("==========");
         console.log("JS TEST"); */

/*          replyService.modify({rno : 21, reply : "Modified Reply"}, function(result){
            alert("MODIFY : " + result);
         });
          */
/*          replyService.remove(41, function(result){
            if(result == "success"){
               alert("REMOVED");
            }
         },function(err){
            alert("ERROR...");
      }) */
         
         /* replyService.getList({bno:"${board.bno}", page: 1},
               function(data){
               console.log(data);
         }); */
         
         /* replyService.add({reply:"JS TEST", replyer:"tester", bno:"${board.bno}"}, 
               function(result){
                  alert("RESULT : " + result);
         }); */
         
         /* replyService.get(21, function(result){
            console.log(result);
         }) */
         
//      })
   </script>
   <head>
      <title>Board</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <meta name="description" content="" />
      <meta name="keywords" content="" />
      <link rel="stylesheet" href="/resources/assets/css/main.css" />
      <style>
         .line{border-bottom: 1px solid #20c5e7;}
      </style>
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
               <h3><a href="/board/list${cri.getListLink()}" class="button small">목록 보기</a></h3>
                  <div class="content">
                     <div class="form">
                        <form action="/board/remove">
                           <input type="hidden" name="pageNum" value="${cri.pageNum}">
                     <input type="hidden" name="amount" value="${cri.amount}">
                           <input type="hidden" name="type" value="${cri.type}">
                     <input type="hidden" name="keyword" value="${cri.keyword}">
                           <div class="fields">
                              <div class="field">
                                 <h4>번호</h4>
                                 <input name="bno" type="text" value="${board.bno}" readonly/>
                              </div>
                              <div class="field">
                                 <h4>제목</h4>
                                 <input name="title" type="text" value="${board.title}" readonly/>
                              </div>
                              <div class="field">
                                 <h4>내용</h4>
                                 <textarea name="content" rows="6" style="resize:none" readonly>${board.content}</textarea>
                              </div>
                              <div class="field">
                                 <h4>작성자</h4>
                                 <input name="writer" type="text" value="${board.writer}" readonly/>
                              </div>
                           </div>
                           <ul class="actions special">
                              <li>
                                 <input type="button" class="button" value="수정" onclick="location.href='/board/modify${cri.getListLink()}&bno=${board.bno}'"/>
                                 <input type="submit" class="button" value="삭제"/>
                              </li>
                           </ul>
                           <ul class="icons">
                              <li>
                                 <span class="icon solid fa-envelope"></span>
                                 <strong>댓글</strong>
                              </li>
                           </ul>
                          <a style="width:100%" href="javascript:void(0)" class="button primary small register">댓글 등록</a>
                          <div class="fields register-form" style="display:none">
                             <div class="field">
                                <h4>작성자</h4>
                                <input type="text" name="replyer" placeholder="Replyer">
                             </div>
                             <div class="field">
                                <h4>댓글</h4>
                                <textarea rows="6" name="reply" placeholder="Reply" style="resize:none;"></textarea>
                             </div>
                             <div class="field regBtn">
                                <a href="javascript:void(0)" class="button primary small finish">등록</a>
                                <a href="javascript:void(0)" class="button primary small cancel">취소</a>
                             </div>
                          </div>
                           <ul class="replies">
                           </ul>
                           <div class="paging" style="text-align:center;">
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
   	$(document).ready (function(){
   		
   		var bno = "${board.bno}";
   		
   		$(".register").on("click", function(e){
   			e.preventDefault();
   			$(".register-form").show();
   			$(this).hide();
   		})
   		
   		$(".cancel").on("click", function(e){
   			e.preventDefault();
   			$(".register-form").hide();
   			$(".register").show();
   		})
   		
   		$(".finish").on("click", function(e){
   			e.preventDefault();
   			
   			var replyer = $("input[name='replyer']").val();
   			var reply = $("textarea[name='reply']").val();
   			
   			replyService.add({bno:bno, reply:reply, replyer:replyer},
   				function(result) {
   				alert(result);
   			}		
   			);
   		})
   		
   		function showReplyPage(replyCnt) {
   			var str = "";
   			var paging = $(".paging");
   			var endNum = Math.ceil (pageNum / 10.0) * 10;
   			var startNum = endNum - 9;
   			var realEnd = Math.ceil(replyCnt / 10.0);
   			
   		}
   		
   		function showList () {
   			replyService.getList();
   		}
   		
   		
   	})
   	
   </script>
   
   
   <script>
      $(document).ready(function(){
         var bno = "${board.bno}";
         var pageNum = 1;
         
         showList();
         
         $(".register").on("click", function(e){
            e.preventDefault();
            $(".register-form").show();
            $(this).hide();
         });
         
         $(".cancel").on("click", function(e){
            e.preventDefault();
            $(".register-form").hide();
            $(".register").show();
         });
         
         $(".finish").on("click", function(e){
            e.preventDefault();
            
            //textarea에서 이미 작성한 글을 가져올 때에는 text()도 ok, val()도 ok
            //하지만 랜더링 후 입력한 값을 가져올 때에는 반드시 val()를 사용한다.
            var reply = $("textarea[name='reply']").val();
            var replyer = $("input[name='replyer']").val();
            
            replyService.add({bno:bno, reply:reply, replyer:replyer},
                  function(result){
                     alert(result);
                     pageNum = 1;
                     showList(pageNum);
            });
         });
         function showList(page){
            var replyUL = $(".replies");
            replyService.getList({bno:bno, page:page||1},
                  function(replyCnt, list){//컨트롤러에서 응답한 댓글 전체 개수와 댓글 목록을 받는다.
                     if(list == null || list.length == 0){
                        //만약 현재 페이지가 1보다 클 때 더 이상 보여줄 댓글이 없다면
                        //이전 페이지로 이동하여 댓글 목록을 보여주도록 한다.
                        if(pageNum > 1){pageNum -= 1; showList(pageNum);}   
                        replyUL.html("등록된 댓글이 없습니다.");
                        return;
                     }
                     var str = "";
                     //data 속성
                     //태그에 원하는 value를 저장시키기 위해서 사용한다.
                     //data-변수명="value"로 작성하며, jQuery에서 해당 태그객체.data("변수명")으로
                     //value를 가져와 사용할 수 있다.
                     //만약 value를 수정하고 싶다면 해당 태그객체.data("변수명","새로운 값");
                     for(let i=0, len=list.length; i<len; i++){
                        str += "<li data-rno='" + list[i].rno + "'>";
                        str += "<strong>" + list[i].replyer + "</strong>";
                        str += "<p class='reply" + list[i].rno + "'>" + list[i].reply + "</p>";
                        str += "<div style='text-align:right;'>";
                        str += "<a class='modify' href='" + list[i].rno + "'>수정</a>"
                        str += "<a class='finish' href='" + list[i].rno + "' style='display:none;'>수정완료</a>"
                        str += "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
                        str += "<a class='remove' href='" + list[i].rno + "'>삭제</a>"
                        str += "</div><div class='line'></div></li>";
                     }
                     replyUL.html(str);
                     showReplyPage(replyCnt);
            });
         }
         
         function showReplyPage(replyCnt){
            var str = "";
            var replyPaging = $(".paging");
            var endNum = Math.ceil(pageNum / 10.0) * 10;
            var startNum = endNum - 9;
            var realEnd = Math.ceil(replyCnt / 10.0)
            
            //if(endNum > replyCnt / 10.0){
            if(endNum > realEnd){
               endNum = realEnd;
            }
            
            var prev = startNum != 1;
            var next = endNum * 10 < replyCnt;
            
            if(matchMedia("screen and (max-width:918px)").matches){
               //918px보다 작을 때
               if(pageNum != 1){
                  str += "<a class='changePage' href='" + (pageNum - 1) + "'><code>&lt;</code></a>" 
               }
                  str += "<code>" + pageNum + "</code>";
               if(pageNum != realEnd){
                  str += "<a class='changePage' href='" + (pageNum + 1) + "'><code>&gt;</code></a>" 
               }
            }else{
               //918px보다 클 때
               if(prev){
                  str += "<a class='changePage' href='" + (startNum - 1) + "'><code>&lt;</code></a>" 
               }
               for(let i=startNum; i<=endNum; i++){
                  if(pageNum == i){
                     str += "<code>" + i + "</code>";
                     continue;
                  }
                  str += "<a class='changePage' href='" + i + "'><code>" + i + "</code></a>"
               }
               if(next){
                  str += "<a class='changePage' href='" + (endNum + 1) + "'><code>&gt;</code></a>" 
               }
            }
            replyPaging.html(str);
         }
         
         //이벤트 위임
         //처음부터 없던 코드를 자바스크립트로 붙이면, 이벤트 함수가 새로운 코드를 인식하지 못하여 사용이 안된다.
         //이럴 때에는 처음부터 있는 부모 태그에 이벤트를 주고, 그 자식태그로 들어올 선택자를 작성하여 이벤트를 위임해준다.
         $(".paging").on("click", "a.changePage", function(e){
            e.preventDefault();
            pageNum = parseInt($(this).attr("href"));   //문자열이면 위에서 연결되기 때문에 반드시 정수로 형변환한다.
            console.log(pageNum)
            showList(pageNum);
         });
         
         
         //댓글 삭제
         //삭제 버튼 클릭 시 해당 댓글 번호를 가져와 삭제하기
         $(".replies").on("click", "a.remove", function(e){
            e.preventDefault();
            var rnoValue = $(this).attr("href");
            
            replyService.remove(rnoValue, function(result){
               alert(result);
               showList(pageNum);
         });
        });
         
         var check = false;
         
         //댓글 수정
         $(".replies").on("click", "a.modify", function(e){
            e.preventDefault();
            if(check){alert("이미 수정중인 댓글이 있습니다."); return;}
            
            var rnoValue = $(this).attr("href");
            var replyTag = $(".reply" + rnoValue);
            
            replyTag.html("<textarea class='" + rnoValue + "'>" + replyTag.text() + "</textarea>")
            $(this).hide();
            
            
			//한줄로 가져오기            
            
            $(this).parent().find(".finish").show();
            
            //다 가져오기
          /*  var finishs = $(".finish")
           for(let i=0; i<finishs.length; i++)
               if($(finishs[i]).attr("href") == rnoValue){
                  $(finishs[i]).show();
                  check = true;
                  break;
               }
            } */
         });
         
         $(".replies").on("click", "a.finish", function(e){
            e.preventDefault();
            var rnoValue = $(this).attr("href");
            var newReply = $("." + rnoValue).val();
            
            replyService.modify({rno:rnoValue, reply:newReply}, function(result){
               alert(result);
               check = false;
               showList(pageNum);
            });
         });
         
      });
   </script>
</html>




















