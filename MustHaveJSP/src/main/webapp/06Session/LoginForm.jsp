<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="membership.MemberDTO" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Session</title>
</head>
<body>
	<jsp:include page="../Common/Link.jsp" />
	<h2>로그인 페이지</h2>
	<span style="color: red; font-size:1.2em;">
		<%= request.getAttribute("LoginErrMsg") == null ? "" : request.getAttribute("LoginErrMsg") %>
	</span>
	<%
	if (session.getAttribute("member") == null){ // 로그인 상태 확인
		// 로그아웃 상태
	%>
	<script>
	function validateForm(form){
		if (!form.user_id.value){
			alert("id를 입력하세요.");
			form.user_id.focus();
			return false;
		}
		if (!form.user_pw.value){
			alert("password를 입력하세요.");
			form.user_pw.focus();
			return false;
		}
	}
	</script>
	<form action="LoginProcess.jsp" method="post" name="LoginForm" onsubmit="return validateForm(this)">
	id: <input type="text" name="user_id" /><br/>
	password: <input type="text" name="user_pw" /><br/>
	<input type="submit" value="로그인하기" />
	</form>
	<%
	} else { // login 상태
		MemberDTO m = (MemberDTO)session.getAttribute("member");
	%>
		[ UserName : <%= m.getName() %> ]<br/>
		<%= session.getAttribute("UserName") %> 회원님 로그인 되었습니다.<br/>
		<a href="Logout.jsp">[로그아웃]</a>
	<%
	}
	%>
</body>
</html>