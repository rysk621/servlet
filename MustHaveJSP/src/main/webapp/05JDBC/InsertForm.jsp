<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Form</title>
</head>
<body>
	<h2>Insert form</h2>
	<span style="color: red; font-size:1em;">
		<%= request.getAttribute("InsertErrMsg") == null ? "" : request.getAttribute("InsertErrMsg") %>
	</span>
	<script>
	function validateForm(form){
		if (!form.id.value){
			alert("insert id");
			return false;
		}
		if (!form.pass.value){
			alert("insert password");
			return false;
		}
		if (!form.name.value){
			alert("insert name");
			return false;
		}
	}
	</script>
	<form action="InsertProcess.jsp" method="post" name="InsertForm" onsubmit="return validateForm(this)">
	id: <input type="text" name="id" placeholder="id" /><br/>
	pass: <input type="password" name="pass" placeholder="password" /><br/>
	name: <input type="text" name="name" placeholder="name" /><br/>
	<input type="submit" value="insert" />
	</form>
</body>
</html>