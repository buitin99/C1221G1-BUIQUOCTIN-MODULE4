<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 10:13 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update Email</title>
</head>
<body>
<h2>Update Email</h2>
<form:form action="/update" modelAttribute="email" method="post">
    <div>
        <h2>Setting</h2>
    </div>

    <p>Languages: </p>
    <form:select path="languages">
        <form:option value="English">English</form:option>
        <form:option value="Vietnamese">Vietnamese</form:option>
        <form:option value="Japanese">Japanese</form:option>
        <form:option value="Chinese">Chinese</form:option>
    </form:select>
    </div>
        <p>Page Size: </p>
        <p>Show</p>
        <form:select path="pageSize">
        <form:option value="5" label="5"/>
        <form:option value="10" label="10"/>
        <form:option value="15" label="15"/>
        <form:option value="25" label="25"/>
        <form:option value="50" label="50"/>
        <form:option value="100 " label="100 "/>
        </form:select>
        <p>emails per page</p>
    </div>
    <div>
        <p>Spam fillter: </p>
        <form:checkbox path="spamsFillter"/>
        <p>emails per page</p>
    </div>
    <div>
        <p>Signature: </p>
        <form:input path="signature"/>
    </div>
    <div>
        <input type="submit" value="Update">
        <input type="submit" value="Close">
    </div>
</form:form>
</body>
</html>
