<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
	<form method="post" action="gugudanMain.jsp">
		<input type="radio" name="sel" value="gugu1" />type 1
		<input type="radio" name="sel" value="gugu2" />type 2 <br />
		<input type="text" name="val" value="2" /> 단 수 or 열 수 <br />
		<input type="submit" value="선택" />
	</form>
</body>
</html>