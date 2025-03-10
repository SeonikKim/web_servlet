<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
//     String word = (String)request.getAttribute("abc");//null, ""
//     String word2 = request.getAttribute("abc").toString();//""
//     String word3 = String.valueOf(request.getAttribute("abc"));//null,""
// out.print(word);
// out.print(word2);
// out.print(word3);
    String word = (String)request.getAttribute("subject");//null, ""
    String[] etc = (String[])request.getAttribute("etc");//받을때도 배열로 받아야함
    out.print(etc);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>설문조사 결과값</title>
</head>
<body>
선택하신 과목 : <%=word %><br>
배우고 싶은 과목 : <%
for(String sub:etc){ //Controller에서 원시배열로 값을 이관받은 데이터를 반복문으로 view에서 처리
	out.print(sub + " ");
}

%>
</body>
</html>