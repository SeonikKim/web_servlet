<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%
	ArrayList<ArrayList<String>> notice = (ArrayList<ArrayList<String>>) request.getAttribute("result");
	//페이지 번호 생성
	/*
	페이지 생성 방법
	1. 한 페이지당 데이터를 몇개씩 출력할 것인지 설정.
	2. 출력할 데이터의 총 갯수 / 한 페이지당 출력할 데이터(소숫점으로 나옴)
	3. Math.ceil을 사용하여 올림처리 하여 페이지가 추가되도록 함.
	
	*/
	String total_page =  notice.get(0).get(5);
	int pg = 1;
	if(total_page!=null || !total_page.equals(null)){
// 		pg = (int)Math.ceil(Integer.parseInt(total_page) / 3) ; // ceil => 올림


		float pg2 = Integer.parseInt(total_page) / 3f ;//풀어쓰기 ver
		pg = (int)Math.ceil(pg2);
// 		out.print(pg);
	}
	String pno = request.getParameter("pageno");//최초 리스트 페이지에 접근 시 페이지 번호가 없을 수 있음 또는 페이지 번호 1을 클릭했을 경우
	if(pno == null || pno.equals("1")){
		pno="1";
	}
	out.print(pno);
	
	%>
<!--   VIEW    -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p> 현재 등록된 게시물 : <%=notice.get(0).get(5) %></p>
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
		//게시글 번호 : ㄴ 총 데이터 갯수 - ((페이지 번호 - 1 ) * 한 페이지 당 출력 갯수)
		int total = Integer.parseInt(total_page) - ((Integer.parseInt(pno) - 1) * 3);
		for (int f = 0; f < notice.size(); f++) {
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
		<table border="1">
		<tr>
		<%
		int w = 1;
		while (w<=pg){
			
		
		
		%>
		<td width="20" height="20" align="center"><a href="./notice_list.do?pageno=<%=w%>"> <%=w %></a></td>
		<%
		w++;
		}
		%>
		</tr>
		</table>
	</table>
</body>
<script> 
function notice_view(no){ // 해당 게시물 onclick 이벤트로 받아서 페이지 이동(nidx 사용)
	location.href='./notice_view.do?nidx='+no;
}
</script>
</html>