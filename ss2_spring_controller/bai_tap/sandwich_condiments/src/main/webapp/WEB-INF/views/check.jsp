<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 4/5/2022
  Time: 10:26 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>$Title$</title>
</head>
<body>
<h2>Sandwich Condiments</h2>
<form action="/save">
    <div><input type="checkbox" name="condiment" value="lettuce">Lettuce</div>
    <div><input type="checkbox" name="condiment" value="tomato">Tomato</div>
    <div><input type="checkbox" name="condiment" value="mustard">Mustard</div>
    <div><input type="checkbox" name="condiment" value="sprouts">Sprouts</div>
    <input type="submit" value="Save">
</form>
</body>
</html>
