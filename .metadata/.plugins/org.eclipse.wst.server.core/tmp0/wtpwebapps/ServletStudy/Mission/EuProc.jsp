<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>유클리드 호제법 - use process</title>
</head>
<body>
<%
String sNum1 = request.getParameter("num1");
String sNum2 = request.getParameter("num2");
if (sNum1 == null || sNum2 == null || sNum1 == "" || sNum2 == ""){
	response.sendRedirect("Eu.jsp");
	return;
}

int num1 = Integer.parseInt(sNum1);
int num2 = Integer.parseInt(sNum2);

int lcm, gcd = 1;

// 알고리즘 만들기
int max = (num1 > num2) ? num1 : num2;
int min = (num1 < num2) ? num1 : num2;

int rem = max % min;
while (rem != 0) {
	max = min;
	min = rem;
 	rem = max % min;
}

gcd = min;
lcm = num1 * num2 / gcd;
%>

최대공약수: <%= gcd %><br/>
최소공배수: <%= lcm %><br/>
<a href="Eu.jsp">홈으로</a>
</body>
</html>