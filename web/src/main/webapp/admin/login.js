function login(){
	if(frm.adm_id.value==""){
		alert("아이디를 입력하세요");
	}
	else if(frm.adm_pw.value==""){
		alert("비밀번호를 입력하세요");
	}
	else if(frm.adm_no.value==""){
		alert("사번을 입력하세요");
	}
	else{
//		location.href : get 방식
//		btoa : base64 암호화
		var id = btoa(frm.adm_id.value);
		var pw = btoa(frm.adm_pw.value);
		var no = btoa(frm.adm_no.value);
		location.href="./adminok.do?adm_id="+id+"&adm_pw="+pw+"&adm_no="+no;//이렇게 get 통신 가능

//		frm.method = "get";	
//		frm.action="./adminok.do";
//		frm.enctype="";//이거도 가능함
//		frm.submit();
		
	}
	
}