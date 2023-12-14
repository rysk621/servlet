<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>insert board form</title>
</head>
<body>
	<h2>Fill in the blanks to INSERT</h2>
	<script>
		function validateForm(form){
			if (!form.id.value || !form.pass.value || !form.name.value){
				alert("Fill in the blanks.")
				return false;
			}
		}
	</script>
	<form method="post" action="InsertBoardProcess.jsp" name="InsertBoardForm" onsubmit="return validateForm(this)">
		id: <input type="text" name="id" placeholder="id" /><br/>
		pass: <input type="password" name="pass" placeholder="password" /><br/>
		name: <input type="text" name="name" placeholder="name" /><br/>
		<input type="submit" value="insert" />
	</form>
</body>
</html>