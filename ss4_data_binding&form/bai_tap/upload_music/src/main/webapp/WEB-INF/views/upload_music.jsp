<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 2:48 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<a href="/list">Go List</a>
<form:form action="" modelAttribute="music" method="post">
    <div>Name Song:
        <form:input type="text" path="nameSong" />
    </div>
    <div>artist:
        <form:input type="text" path="artist" />
    </div>
    <div>Type:
        <form:input type="text" path="type" />
    </div>
    <div>Link:
        <form:input type="text" path="link" />
    </div>
    <div>
        <input type="submit" value="Upload">
    </div>
</form:form>
</body>
</html>
