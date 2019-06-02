<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<html>
<head>
<title>Login Page</title>
</head>
<body>
    <form action="/add-todo" method="POST">
        Description : <input name="desc" type="text" /> 
        isDone:
        true: <input name="isDone" type="radio" value="true"/>
        false: <input name="isDone" type="radio" value="false"/> 
        price:  <input name="price" type="text" />
        <input type="submit" value="add" />
    </form>
</body>
</html>