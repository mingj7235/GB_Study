<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Ajax file upload test</h1>
	<div class = "uploadDiv"> <!-- dom을 위한 선택자 -->
		<input type ="file" name = "uploadFiles" multiple>	
	</div>
	<button name = "uploadBtn" id="uploadBtn">submit</button>

</body>
<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	$(document).ready(function(){
		var contextPath = "${pageContext.request.contextPath}"
		
		//boolean type의 메소드를 만들어서 안에서 사용하자 ! 
		function check (fileName, fileSize) {
			var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
			var maxSize = 5242880;
			//1. fileName을 통해 확장자 제한
			if(regex.test(fileName)) {
				alert("업로드 불가 형식 ")
				return false;
			}
			if (fileSize > maxSize) {
				alert("파일 크기는 5mb 이하입니다. ");
				return false;
			}
			
			return true;
			
			//2. fileSize 제한
		}
		
		$("#uploadBtn").on("click", function(){
			
			//FormData()는 multipart/form-data 즉, 보낼 데이터다 
			var formData = new FormData();
			var inputFile = $("input[name='uploadFiles']");
			var files = inputFile[0].files;
			
			//이거확인해볼 것  inputFile[0].files와 뭐가 다른지 
			console.log(formData);
			console.log("inputFile : " + inputFile);
			console.log("inputFile[0]" + inputFile[0]);
			console.log("무엇으로 찍히는지 궁금 : "+files);
			
			for(let i = 0; i<files.length; i++) {
				
				if (!check (files[i].name, files[i].size)) {
					return false;
				}
				
				//uploadFiles라는 키값에 반복을 돌면서 files들을 넣는다.
				//이것을 컨트롤러에 매핑해서 가지고가서 연산한다. 
				//보내는것은 아래에 ajax를 통해서 보낸다. 
				formData.append("uploadFiles", files[i]);
			}
			
			console.log("실제데이터:" + formData);
			$.ajax ({
				url : contextPath + "/uploadAjaxActionReview",
				type : "post",
				//processData 와 contentType은 false를 주어야한다.
				//formData로 보낼것이기 때문이다. 
				processData : false,
				data : formData,
				contentType : false,
				success : function(result) {
					alert ("uploaded!");
				}
				
			})
			
		});
		
		
		
		
		
		
	});
	
</script>

</html>