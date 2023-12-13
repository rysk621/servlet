<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>쿠키값 확인하기(쿠키 생성 이후의 페이지)</h2>
	<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null){
		for (Cookie c : cookies){
			String cookieName = c.getName(); // 쿠키 이름 얻기
			String cookieValue = c.getValue(); // 쿠키 값 얻기
			out.println(String.format("쿠키명: %s - 쿠키값 : %s<br />", cookieName, cookieValue)); // 출력
		}
	}
	%>
</body>
</html>