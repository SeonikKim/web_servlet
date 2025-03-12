function loginck(){
	if(frm.mid.value==""){
		alert("아이디를 입력하세요");
		return false;
	}else if(frm.mpass.value==""){
		alert("비밀번호를 입력하세요");
		return false;
	}else{
		frm.submit();
	}
	
}