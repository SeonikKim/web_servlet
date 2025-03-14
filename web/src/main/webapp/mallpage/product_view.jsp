<%@page import="mallpage.dto_product"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<script>
<!-- JSP -> JS -> HTML 순으로 작동 -->
	function errmsg() {
		alert("해당 상품의 정보가 올바르지않습니다.");
		location.href='./product_list.do';
	}
</script>

<%
dto_product pd = (dto_product) request.getAttribute("dto");//dto로 받기
// out.print(pd.getPnm());
if (pd.getMidx() == 0) {
	out.print("<script>errmsg();</script>");
}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 상세 페이지</title>
</head>
<body>
	<!-- DTO getter 메서드로 출력 -->
	<img src=".<%=pd.getPimg()%>">
	<br> 상품명 :
	<%=pd.getPnm()%><br> 상품 가격 :
	<%=pd.getPmoney()%><br> 할인율 :
	<%=pd.getPsales()%><br> 할인 가격 :
	<%=pd.getPsmoney()%><br>
	<input type="button" value="목록"
		onclick="location.href='./product_list.do'">

</body>
</html>