<%@page import="servlets.AltaUser"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Done</title>
    </head>
    <body>
        <%
            String status = (String) request.getAttribute("status");
            if (status.equals(AltaUser.STATUS_OK)) { %>
        <p>Team registered.</p> 
        <% } else if (status.equals(AltaUser.STATUS_ERROR)) { %>
        <p>Team already exists.</p>
        <% } %>
        <a href="index.jsp">Main menu</a>
    </body>
</html>
