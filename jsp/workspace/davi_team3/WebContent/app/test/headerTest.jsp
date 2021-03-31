<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1, user-scalable=no" />
<link rel="stylesheet" href="${pageContext.request.contextPath}/assets/css/main.css" />
<link rel="preconnect" href="https://fonts.gstatic.com">
<link href="https://fonts.googleapis.com/css2?family=Sunflower:wght@300&display=swap" rel="stylesheet">
<title>header</title>
<style>
ul, li {
  margin: 0;
  padding: 0;
  list-style: none;
  float:left;
}

#main-menu > li {
  float: left;
  position: relative;
}

#main-menu > li > a {
  font-size: 1rem;
  color: #ffaec9;
  text-align: center;
  text-decoration: none;
  letter-spacing: 0.05em;
  display: block;
/*   padding: 14px 36px;
 */  text-shadow: 1px 1px 1px rgba(0,0,0,0.2);
}



#sub-menu {
  position: absolute;
  background:white;
  opacity: 0;
  visibility: hidden;
  transition: all 0.15s ease-in;
}

#sub-menu > li {
 padding: 16px 0;
  border-bottom: 1px solid rgba(0,0,0,0.15);
   margin-top:50px;
}

#sub-menu > li >  a {
  color: black;
  text-decoration: none;
 
}

  #main-menu > li:hover #sub-menu {
  opacity: 1;
  visibility: visible;
}

  #sub-menu > li >  a:hover {
 text-decoration: underline;
} 

</style>
</head>
<body>
   <!-- Header -->
   <header id="header">   
      <div class="row">
         <div class="col-4">
            <a href="${pageContext.request.contextPath}/index.jsp" class="logo">
            <img src="${pageContext.request.contextPath}/images/logo_header.png" width="78" height="35" />
            </a>   
         </div>
         
         <div class="col-8" style="display: flex; justify-content:flex-end;">            
            <ul class="myMenu">
                              
               
               <!-- 세션의 아이디로그인 정보를 이용하여 if문의 조건 검색 -->
               <c:set var="check" value="2" />
               <c:if test="${check eq 1}">               
                  <li><a href="#">로그인</a>&nbsp;</li>
                  <li><a href="#" >회원가입</a></li>
               </c:if>
               <c:if test="${check eq 2}">
                  <li style="margin-top:5%;">(#)님 환영합니다.&nbsp;</li>                        
              <ul id="main-menu" style="width:22%; ">
                <li><a href=" "><img src="${pageContext.request.contextPath}/images/myPage.png" style="width:100%;"></a>
               <ul id="sub-menu">
                    <li><a href="#" aria-label="subemnu">정보 수정</a></li>
                    <li><a href="#" aria-label="subemnu">비밀번호 변경</a></li>
                 <li><a href="#" aria-label="subemnu">나의 식단관리 </a></li>
               </ul>
             </li>
             </ul>
               <li style="margin-top:5%;"><a href="#">로그아웃</a>&nbsp;</li>
               </c:if>
             </ul>      
         </div>
      </div>
   </header>
 
</body>
	<script src="assets/js/jquery.min.js"></script>
	<script>
		
	</script>
</html>