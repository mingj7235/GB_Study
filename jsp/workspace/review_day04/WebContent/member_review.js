/**
 * 
 */


function checkId() {
	//Ajax
	//아이디 중복확인은 Ajax로 비동기 통신을 통해 진행한다.
	var httpRequest = new XMLHttpRequest();
	var id = document.getElementById("id").value;
	
	httpRequest.open("GET", "join_ok.jsp?id="+id);
	httpRequest.send();
	
	httpRequest.onreadystatechange =function () {
		if(httpRequest.readyState == XMLHttpRequest.DONE) {
			if(httpRequest.status == 200) {
				if(httpRequest.responseText.trim()=="ok") {
					
				}
				
			}
		}
		
		
	}
	
}