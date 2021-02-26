<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 검색 순위</title>
</head>
<body>
	<table border="1">
		<tr>
			<td class = "td1"><h2>실시간 검색 순위</h2></td>
			<td class = "td2"><div id="ranking">키워드</div></td>
		</tr>
	</table>
</body>
<script>
	//위에 있는 문서가 다 준비되었을때 ...!!
	window.unload = function () {
		var words = new Array();
		var obj = "";
		var ranking = document.getElementById("ranking");
		
		
		var request = new XMLHttpRequest();
		request.open("GET", "data.json", true);
		request.send();
		
		request.onreadystatechange = function () {
			if(request.readyState ==4) {
				if(request.status == 200) {
					obj = JSON.parse(request.responseText);
					for(let i = 0 ; i <obj.search_word.length; i++) {
						words[i] = "[" +obj.search_word[i].rank + "]" + obj.search_word[i].name;
					}
				}
			}
		}
		//setInterval은 2초마다한번씩 함수가 실행되도록하는것.반복된다.  
		//interval이라는 변수에 저장해서, 끝내고싶을때 끝내게한다.
		var i = 0;
		var interval = setInterval(function(){
			
			if(i == obj.search_word.length) {i = 0;} //0, 1, 2, 3 이 반복되도록 ! length 가 지금 4이므로! 
			
			ranking.innerHTML = "<h3>" +words[i] + "</h3>";
			i++;
			
		}, 500);
		
		//10초가되는 순간 없어진다. interval이 멈춘다.
		setTimeout(function() {
			clearInterval(interval);
		},100000);
		
	}
</script>
</html>
 --%>
 
 <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>실시간 검색 순위</title>
</head>
<body>
   <table border="1">
      <tr>
         <td class="td1"><h2>실시간 검색 순위</h2></td>
         <td class="td2"><div id="ranking">키워드</div></td>
      </tr>
   </table>
</body>
<script>
   window.onload = function(){
      var words = new Array();
      var obj = "";
      var ranking = document.getElementById("ranking");
      
      var request = new XMLHttpRequest();
      request.open("GET", "data.json", true);
      request.send();
      
      request.onreadystatechange = function(){
         if(request.readyState == 4){
            if(request.status == 200){
               obj = JSON.parse(request.responseText);
               //obj에 담은 json에서 search_word의 키로 접근하면 이건 json array 즉 배열!!
               //JSONArray의 길이만큼 반복 (1위~4위)
               for(let i=0; i<obj.search_word.length; i++){
            	   //각각의 프로퍼티를 가져와서 words[i]에 순서대로 저장한다. 
                  words[i] = "[" + obj.search_word[i].rank + "]" + obj.search_word[i].name;
               }
            }
         }
      }
      
      var i = 0;
      //setInterval(function (){실행할 기능}, 밀리초) : 밀리초마다 기능 실행 
      var interval = setInterval(function(){
    	 //i는 최대값을 3으로 유지시킨다.
         if(i == obj.search_word.length) { i = 0;}
         //결과를 순서대로 ranking에 넣어준다.
         ranking.innerHTML = "<h3>" + words[i] + "</h3>";
         i++;
      }, 500);
      
      setTimeout(function(){
    	 //선언된 setInterval객체를 없애준다.
         clearInterval(interval);
      }, 100000);
   }
</script>
</html>























 