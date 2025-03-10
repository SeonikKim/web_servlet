<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 정보 입력</title>
</head>
<body>
	<form  id="signup" method="post" action="http://172.30.1.95:8080/web/signupok.do" enctype="multipart/form-data">
		회원가입 정보 입력[간편가입]<br>
		아이디 : <input type="text" name="mid" required="required" pattern="^[a-zA-Z0-9._-가-힣]$"><br> 
		고객명 : <input type="text" name="mname" required="required"><br>
		비밀번호 : <input type="password" name="mpass" required="required"><br> 
		이메일 : <input type="text" pattern="^[a-zA-Z0-9._-가-힣]+@[a-zA-Z0-9.-가-힣]+\.[a-zA-Z가-힣]{2,}$" name="memail" required="required"><br>
		휴대폰 번호 : <input type="text" name="mtelno" maxlength="11" pattern="^01[0-9]\d{3,4}\d{4}$" required="required"><br>
		이미지 : <input type="file" name="mfile" required="required"><br>
		<button onclick="signup2()" value="가입완료">가입완료</button>
	</form>
</body>
<script>
	function signup2() {
		var file = document.getElementsByName("mfile")[0].files;
		if (file.length > 1) {
			alert("첨부파일 갯수는 최대 1개 까지입니다.");
		} else {
			var w = 0;
			count = 0;
			while (w < file.length) {//첨부파일 갯수만큼 반복문을 작동시켜 파일 각각의 용량 체크
				var size = file[w].size;
				console.log(size);
				if (size > 2097152) {
					count++;
				}
				w++;
			}
			//반복문으로 2MB이상의 파일이 있는 경우 확인
			if (count != 0) {
				alert("첨부파일 용량이 2MB 이상입니다.");
			} else {
				signup.submit();

			}
		}
	}
</script>
</html>