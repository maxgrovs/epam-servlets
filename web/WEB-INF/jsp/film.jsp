<%--
  Created by IntelliJ IDEA.
  User: maxgrovs
  Date: 12.02.2021
  Time: 22:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<div>
    <br>
    <table border="1">

        <tr>
            <td bgcolor="#a9a9a9"> id </td>
            <td bgcolor="#a9a9a9"> film_name </td>
        </tr>
        <tr>
            <td>  ${ requestScope.film.id }  </td>
            <td>  ${ requestScope.film.name }  </td>
        </tr>

    </table>

   <%-- <span>${requestScope.film.name} </span>
    <span>${requestScope.film.id}</span>--%>

</div>

</body>
</html>
