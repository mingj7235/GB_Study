<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GET, POST 방식의 요청</title>
</head>
<body>
<!-- 	<h1>GET 방식의 요청</h1>
	<button type="button" onclick="sendRequest()">GET방식으로 요청 보내기!</button>
	<p id="text"></p> -->
	
	<h1>POST 방식의 요청</h1>
	<button type ="button" onclick="sendRequest()">POST 방식으로 요청 보내기!</button>
	<p id="text"></p> 
	
</body>
<script>
	function sendRequest(){
		var httpRequest = new XMLHttpRequest();
		
		/* GET방식 */ //get방식은 open()에 데이터를 쿼리스트링으로 보낸다.
/* 		httpRequest.open("GET", "request_ajax.jsp?city=Seoul&zipcode=88855", true);
		httpRequest.send(); */

		/* POST방식 */ //post는 send()에 header로 보냄
		httpRequest.open("POST", "request_ajax.jsp", true);
		httpRequest.setRequestHeader("Content-Type", "application/x-www-form-urlencoded"); 
		//post방식에서 send에 있는것을 header에 숨겨서 보내야하므로 암호화(encoded)해서 보내야한다.
		httpRequest.send("city=Seoul&zipcode=55775");
		
		
		/* 응답 상태를 알기위해서 쓰는것임 */
		httpRequest.onreadystatechange = function () {
			//요청과 응답에 성공했을 때
			if(httpRequest.readyState == XMLHttpRequest.DONE && httpRequest.status == 200) {
				/* if(httpRequest.readyState == 4 && httpRequest.status == 200) */
				//응답 값을 받아온다. 특정 부분, 즉 텍스트만 가져와서 dom으로 p태그에 꽂아넣는것임
				document.getElementById("text").innerHTML = httpRequest.responseText;
			}
		}
		
	}
</script>
</html>