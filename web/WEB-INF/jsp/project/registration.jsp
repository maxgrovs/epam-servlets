<%--
  Created by IntelliJ IDEA.
  User: Видеоконференция
  Date: 18.02.2021
  Time: 15:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
      integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
        crossorigin="anonymous"></script>

<html>
<head>
    <title>Title</title>
</head>
<body>

<form action="${pageContext.request.contextPath}/registration" method="post">

    <br>
    <br>
    <br>
    <br>
    <br>

    <div align="center">
        <div class="col-md-4">
            <label for="username">Username:
                <input id="username" type="text" class="form-control" name="username" value="${param.username}">
            </label><br>
        </div>

        <div class="col-md-4">

            <label for="password">Password:
                <input type="password" class="form-control" name="password" id="password">
            </label><br>
        </div>

        <br>
        <div class="col-12">
            <button class="btn btn-primary" type="submit">Register</button>
        </div>

      <%--  <br>
        <c:if test="${param.error}">
            <span style="color: red">Вы ввели некорректные данные!</span> <br>
            <a href="${pageContext.request.contextPath}/registration">registration</a>
        </c:if>--%>


    </div>

</form>


</body>
</html>
