<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	ArrayList<ArrayList<String>> notice = (ArrayList<ArrayList<String>>) request.getAttribute("result");
	%>
<!--   VIEW    -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> 현재 등록된 게시물 : <%=notice.size() %></p>
	<table border="1" cellpadding="0" cellspacing="0">
		<thead>
			<tr>
				<th width="50">번호</th>
				<th width="500">제목</th>
				<th width="100">글쓴이</th>
				<th width="100">조회</th>
				<th width="150">등록일</th>
			</tr>
		</thead>
		<%
		int total = notice.size(); //번호 출력용 // 야매로 한거임
		for(int f = 0; f<notice.size(); f++){
		%>
		<tbody>
			<tr height="30" align="center">
				<td><%=total %></td>
				<td align="left" onclick="notice_view(<%=notice.get(f).get(0)%>)"><%=notice.get(f).get(1) %></td>
				<td><%=notice.get(f).get(2) %></td>
				<td><%=notice.get(f).get(3) %></td>
				<td><%=notice.get(f).get(4).substring(0,10) %></td>
			</tr>
			<% total--;} %>
		</tbody>
		
	</table>
</body>
<script> 
function notice_view(no){ // 해당 게시물 onclick 이벤트로 받아서 페이지 이동(nidx 사용)
	location.href='./notice_view.do?nidx='+no;
}
</script>
</html>