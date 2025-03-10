//게시물 등록 시 체크 하는 함수
function writeck() {
	if (frm.subject.value == "") {
		alert("제목을 입력하세요!");
		frm.subject.focus();
	} else if (frm.writer.value == "") {
		alert("글쓴이를 입력하세요!");
		frm.writer.focus();
	} else if (frm.pw.value == "") {
		alert("비밀번호를 입력하세요!");
		frm.pw.focus();
	} else {
		//CKEDITOR.instances.html id이름.getData() getter역할 : ckeditor를 로드
		var txt = CKEDITOR.instances.editor.getData();
		//		console.log(txt);
		if (txt == "") {
			alert("내용을 입력하세요!");
		}
//		else if(txt.length<40){
//			alert("최소 40자 이상 입력하세요!");
//		}
		
		else{
			frm.submit();
		}
	}


}