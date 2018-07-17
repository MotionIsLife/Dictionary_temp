<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<html>
<head></head>

<body>
	<form name='f' action="/j_spring_security_check" method='POST'>
		<table>
			<tr>
				<td>Имя пользователя:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Пароль:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td><input name="submit" type="submit" value="submit" /></td>
			</tr>
		</table>
	</form>
</body>
</html>