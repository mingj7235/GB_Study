<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload - Ajax</title>
<style>
	.uploadResult {
		width : 100%;
		
	}
	
	.uploadResult ul {
		display : flex;
		justify-content: center; 
	}
	
	.uploadResult ul li {
		list-style: none;
		padding : 10px;
	}
</style>
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
	    									  //성공할지, 실패할지를 tag를 사용하는 쪽에서 가지고와서 꽂아줌 	
	    function showUploadFile(uploadResults, tag){ //ajax success 부분에서 사용됨 
	       str = "";
	       $(uploadResults).each(function(i, obj){ //obj는 각각의 파일정보
	    	  if(!obj.image) { //attachFileDTO의 속성중 boolean 타입의 image
	    		  
	    		  var fileCallPath = encodeURIComponent(obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName);
	    		  
	    	  		console.log(fileCallPath);
	    		  					//module에 있는 루트 경로 upload
	    		  							//파일이 다운로드!!! 된드아아아!! 즉, 이미지가 아닐경우는 다운로드! 
	    		  str += "<li><a href='/upload/download?fileName=" + fileCallPath +"'><img src='/upload/resources/img/attach.png'>" + obj.fileName + "</a></li>"; //이미지가 아닐경우 디폴트 이미지를 넣을 것
	    	  } else {
	    		  //썸네일의 파일 경로를 가져옴
	    		  //그런데 url 인코딩이 필요하다. (encodeURIComponenent 사용할것 ) 
	    		  //encodeURIComponent("문자열") : get방식으로 전송시 파라미터로 전달할 때, 값에 인식할 수 없는 문자가 있을 경우 쿼리 스트링 문법에 맞게 변경해야 한다.
	    		  //이 때사용하는메소드이다. 
	    		  var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName);
					
	    		  //컨트롤러에 display로 요청하여 매핑. get방식이므로 fileName에 fileCallPath를 전달한다. 
	    		  str += "<li><img src='/upload/display?fileName=" + fileCallPath + "'>" + obj.fileName + "</li>";
	    	  }
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