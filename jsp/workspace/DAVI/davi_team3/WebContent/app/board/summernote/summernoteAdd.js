/*
 * 서머노트  함수
 */
//내용에 텍스트 입력
function insertContent(content) {	
	$('#summernote').summernote('insertText', content);
}

//텍스트영역 리셋
function textReset() {	
	$('#summernote').summernote('reset');
	console.log(456);
}

//택스트창 비활성
function writeDisable() {
	$('#summernote').summernote('disable');
	return true;
}

//택스트창 활성
function writeAble() {
	$('#summernote').summernote('enable');
}
