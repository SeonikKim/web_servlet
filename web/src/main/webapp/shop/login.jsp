<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    HttpSession hs = request.getSession();
    String mid = (String)hs.getAttribute("mid");
    String mnm = (String)hs.getAttribute("mnm");
    if(mid !=null || mnm != null){//로그인이 되어있을 경우 다시 로그인 못하게 처리
    	out.print("<script>alert('이미 로그인하셨습니다.'); location.href='./main.jsp';</script>"); //이미 로그인 했으면 메인으로 이동시키기 ~ 
    	
    }
    %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
<form id="frm" action="./shop_loginok.do" method="post" onsubmit="return loginck()">
<p>[회원 로그인]</p>
<div>
<label>
<input type="radio" value="P" checked="checked" name="spart" onclick="partcheck(this.value)">일반회원
</label>

<label>
<input type="radio" value="C" name="spart" onclick="partcheck(this.value)">사업자회원
</label><br>


<input type="text" placeholder="아이디를 입력하세요" name="sid"><br>
<input type="password" placeholder="패스워드를 입력하세요" name="spw"><br>
<span style="display: none" id="snoview">
<input type="text" placeholder="사업자 등록번호 -제외" name="sno" maxlength="13"><br>
</span>
<input type="submit" value="로그인">
</div>
</form>
</body>
<script src="./login.js?v=1"></script>
</html>