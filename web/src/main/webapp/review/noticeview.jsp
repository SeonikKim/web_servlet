<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판 내용 확인</title>
<style>
.n{
width: 500px;
height: 300px;
border: 1px solid #000;
overflow-y:auto;

}
</style>
</head>
<body>
제목 : <%= request.getAttribute("subject") %> <br>
글쓴이 : <%= request.getAttribute("writer") %><br>
내용: 
<div class="n">
<%= request.getAttribute("wtext") %><br>
</div>
</body>
</html>