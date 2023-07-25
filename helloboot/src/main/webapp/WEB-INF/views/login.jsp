<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Log in</title>
</head>
<body>
	<h2>Log in</h2>
	<form action="${pageContext.request.contextPath }/login.do" method="post">
		<input type="text" name="userId">
		<input type="password" name="pw">
		<input type="submit" value="로그인">
	</form>
</body>
</html>