<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body background="${pageContext.request.contextPath}/images/Lords.jpg"
	style="text-align: center; background-size: cover">
	<h1>Login Page</h1>
	<center>
		<form action="loginpage" method="post">
			<table>
				<tr>
					<td><label>Enter Email:</label></td>
					<td><input type="email" name="email" /></td>
				</tr>
				<tr>
					<td><label>Enter Password:</label></td>
					<td><input type="password" name="password" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Submit" /></td>
				</tr>
			</table>
		</form>
	</center>
</body>
</html>
