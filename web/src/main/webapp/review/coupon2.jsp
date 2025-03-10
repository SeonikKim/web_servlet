<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String uid = (String)request.getAttribute("uid");
    String cpnum = (String)request.getAttribute("cpnum");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쿠폰 등록 완료 페이지</title>
</head>
<body>
쿠폰 등록 완료 페이지<br>
아이디 : <%= uid%><br>
쿠폰번호 : <%= cpnum%><br>
광고 수신 동의함<br>
</body>
</html>