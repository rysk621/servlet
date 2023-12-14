<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 방법1. 속성 각각 삭제
session.removeAttribute("UserId");
session.removeAttribute("UserName");
// 방법2. 모든 속성 한번에 삭제
session.invalidate();


// 속성 삭제 후 페이지는 LoginForm.jsp로 다시 이동
response.sendRedirect("LoginForm.jsp");
%>