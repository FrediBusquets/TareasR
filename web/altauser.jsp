
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alta usuario</title>
    </head>
    <body>
        <% if (session.getAttribute("username") == null){ %>
        <form action="AltaUser" method="POST">
            <p>User Name: <input type="text" name="username" required></p>
            <p>Password : <input type="text" name="pass" required></p>
            <p>Name: <input type="text" name="name" required></p>
            <p>Age: <input type="number" name="age" required></p>
            <p><input type="submit" value="Registrar" name="registro"></p>
        </form>
        <% } %>
    </body>
</html>
