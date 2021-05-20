<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>Board</title>
      <meta charset="utf-8" />
      <meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
      <meta name="description" content="" />
      <meta name="keywords" content="" />
      <link rel="stylesheet" href="/resources/assets/css/main.css" />
      <style>
      	.big-width {
      		display : block;
      	}
      	
      	.small-width {
      		display : none;
      	}
		
		.table-wrapper {overflow-x:hidden !important;}      
      	
      	select {width: 25%; display:inline;}
      	input[name='keyword'] {width:54%; display:inline;}
      	.search {width:20%;} 
      	
      	@media(max-width : 918px){
      		.writer {display:none;}
      		.regDate {display:none;}
      		.updateDate {display:none;}
      		.big-width {
      			display : none;
      		}
      	
      		.small-width {
      			display : block;
      		}
      		
      		select {width: 100%; }
      		input[name='keyword'] {width:100%; }
      		.search {width:100%;} 
      		
      	}
      	
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
                        <p>게시판 목록</p>
                     </header>
                           <!-- Table -->
                           				<!-- board컨트롤러의 register를 요청하는것이다. 이거는 디폴트가 get으로 가기때문에
                           					컨트롤러에 get방식으로 register를 하나 더 만들어 놓는것이다. 페이지이동용으로!-->
                              <h3><a href="/board/register${pageMaker.cri.getListLink()}" class="button small">글 등록</a></h3>
                              <div class="table-wrapper">
                                 <table>
                                    <thead>
                                       <tr class="tHead">
                                          <th class="bno">번호</th>
                                          <th class="title">제목</th>
                                          <th class="writer">작성자</th>
                                          <th class="regDate">작성일</th>
                                          <th class="updateDate">수정일</th>
                                       </tr>
                                    </thead>
                                    <tbody>
         								<c:forEach var="board" items="${list}">
         									<tr class="tBody">
	                                          <td class="bno">${board.bno}</td> <!-- board.getBno()를 써도되지만, 자동으로 매핑해서 가져온다. -->
	                                          <td class="title"><a href="/board/get${pageMaker.cri.getListLink()}&bno=${board.bno}">${board.title}</a></td>
	                                          <td class="writer">${board.writer}</td>
	                                          <td class="regDate">${board.regDate}</td>
	                                          <td class="updateDate">${board.updateDate}</td>
         									</tr>
         								</c:forEach>
                                    </tbody>
                                    <tfoot>
                                    </tfoot>
							<!-- 현재페이지가 지금페이지와 같다면 숫자에 a테그를 넣으면안된다.  -->
                                 </table>
	                                 <div class="big-width" style ="text-align: center;">
	                                 	<c:if test="${pageMaker.prev}">
	                                 		<a class="changePage" href="${1}"><code>&lt;&lt;</code></a>
	                                 		<a class="changePage" href="${pageMaker.startPage -1}"><code>&lt;</code></a>
	                                 	</c:if>
	                                 
										<c:forEach var="num" begin="${pageMaker.startPage}" end="${pageMaker.endPage}">
											<c:choose>
												<c:when test="${num eq pageMaker.cri.pageNum}">
													<code>${num}</code>
												</c:when>
												<c:otherwise>
													<a class="changePage" href="${num}"><code>${num}</code></a>
												</c:otherwise>
											</c:choose>	
										</c:forEach>
	                                 	<c:if test="${pageMaker.next}">
	                                 		<a class="changePage" href="${pageMaker.endPage + 1}"><code>&gt;</code></a>
	                                 		<a class="changePage" href="${pageMaker.realEnd}"><code>&gt;&gt;</code></a>
	                                 	</c:if>
	                                 </div>
	                                 
	                                 <div class="small-width" style ="text-align: center;">
	                                 	<c:if test="${pageMaker.cri.pageNum > 1}">
	                                 		<a class="changePage" href="${1}"><code>&lt;&lt;</code></a>
	                                 		<a class="changePage" href="${pageMaker.cri.pageNum - 1}"><code>&lt;</code></a>
	                                 	</c:if>
										<code>${pageMaker.cri.pageNum}</code>
	                                 	<c:if test="${pageMaker.cri.pageNum <pageMaker.realEnd}">
	                                 		<a class="changePage" href="${pageMaker.cri.pageNum + 1}"><code>&gt;</code></a>
	                                 		<a class="changePage" href="${pageMaker.realEnd}"><code>&gt;&gt;</code></a>
	                                 	</c:if>
	                                 </div>
	                                 
	                                 <!-- 페이지를 넘기는걸 눌렀을때 pageNum과 amount를 새로 넘기기위해서 form태그를 사용해서 넘긴다. 밑에 js에서 작업한다.  -->
	                                 <form id="actionForm" action="/board/list">
	                                 	<input type="hidden" name="pageNum" value="${pageMaker.cri.pageNum}">
	                                 	<input type="hidden" name="amount" value="${pageMaker.cri.amount}">
	                                 	<input type="hidden" name="type" value="${pageMaker.cri.type}">
	                                 	<input type="hidden" name="keyword" value="${pageMaker.cri.keyword}">
	                                 </form>
	                                 
	                                 <form action="/board/list" id="searchForm">
	                                 	<div class="fields">
	                                 		<div class="field">
	                                 			<div style="text-align: center">
		                                 			<!-- criteria의 필드인 type이 매핑되는것임 -->
		                                 			<select name="type">
		                                 				<!-- 검색한 후에 selected 를 유지시키기위해서! 검색하고나서도 유지하기위해서다 -->
		                                 				<option value ="" ${pageMaker.cri.type==null ? 'selected' : ''}>검색 기준</option>
		                                 				<option value ="T" ${pageMaker.cri.type=='T' ? 'selected' : ''}>제목</option>
		                                 				<option value ="C" ${pageMaker.cri.type=='C' ? 'selected' : ''}>내용</option>
		                                 				<option value ="W" ${pageMaker.cri.type=='W' ? 'selected' : ''}>작성자</option>
		                                 				<option value ="TC" ${pageMaker.cri.type=='TC' ? 'selected' : ''}>제목 또는 내용</option>
		                                 				<option value ="TW" ${pageMaker.cri.type=='TW' ? 'selected' : ''}>제목 또는 작성자</option>
		                                 				<option value ="TCW" ${pageMaker.cri.type=='TCW' ? 'selected' : ''}>전체</option>
		                                 			</select>
		                                 			<!-- criteria의 필드인 keyword가 매핑 -->
		                                 			<input id="keyword" type="text" name="keyword" value="${pageMaker.cri.keyword}">
		                                 			<a class="search button primary icon solid fa-search" href="javascript:void(0)">검색</a>
		                                 			
		                                 		</div>
	                                 		</div>
	                                 	</div>
	                                 </form>
                              </div>
                        </div>
                     </div>
                  </div> 

      <!-- Scripts -->
      <!-- resources로 바로 접근하는 이유는 servlet-context.xml에 선언되어있기 때문이다.  -->
         <script src="/resources/assets/js/jquery.min.js"></script>
         <script src="/resources/assets/js/jquery.dropotron.min.js"></script>
         <script src="/resources/assets/js/browser.min.js"></script>
         <script src="/resources/assets/js/breakpoints.min.js"></script>
         <script src="/resources/assets/js/util.js"></script>
         <script src="/resources/assets/js/main.js"></script>
   </body>
   <script>
   
   		$("a.search").on("click", function(e){
   			e.preventDefault();
   			var searchForm = $("#searchForm");
   			
   			/* 조건식에 val()이들어가면 값이 있는지업는지 boolean타입으로 됨 */
   			if(!searchForm.find("option:selected").val()) { //사용자가 사용하면 selected가 붙는다. html 문법이다.
   				alert("검색 종류를 선택하세요.");
   				return false;
   			}
   			if(!searchForm.find("input[name='keyword']").val()) {
   				alert("키워드를 선택하세요.");
   				return false;
   			}
   			searchForm.submit();
   			
   		})
   			
   
   		$(".changePage").on("click", function (e){
   			e.preventDefault(); //누른것의 기본의 이벤트는 막아지는 것이다. 내가 지정해준것만 이벤트처리해줘야한다.
   			var actionForm = $("#actionForm");
   			var pageNum = $(this).attr("href"); //이것이 바로 그 클릭이벤트를 눌렀을때 이동할 페이지 !!
   			actionForm.find("input[name='pageNum']").val(pageNum);
   			actionForm.submit();
   		})  
   
   		//alert("${result}");
   		var result = "${result}";
   		$(document).ready(function(){
   			if(result=='' || isNaN(result)){
   				return;
   			}
   			alert("게시글" + result + "번이 등록되었습니다.");
   		})
   		
   </script>
</html>