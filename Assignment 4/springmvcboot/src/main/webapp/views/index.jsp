<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Title here></title>
</head>
<body>
    Welcome
    <%= "Hello" %>

    <form action="addAlien" method="POST">
        Enter your id <input type="text" name="aid"><br>
        Enter your name <input type="text" name="aname"><br>
        <input type="submit">
    </form>
</body>
</html>