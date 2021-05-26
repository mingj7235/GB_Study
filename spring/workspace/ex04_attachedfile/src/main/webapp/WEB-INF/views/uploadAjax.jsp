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
		$("#uploadBtn").on("click", function () {
			var formData = new FormData(); //프로토 타입? 
			var inputFile = $("input[name='uploadFile']");
			var files = inputFile[0].files; //list형식으로 들어가게 된다. 0번째방이라고 하는 것은, input테그의 이름이 또 있을까봐 쓴것이다
			//파일 확장자 제한을 위한 정규식 
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880; //5MB 
			
			console.log(files);
			
			for(let i = 0; i < files.length; i++) {
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