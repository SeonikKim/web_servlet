function ajaxs() { //전송 버튼 클릭 시 이벤트
	var mid = document.getElementById("mid");
	var memail = document.getElementById("memail");
	if (mid.value == "") {
		alert("아이디를 입력하세요");
	}
	else if (memail.value == "") {
		alert("이메일을 입력하세요");
	}
	 else {
		//ajax post 통신을 위한 함수 호출
		this.ajax_post(mid.value,memail.value);
	}
}
//Ajax POST 전송하는 함수
function ajax_post(mid,memail) {
	var http, result; //http: BE통신, result : BE제공한 데이터
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState==4 && http.status ==200){
			console.log(this.response);
		}else if(http.status==404){
			console.log("경로 오류 발생");
		}else if(http.status==405){
			console.log("통신 규격 오류 발생");
		}
	}
//	http.open("get","./ajax_postok.do="+mid,true);//get 통신
//	http.send();// get 방식

	http.open("post","./ajax_postok.do",true);
	//ajax post 전송 시 content-type을 적용하여 urlencode 적용해야지 값을 전송함
	//form에 들어가는 enctype을 setRequstHeader에 태워서 보내야함
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
//	http.send("userid="+mid);//한개 날릴 때
	http.send("userid="+mid+"&usermail="+memail);//2개 부터는 & 붙여서 날림	
	
}