<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload - Ajax</title>
</head>
<body>
	<h1>File Upload - Ajax</h1>
	<div class = "uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>
	<button id="uploadBtn">upload</button>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		var contextPath = "${pageContext.request.contextPath}";
		
		//첨부파일 확장자, 사이즈 제한
		function check (fileName, fileSize) {
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$"); //업로드 하지않아야할 파일 확장자 
			var maxSize = 5242880; //5MB 
			if(regex.test(fileName)){	
				alert("업로드 할 수 없는 파일의 형식입니다.");
				return false;
			}
			if(fileSize >= maxSize){
				alert("파일 사이즈 초과");
				return false;
			}
			return true; //2개의 If문에안들어왓으므로 true를 리턴해준다.
		}
		
		
		$("#uploadBtn").on("click", function () {
			var formData = new FormData(); //프로토 타입? 
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files; //list형식으로 들어가게 된다. 0번째방이라고 하는 것은, input테그의 이름이 또 있을까봐 쓴것이다
			//파일 확장자 제한을 위한 정규식 
			
			console.log(files);
			
			for(let i = 0; i < files.length; i++) {
				if(!check(files[i].name, files[i].size)) {  //property가 name이다. -> console에 찍혀있음
					return false;
				} 
				formData.append("uploadFile", files[i]);
			}
			
			$.ajax ({
				url : contextPath + "/uploadAjaxAction",
				processData : false,
				contentType: false,// processData와 contentType을 false로주는건 디폴트 값도 안쓰겠다는 것임 
				data : formData,
				type : "post",
				success : function (result) {
					alert("Uploaded!");
				}
			});
			
		});
	});
</script>
</html>