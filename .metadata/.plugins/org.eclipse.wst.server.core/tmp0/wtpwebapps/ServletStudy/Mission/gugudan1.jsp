<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String param = request.getParameter("dan");
int dan = 2;
if (param != null){
	dan = Integer.parseInt(param);
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>구구단</title>
</head>
<body>
<%
String str = "";
for (int i = 1; i < 10; i++){
	str += dan + " * " + i + " = " + dan * i + "<br /><br />";
}
%>
	<h2><%= dan %>단</h2>
	<ul>
	<%= str %>
	</ul>
</body>
</html>