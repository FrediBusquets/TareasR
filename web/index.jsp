<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Inicial</title>
    </head>
    <body>
        <%
        if(session.getAttribute("username") == null ){ %>
            <form action="Login" method="POST">
            <p>Username: <input type="text" name="username"></p>
            <p>Password: <input type="text" name="pass"></p>
            <p><input type="submit" value="Login"></p>
        </form>
            
            <form action="altauser.jsp">
                <input type="submit" value="Registrar Usuario">
            </form>
             <%
            if(request.getAttribute("fallo") != null ){ %>
            <p><%= request.getAttribute("fallo")%> </p>
            <% } 
            %>
        <% } 

        else{
        %>
            <p>Bienvenido <%= session.getAttribute("username") %> </p>
            <form action="vistageneral.jsp" method="POST">
               <input type="hidden" value="<%= session.getAttribute("username") %>" name="user">
               <input type="submit" value="Ver Tareas Pendientes">
            </form>
          <form action="logout" method="POST">
               <input type="submit" value="Cerrar Sesion">
            </form>  
        <% }
        %>
    </body>
</html>