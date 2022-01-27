<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<h2>Login to continue</h2>
	
	<h5>${errorMsg}</h5>
	<form action="verifyLogin" method="post">
		<table>
			<tr>
				<td>Email</td>
				<td><input type="email" name="email" required></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" required></td>
			</tr>	
			<tr>
				<td><input type="submit" value="LOGIN"></td>
			</tr>
		</table>
	</form>
	
	
</body>
</html>