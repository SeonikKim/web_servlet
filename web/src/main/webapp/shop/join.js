function frm_view(part){
	var sp = document.getElementById("corp");
	//style로 css 컨트롤 가능함.
	if(part == "C"){
		sp.style.display="block";
	}
	else{
		sp.style.display="none";
	}
}
//아이디 중복체크
function idchk(){
	if(frm.sid.value ==""){
		alert("아이디를 입력하세요.");
	}
	else{
		//Ajax 역할(backend와 통신)
		ajaxpost(frm.sid.value);
		
	}
}

//Ajax함수를 이용하여 중복체크
var ok =""; // backend에 통신을 보내는 역할을 하는 변수
function ajaxpost(data){
//	console.log(data);
	
	function wck(){
		//window.XMLHttpRequest : 현재 페이지에서 XHR 통신을 사용함
		if(window.XMLHttpRequest){ //(XHR통신)
			return new XMLHttpRequest();
		}
	}
	function getdata(){
		/*
		XMLHttpRequest.UNSENT(0) : 객체를 생성(new XMLHttpRequest())
		XMLHttpRequest.OPENED(1) : XHR 통신 연결(open())
		XMLHttpRequest.HEADERS_RECIVED(2) : Back-end URL 및 통신규격(post, get)
		XMLHttpRequest.LOADING(3) : Back-end 경로 응답대기 시간
		XMLHttpRequest.DONE(4) : Back-end가 요청한 데이터 처리 완료 결과값을 보낸 경우
		
		status : 통신에 대한 결과 코드 번호(200 : 성공, 405 : BE쪽 오류, 404 : URL경로 오류)
		
		*/
//		if(ok.readyState==4 && ok.status==200){ //아래 코드와 동일한거임
		if(ok.readyState==XMLHttpRequest.DONE && ok.status==200){
			if(this.response =="ok"){
				alert("사용 가능한 아이디입니다.");
				frm.sid.readOnly = true; //아이디를 더 이상 수정하지 못하게 읽기전용으로 변경
				document.getElementById("idck").value ="ok";
				
			}
			else if(this.response =="no"){
				alert("해당 아이디는 이미 사용중 입니다.");
				frm.sid.value="";
			}
//			console.log(this.response); //backend 결과값 받음)		
		}
	}
	
	//순서에 맞게 통신을 실행함
	ok = wck(); //신규 XHR 생성
	ok.onreadystatechange = getdata; //해당 함수 결과를 받는 설정
	//Ajax 통신규약 : POST, GET, PUT, DELETE
	//ok.open("통신규약","BE경로",true : 비동기 통신(def값임), false : 동기 통신)
	//async : 비동기 통신,  sync : 동기 통신
	//비동기 통신 : 여러 데이터를 지속적으로 적송할 수 있으며, 결과값을 따로 받을 수 있음
	//동기 통신 : 순차적으로 처리, 1:1 => Form통신
	ok.open("GET","./idcheck.do?sid="+data,true); // 해당 값을 이관
	ok.send(); // Ajax 통신 실행

}

function memberok() {//회원가입 버튼
	if (frm.sid.value == "") {
		alert("아이디를 입력 후 중복체크를 하세요.");
	}
	else if (frm.spw.value == "") {
		alert("비밀번호를 입력 하세요.");
	}
	else if (frm.snm.value == "") {
		alert("이름 및 회사명을 입력 하세요.");
	}
	else if (frm.stel.value == "") {
		alert("연락처를 입력 하세요.");
	}
	else if (frm.semail.value == "") {
		alert("이메일을 입력 하세요.");
	}
	else {
		if (frm.spart[0].checked == true) { // 일반회원
			if(document.getElementById("idck").value ==""){
				alert("아이디 중복 체크를 하셔야 회원 가입이 가능합니다.");
				
			}else{
				frm.submit();
			}
		}
		else {//사업자회원
			if (frm.sno.value == "") {
				alert("사업자 번호를 입력하세요.");
			}
			else if(frm.sno.value.length<10){
				alert("올바른 사업자번호를 입력하세요.");
			}
			else{
				frm.submit();
			}
		}
	}
}
