<%@ page import="java.util.Collection" %>
<%@ page import="java.text.SimpleDateFormat" %>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
SimpleDateFormat s = new SimpleDateFormat("yyyy-mm-dd HH:mm");
long add_date = s.parse(request.getParameter("add_date")).getTime();
int add_int = Integer.parseInt(request.getParameter("add_int"));
String add_str = request.getParameter("add_str");

response.addDateHeader("myBirthday", add_date);
response.addIntHeader("myNumber", add_int);
response.addIntHeader("myNumber", 1004);
response.addHeader("myName", add_str);
response.setHeader("myName", "안중근");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>내장 객체 - response</title>
</head>
<body>
	<h2>response header information output</h2>
	<%
	Collection<String> headerNames = response.getHeaderNames();
	for (String hName : headerNames){
		String hValue = response.getHeader(hName);
	}
	%>
</body>
</html>