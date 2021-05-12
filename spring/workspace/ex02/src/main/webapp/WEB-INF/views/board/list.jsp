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
                              <h3><a href="/board/register" class="button small">글 등록</a></h3>
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
	                                          <td class="title"><a href="/board/get?bno=${board.bno}">${board.title}</a></td>
	                                          <td class="writer">${board.writer}</td>
	                                          <td class="regDate">${board.regDate}</td>
	                                          <td class="updateDate">${board.updateDate}</td>
         									</tr>
         								</c:forEach>
                                    </tbody>
                                    <tfoot>
                                    </tfoot>
                                 </table>
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
   		//alert("${result}");
   		var result = "${result}"
   		$(document).ready(function(){
   			if(result=='' || isNaN(result)){
   				return;
   			}
   			alert("게시글" + result + "번이 등록되었습니다.");
   		})
   		
   </script>
</html>