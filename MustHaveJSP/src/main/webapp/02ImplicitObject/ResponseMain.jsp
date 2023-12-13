<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - response</title>
</head>
<body>
	<h2>1. login form</h2>
	<%
	String loginErr = request.getParameter("loginErr");
	if (loginErr != null) out.print("로그인 실패");
	else out.print("로그인 정보를 입력하세요.");
	%>
	<form action="./ResponseLogin.jsp" method="post"> <!-- 로그인 정보는 post로 해야 한다(url에 노출되지 않도록) -->
		id: <input type="text" name="user_id" /><br />
		pwd: <input type="password" name="user_pwd" /><br />
		<input type="submit" value="로그인" />
	</form>
	
	<h2>2. HTTP response header setting</h2>
	<form action="./ResponseHeader.jsp" method="get">
		날짜 형식: <input type="text" name="add_date" value="2023-12-11 12:00" /><br />
		숫자 형식: <input type="text" name="add_int" value="9292" /><br />
		문자 형식: <input type="text" name="add_str" value="홍길동" /><br />
		<input type="submit" value="response header setting & printing" >
	</form>
</body>
</html>