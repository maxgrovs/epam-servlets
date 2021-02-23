<%--
  Created by IntelliJ IDEA.
  User: maxgrovs
  Date: 14.02.2021
  Time: 12:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Title</title>

    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-BmbxuPwQa2lc/FVzBcNJ7UAyJxM6wuqIj61tLrc4wSX0szH/Ev+nYRRuWlolflfl" crossorigin="anonymous">

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta2/dist/js/bootstrap.bundle.min.js"
            integrity="sha384-b5kHyXgcpbZJO/tY9Ul7kGkf1S0CWuKcCD38l8YkeH8z8QjE0GmW1gYU5S9FOnJ0"
            crossorigin="anonymous"></script>

</head>
<body>

<%@include file="header.jsp" %>

<div>
    <table class="table table-striped">

        <tr>
            <td bgcolor="#a9a9a9"> id </td>
            <td bgcolor="#a9a9a9"> film_name </td>
        </tr>

    <c:forEach var="film" items="${requestScope.films}">

            <tr>
                <td>  ${ film.id }  </td>
                <td>  ${ film.name }  </td>
            </tr>

    </c:forEach>

    </table>

</div> <br>

<%--<div>

    <a href="${pageContext.request.contextPath}/save-film">Save film</a><br>
    <a href="${pageContext.request.contextPath}/logout">Logout</a>

</div>--%>

</body>
</html>
