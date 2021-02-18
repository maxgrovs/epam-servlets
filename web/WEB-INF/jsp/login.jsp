<%--
  Created by IntelliJ IDEA.
  User: Видеоконференция
  Date: 18.02.2021
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/login" method="post"></form>

<label for="username">Username:
    <input id="username" type="text" name="username" value="${param.username}">
</label><br>

<c:if test="${param.error}">
    <span>Вы ввели некорректные данные!</span>
</c:if>

<label for="password">Password:
    <input type="password" name="password" id="password">
</label><br>

<input type="submit" value="Login">

</body>
</html>
