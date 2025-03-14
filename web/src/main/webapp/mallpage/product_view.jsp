<%@page import="mallpage.dto_product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
dto_product pd = (dto_product)request.getAttribute("dto");
// out.print(pd.getPnm());

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
<img src=".<%=pd.getPimg()%>"><br>
상품명 : <%=pd.getPnm()%><br>
상품 가격 : <%=pd.getPmoney()%><br>
할인율 : <%=pd.getPsales()%><br>
할인 가격 : <%=pd.getPsmoney() %><br>
<input type="button" value="목록" onclick="location.href='./product_list.do'">

</body>
</html>