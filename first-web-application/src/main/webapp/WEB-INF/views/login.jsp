<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
<title>Yahoo!!</title>
</head>
<body>
My First JSP!!! My name is ${name}

<form action="/login.do" method="post">
<input type="text" name="username" />
<input type="password" name="password">
<input type="submit">
</form>
</body>
</html>