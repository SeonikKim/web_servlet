<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession hs = request.getSession();
// hs.removeAttribute(name); // 특정 부분만 삭제
hs.invalidate();//세션 전부 다 날림
out.print("<script>alert('로그아웃 되셨습니다.');location.href='./login.jsp';</script>");
%>