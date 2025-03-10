var info_ok = function(){
	var mail1 = document.getElementById("mail1");
	var mail2 = document.getElementById("mail2");
	var tel1= document.getElementById("tel1");
	var tel2= document.getElementById("tel2");
	var tel3= document.getElementById("tel3");
	if(frm.mname.value==""){
		alert("고객명을 입력해주세요.");
	}
	else if(mail1.value==""||mail2.value==""){
		alert("이메일을 모두 입력해주세요.");
	}
	
	else if(tel1.value==""||tel2.value==""||tel3.value==""){
		alert("전화번호를 모두 입력해주세요.")
	}
	else{
		frm.memail.value= mail1.value+"@"+mail2.value;
		frm.mtel.value = tel1.value+tel2.value+tel3.value;
		frm.submit();
	
	}
	
	
}