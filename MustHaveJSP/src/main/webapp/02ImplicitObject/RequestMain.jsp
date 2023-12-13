<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - request</title>
</head>
<body>
	<h2>1. 클라이언트와 서버의 환경정보 읽기</h2>
	<a href="./RequestWebInfo.jsp?eng=Hello&han=안녕">Get 방식 전송</a>
	<!-- get 방식: 주소 전체 전송, 브라우저 좌하단에 주소 나타남, query string 주소창에 출력됨 -->
	<br />
	<form action="RequestWebInfo.jsp" method="post"> <!-- post 방식: query string은 null. -->
		영어 : <input type="text" name="eng" value="Bye" /><br />
		한글 : <input type="text" name="han" value="잘 가" /><br />
		<input type="submit" value="post 방식 전송" />
	</form>

	<h2>2. 클라이언트의 요청 매개변수 읽기</h2>
	<form method="post" action="RequestParameter.jsp">
		아이디 : <input type="text" name="id" value="" /> <br />
		성별 : <input type="radio" name="sex" value="man" />남자
		<input type="radio" name="sex" value="woman" />여자 <br />
		관심사항 : <input type="checkbox" name="favo" value="eco" />경제
		<input type="checkbox" name="favo" value="pol" checked="checked" />정치
		<input type="checkbox" name="favo" value="ent" />연예 <br />
		자기소개 : <textarea name="intro" cols="30" rows="4"></textarea> <br />
		<input type="submit" value="전송하기" />
	</form>

	<h2>3. HTTP 요청 헤더 정보 읽기</h2>
	<a href="RequestHeader.jsp">요청 헤더 정보 읽기</a>

</body>
</html>