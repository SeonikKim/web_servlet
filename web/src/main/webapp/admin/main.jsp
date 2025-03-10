<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<header>
<jsp:include page="./top.jsp" flush="true"></jsp:include> <!-- do는 안됩니다잉~ -->
</header>
<section>
<%@include file="./product.jsp"%>
</section>
<footer>
<jsp:include page="./copyright.jsp" flush="true"></jsp:include>

<%-- <%@include file="./copyright.jsp"%> --%>
</footer>
</body>
</html>