<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 5/5/2022
  Time: 2:11 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="music" items="${musicList}">
    <div>Name: ${music.nameSong}</div>
    <div>artist: ${music.artist}</div>
    <div>type: ${music.type}</div>
    <div>link: ${music.link}</div>
</c:forEach>
</body>
</html>
