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
	
	<div class="uploadResult"><!-- 성공한 파일이 올라감  -->
		<h3>가져오기 성공한 파일 </h3>
		<ul></ul>
	</div>
	
	<button id="uploadBtn">upload</button>
	
	<div class="uploadFail" style="display : none;"><!-- 실패한 파일이 올라감 -->
		<h3>가져오기 실패한 파일 </h3>
		<h2>지원하지 않는 형식입니다.</h2>
		<ul></ul>
	</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
$(document).ready(function(){
    var contextPath = "${pageContext.request.contextPath}";
    var uploadResult = $(".uploadResult ul");
    var uploadFail = $(".uploadFail ul");
    var cloneObj = $(".uploadDiv").clone();
    
    function showUploadFile(uploadResults, tag){ //ajax success 부분에서 사용됨 
       str = "";
       $(uploadResults).each(function(i, obj){
          str += "<li>" + obj.fileName + "</li>";
       })
       $(tag).append(str); //html이 아니라 append하는 것은 덮어쓰는게 아니라 계속 밑에 추가하기 위해서임
    }
    
    function check(fileName, fileSize){
       var regex = new RegExp("(.*?)\.(exe|sh|zip|alz)$");
       var maxSize = 5242880; //5MB
       if(regex.test(fileName)){
          alert("업로드 할 수 없는 파일의 형식입니다.");
          return false;
       }
       if(fileSize > maxSize){
          alert("파일 사이즈 초과");
          return false;
       }
       return true;
    }
    
    $("#uploadBtn").on("click", function(){
       var formData = new FormData();
       var inputFile = $("input[name='uploadFile']");
       var files = inputFile[0].files;
       
       console.log(files);
       
       for(let i=0; i<files.length; i++){
          if(!check(files[i].name, files[i].size)){
             return false;
          }
          formData.append("uploadFile", files[i]);
       }
       
       $.ajax({
          url: contextPath + "/uploadAjaxAction",
          processData: false,
          contentType: false,
          data: formData,
          type: "post",
          dataType: "json", //다시 result로 받아질 데이터 타입
          success: function(result){
             console.log(result);
             showUploadFile(result.succeedList, uploadResult); //받은 데이터가 (result가 allfile이므로! succeedList로 접근해야한다. )
             if(result.failureList.length != 0 ) {
            	showUploadFile(result.failureList, uploadFail); //성공, 실패를 넣는것임 
               	$(".uploadFail").show(); 
             }else {
               	$(".uploadFail").hide(); 
            	 
             }
             $(".uploadDiv").html(cloneObj.html()); //초기화 하기 위해 
          }
       });
    });
 });

</script>
</html>