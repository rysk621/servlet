<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cookie</title>
</head>
<body>
	<h2>1. Cookie setting</h2>
	<%
	Cookie cookie = new Cookie("myCookie","쿠키맛나요");
	cookie.setPath(request.getContextPath());
	cookie.setMaxAge(3600);
	response.addCookie(cookie);
	%>
	<h2>2. 설정 후 쿠키값 확인하기</h2>
	<%
	Cookie[] cookies = request.getCookies();
	if (cookies != null){
		for (Cookie c : cookies){
			String cookieName = c.getName(); // 쿠키 이름 얻기
			String cookieValue = c.getValue(); // 쿠키 값 얻기
			out.println(String.format("%s : %s<br />", cookieName, cookieValue)); // 출력
		}
	}
	%>
	
	<h2>3. 페이지 이동 후 쿠키값 확인하기</h2>
	<a href="CookieResult.jsp">
		다음 페이지에서 쿠키값 확인하기
	</a>
</body>
</html>