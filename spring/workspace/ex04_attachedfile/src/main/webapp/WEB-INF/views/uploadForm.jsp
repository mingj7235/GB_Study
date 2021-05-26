<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload - Form</title>
</head>
<body>
	<form action="uploadFormAction" method = "post" enctype="multipart/form-data">
	<!-- multiple 속성을 작성하면, 여러개의 파일을 업로드 할 수 있다.  -->
	<!-- 컨트롤러에 전달할때에는 uploadFile이라는 배열 형태로 전달이 된다.  -->
		<input type="file" name="uploadFile" multiple> <!-- 디자인 하고싶으면, input테그를 display none하고 label로 디자인한다 -->
		<button>Submit</button> <!-- input submit과 button의 차이 다시공부  -->
	</form>
</body>
</html>