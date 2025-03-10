<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    ArrayList<String> resArr = (ArrayList)request.getAttribute("ar");
    
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매 확인</title>
</head>
<body>et
영화 예매 확인
<p>고객명 : <%=resArr.get(0) %><br></p>
<p>연락처 : <%=resArr.get(1) %><br></p>
<p>영화선택 : <%=resArr.get(2) %><br></p>
<p>예매일자 : <%=resArr.get(3) %><br></p>




<input type="button" value="확인" onclick="onon()" style="background: #156082;color: #fff">


</body>
<script>
function onon() {
	location.href="movie.html";
}
</script>
</html>