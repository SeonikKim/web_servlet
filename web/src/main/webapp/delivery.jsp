<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    //Controller에서 클래스 배열로 전달된 값을 클래스 배열로 받아 JSP에서 핸들링하기
    ArrayList<String> data = (ArrayList)request.getAttribute("data");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>배송정보 출력</title>
</head>
<body>
고객명 : <%=data.get(0) %><br>
이메일 : <%=data.get(1) %><br>
연락처 : <%=data.get(2) %><br>
주소 : <%=data.get(3) %><br>
</body>
</html>