function send() {
	if(frm.to_name.value==""){
		alert("담당자 성함을 입력하세요")
	}
	else if(frm.to_mail.value==""){
		alert("회신받을 메일주소를 입력하세요")
	}
	else if(frm.subject.value==""){
		alert("제목을 입력하세요")
	}
	else if(frm.context.value==""){
		alert("내용을 입력하세요")
	}
	else{
		frm.submit();
	}
	
}