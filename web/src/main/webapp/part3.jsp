<%@page import="javax.print.DocFlavor.STRING"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mid =  (String)request.getAttribute("mid");
    String mname = (String)request.getAttribute("mname");
    String mmail = (String)request.getAttribute("mmail");
    String mtel = (String)request.getAttribute("mtel");
    String image = (String) request.getAttribute("image");
    
    //length : 원시배열, length() : 문자열 길이, size() : 클래스 배열

	if (mtel.length() == 11) {
		mtel = mtel.substring(0, 3) + "****" + mtel.substring(7, mtel.length());
	} else {
		mtel = mtel.substring(0, 3) + "***" + mtel.substring(6, mtel.length());
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입 완료 페이지</title>
</head>
<body>
<p>회원가입이 완료되었습니다.</p>
아이디 : <%=mid %><br>
고객명 : <%=mname %><br>
이메일 : <%=mmail %><br>
연락처 : <%=mtel %><br>
<%
if(image!=""){

%>
<img src="./user/<%=image%>">	
<%
}%>
</body>
</html>