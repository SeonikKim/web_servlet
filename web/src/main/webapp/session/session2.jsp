<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

//Controller에서 Session을 받은 후 해당 세션 값을 문자열로 변환 후 HTML에 출력.
HttpSession se =  (HttpSession)request.getAttribute("se");
String userid = (String)se.getAttribute("id");
String username = (String)se.getAttribute("name");
String usertel = (String)se.getAttribute("tel");//이렇게 하면 null값 출력
// String usertel = se.getAttribute("tel").toString(); // 이렇게 하면 500번 에러 
if(userid==(null)){// if문 조건 잘 확인해야함 .. 아니면 여기서 오류 남 .. 
	out.print("<script>alert('로그인 하셔야만 됩니다.'); location.href=('./login.html');</script>");
}


%>s
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 정보 출력</title>
</head>
<body>
<%=username %>님 환영합니다.
<input type="button" value="로그아웃" onclick="logout()"><br>
아이디 : <%=userid %><br>
연락처 : <%=usertel %><br>

</body>
<script>
	function logout() {
		if (confirm("로그아웃 하시겠습니까?")) {
			location.href = "./session3.do"
		}
	}
</script>
</html>