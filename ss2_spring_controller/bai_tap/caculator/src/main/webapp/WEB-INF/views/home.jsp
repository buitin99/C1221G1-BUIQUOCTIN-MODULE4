<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 3:32 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h2>Calculator</h2>
<form action="/calculator">
    <input type="text" name="number1">
    <input type="text" name="number2"><br><br>
    <input type="submit" name="calculation" value="addition">(+)
    <input type="submit" name="calculation" value="subtraction">(-)
    <input type="submit" name="calculation" value="multiplication">(*)
    <input type="submit" name="calculation" value="division">(/)
</form>
</body>
</html>
