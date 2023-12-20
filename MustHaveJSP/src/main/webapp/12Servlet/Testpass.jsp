<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Testpass</title>
</head>

<body>
<h2>점수 입력</h2>
<form method="post" action="Testpass">
국어<input type="text" name="kor" value="${ kor }" /><br/>
영어<input type="text" name="eng" value="${ eng }"/><br/>
수학<input type="text" name="math" value="${ math }"/><br/>
<input type="submit" value="제출" /><br/>
</form>
${ result }<br/>
총합 : ${ sum }<br/>
평균 : ${ avg }
</body>
</html>