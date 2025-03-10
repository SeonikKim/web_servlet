function loginck(){
	if(frm.sid.value==""){
		alert("아이디를 입력하세요.");
		return false;
	}
	else if(frm.spw.value==""){
		alert("비밀번호를 입력하세요.");
		return false;
	}
	else{
		if(frm.spart[0].checked==true){//일반회원
		return true;	
		}
		else if(frm.spart[1].checked==true){//사업자회원 체크 사실 else로 빼도 되는데 까먹지 말라고 씀 
			if (frm.sno.value == "") {
				alert("사업자번호를 입력하세요.");
				return false;
			}
			else if (frm.sno.length < 10) {
				alert("올바른 사업자번호를 입력하세요.");
				return false;
			}
			else{
				return true;
			}

		}
	}
	
}
function partcheck(data){
	var snoview = document.getElementById("snoview");
	if(data == "P"){
		snoview.style.display = "none";
	}else{
		snoview.style.display = "block";		
	} 
}