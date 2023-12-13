<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String param = request.getParameter("col");
int col = 3;
if (param != null){
	col = Integer.parseInt(param);
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
String[] sList = new String[8];
for (int dan = 2; dan < 10; dan++){
	for (int i = 1; i < 10; i++){
		str += dan + " * " + i + " = " + dan * i + "<br />";
	}
	sList[dan-2] = "<td style=\"border: 1px solid gray\">" + str + "</td>";
	str = "";
}
%>
	<h2><%= 99 %>단</h2>
	<ul>
	<%
	out.println("<table><tr>");

	for (int i = 0; i < sList.length; i++){
		out.println(sList[i]);
		if ((i+1) % col == 0) out.println("</tr><tr>");
	}
	out.println("</tr></table>");
	%>
	</ul>
</body>
</html>