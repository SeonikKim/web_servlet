function ajax_file(){
	var mfile= document.getElementById("mfile");
	if(mfile.value==""){
		alert("파일 첨부 필수~");
	}else{
		this.ajax_post(mfile);
	}
}

//ajax I/O 파일 전송
function ajax_post(mfile){
	var http,result;
	var formdata = new FormData();//데이터 전송할 때사용함, form형태의 태그를 사용하는것과 동일
	formdata.append("mfile",mfile.files[0]);//배열 기준으로 파일을 처리함.
	http= new XMLHttpRequest();
	http.onreadystatechange=function(){
		if(http.readyState==4&&http.status==200){
		console.log(this.response);
			
		}
	}
	//post 전송
	http.open("POST","./ajax_fileok.do",true);
//	http.setRequestHeader("content-type","multipart/form-data");// 파일전송에는 안씀 ..
	http.send(formdata); // form데이터 함수의 값을 send에 태워서 전송
	
}