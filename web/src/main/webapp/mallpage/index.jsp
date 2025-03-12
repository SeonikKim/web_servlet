<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
    String test="홍길동";
    %>
<!DOCTYPE html>
<html lang="ko">
<head>
<title>Shop Bag</title>
<meta charset="utf-8" />
<link href="./index.css" rel="stylesheet" />
<link href="./menu.css?v=1" rel="stylesheet" />
</head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 상단 로고 & 메뉴 -->
	<%@ include file="./top.jsp"%>
	<!-- 상단 로고 & 메뉴 -->
	
	<main>
	
		<!--  배너 -->
	<%@ include file="./banner.jsp"%>
		<!--  배너 -->
		
		<!--     상품리스트 -->
	<%@ include file="./product.jsp"%>
		<!--     상품리스트 -->
	</main>
	
	<!-- 푸터 -->
	<footer>
	<%@ include file="./footer.jsp"%>
	</footer>
	<!-- 푸터 -->
	
</body>
</html>