<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>JSTL - forTokens</title>
</head>
<body>
	<%
	String rgba = "Red,Green,Blue,Black";
	String[] rgbaA = rgba.split(",");
	request.setAttribute("rgbaEL", rgba);
	%>
	<h4>JSTL forTokens tags</h4>
	<c:forTokens items="<%= rgba %>" delims="," var="color">
		<span style="color:${ color };">${ color }</span><br/>
	</c:forTokens>
	<c:forEach items="${ rgbaEL }" var="color">
		<span style="color:${ color };">${ color }</span><br/>
	</c:forEach>
</body>
</html>