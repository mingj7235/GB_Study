<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>File Upload - Ajax</title>
<style>
.uploadResult {
	width: 100%;
}

.uploadResult ul {
	display: flex;
	justify-content: center;
}

.uploadResult ul li {
	list-style: none;
	padding: 10px;
}

.bigPicture {
	text-align: center;
}
</style>
</head>
<body>
	<h1>File Upload - Ajax</h1>
	<div class="uploadDiv">
		<input type="file" name="uploadFile" multiple>
	</div>

	<div class="uploadResult">
		<!-- 성공한 파일이 올라감  -->
		<h3>가져오기 성공한 파일</h3>
		<ul></ul>
	</div>

	<button id="uploadBtn">upload</button>

	<div class="bigPictureWrapper">
		<div class="bigPicture"></div>

	</div>



	<div class="uploadFail" style="display: none;">
		<!-- 실패한 파일이 올라감 -->
		<h3>가져오기 실패한 파일</h3>
		<h2>지원하지 않는 형식입니다.</h2>
		<ul></ul>
	</div>
</body>

<script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
	
	var check = false; //애니메이션이 실행중인지 체크하는 변수
	
	//이미지를 애니메이션을 크게만드는 
	function showImage (fileCallPath) {
		//alert(originPath);
		if (check) {return;}
		$(".bigPictureWrapper").css("display", "flex").show();
		
		$(".bigPicture").html("<img src='/upload/display?fileName="+ encodeURIComponent(fileCallPath) +"'>")
		.animate({width: "100%", height: "100%"}, 1000);
		check = true;
	}
	
    //애니메이션 : 사진을 확대 후에 다시 닫는 이벤트
	$(".bigPictureWrapper").on("click", function (e){
		//조건
		if(!check) {return;}
		$(".bigPicture").animate({width: "0%", height: "0%"}, 1000);
		setTimeout(function(){
			check = false;
			$(".bigPictureWrapper").hide();
		}, 1000);
	});


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
	    		  str += "<li><div><a href='/upload/download?fileName=" + fileCallPath +"'><img src='/upload/resources/img/attach.png'>" + obj.fileName + "</a>"; //이미지가 아닐경우 디폴트 이미지를 넣을 것
	    		  /*
	    		  	data속성은 Map구조로 DOM 객체에서 사용할 수 있다.
	    		  	<span data-key="value">
	    		    $("span").data("key") == "value" 이렇게 value값을 가져올 수 있는것이다.
	    		    
	    		    data-type 은 file로 주어서 일반 파일이라는것을 알려준다. type 이라는 키값을 또 사용해서 구분해주는 것이다.
	    		  */
	    		  str += "<span data-file='"+fileCallPath+"' data-type='file'>X</span></div></li>"; //data속성을 활용하는 것 file이라는 변수로 선언한것이다. 
	    		  
	    		  
	    	  } else {
	    		  //썸네일의 파일 경로를 가져옴
	    		  //그런데 url 인코딩이 필요하다. (encodeURIComponenent 사용할것 ) 
	    		  //encodeURIComponent("문자열") : get방식으로 전송시 파라미터로 전달할 때, 값에 인식할 수 없는 문자가 있을 경우 쿼리 스트링 문법에 맞게 변경해야 한다.
	    		  //이 때사용하는메소드이다. 
	    		  var fileCallPath = encodeURIComponent(obj.uploadPath + "/s_" + obj.uuid + "_" + obj.fileName); //썸네일 이미지
	    		  var originPath = obj.uploadPath + "/" + obj.uuid + "_" + obj.fileName;
				  originPath = originPath.replace(new RegExp(/\\/g), "/"); // \\대신에 / 를 넣겟다는 것임 	
	    		  //컨트롤러에 display로 요청하여 매핑. get방식이므로 fileName에 fileCallPath를 전달한다. 
	    		  // \를 사용하는 것은 '와 "를 사용하기 위함이다 
	    		  str += "<li><div><a href = \"javascript:showImage(\'"+ originPath +"\')\"><img src='/upload/display?fileName=" + fileCallPath + "'>" + obj.fileName + "</a>";
	    		  										//data-type을 image로 바꿔준다. 
	    		  str += "<span data-file='"+fileCallPath+"' data-type='image'>X</span></div></li>"; //data속성을 활용하는 것 file이라는 변수로 선언한것이다. 
	    	  }
	       })
	       $(tag).append(str); //html이 아니라 append하는 것은 덮어쓰는게 아니라 계속 밑에 추가하기 위해서임
	    }
	    									  
	    									  
	    //이벤트 위임을 사용한다. span 태그가 하나뿐이므로 이렇게 사용 가능
	    $(".uploadResult").on("click", "span", function (e) {
	    	
	    	//data 속성을 이렇게 가지고와서 활용한다. 
	    	var targetFile = $(this).data("file");
	    	var type = $(this).data("type");
	    	console.log(targetFile);
	    	
	    	//x버튼 눌렀을 때 
	    	$.ajax ({
	    		url : contextPath + "/deleteFile",
	    		data : {fileName : targetFile, type : type},
	    		dataType : "text", //default가 text 즉, success로 전달받을 데이터 result 의 타입, 근데 그냥 써줌 
	    		type : "post",
	    		success : function (result) {
	    			alert(result);
	    			//closest는 가장 가까운 태그를 찾아준다.
	    			$(this).parent().parent().remove();
	    		}
	    		
	    	})
	    })
	    									  
	    
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