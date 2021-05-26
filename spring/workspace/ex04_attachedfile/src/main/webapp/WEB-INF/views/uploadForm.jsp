<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload</title>
</head>
<body>
	<form action="uploadFormAction" method = "post" enctype="multipart/form-data">
		<input type="file" name="uploadFile" multiple> <!-- 디자인 하고싶으면, input테그를 display none하고 label로 디자인한다 -->
		<button>Submit</button> <!-- input submit과 button의 차이 다시공부  -->
	</form>
</body>
</html>