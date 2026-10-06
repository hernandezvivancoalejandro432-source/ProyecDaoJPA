<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Personas</title>
</head>

<body>

    <h1>Personas registradas</h1>

    <table border="1">

        <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Apellido</th>
            <th>Edad</th>
        </tr>

        <c:forEach var="persona" items="${personas}">

            <tr>
                <td>${persona.id}</td>
                <td>${persona.nombre}</td>
                <td>${persona.apellido}</td>
                <td>${persona.edad}</td>
            </tr>

        </c:forEach>

    </table>

    <br>

    <a href="index.jsp">Regresar</a>

</body>
</html>