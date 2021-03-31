/*
 * 서머노트 로딩과 기본 설정
 */

	

function summernoteStart() {
	$('#summernote').summernote({		  
		  height: '400',                 // 에디터 높이				  
		  minHeight: 200,             // 최소 높이
		  maxHeight: 500,             // 최대 높이				  
		  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
		  lang: "ko-KR",					// 한글 설정
		  placeholder: '최대 2048자까지 쓸 수 있습니다',	//placeholder 설정				  
		  toolbar: [
			    //[groupName, [list of button]],
			    ['fontname', ['fontname']],
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline','strikethrough', 'clear']],
			    ['color', ['forecolor','color']],
			    ['table', ['table']],
			    ['para', ['ul', 'ol', 'paragraph']],
			    ['height', ['height']],
			    ['insert',['picture','link','video']]
			    //['view', ['fullscreen', 'help']]
			  ],
			fontNames: ['Arial', 'Arial Black', 'Comic Sans MS', 'Courier New','' ,'맑은 고딕','궁서','굴림체','굴림','돋움체','바탕체'],
			fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72']
        
	 });
}

function summernoteView() {
	$('#summernote').summernote({		
		  height: '100%',                 // 에디터 높이	  
		  minHeight: 200,             // 최소 높이
		  maxHeight: 500,             // 최대 높이
		  lang: "ko-KR",					// 한글 설정		  				  
		  toolbar: [ ]       
	 });	
}

