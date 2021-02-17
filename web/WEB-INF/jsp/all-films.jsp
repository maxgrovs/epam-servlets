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

    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"/>

</head>
<body>

<div>
<br>
    <table border="1">

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

</div>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>

</body>
</html>
