<%-- 
Document   : vistageneral
Created on : 15-jun-2017, 0:37:12
Author     : USER
--%>

<%@page import="java.util.List"%>
<%@page import="entities.Task"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Tareas Pendientes</title>
</head>
<body>
    <form action="TareasPendientes">
                <input type="hidden" value="<%= session.getAttribute("username") %>" name="username">
                <input type="submit" value="Mostrar tareas">     
        </form>
     <%
         if ("username".equals(request.getAttribute("username"))){ %>         
    <%
    List<Task> tasks = (List<Task>) request.getAttribute("listaTask");       
                    for (Task task : tasks) {
                        %>                 
    <h3><%= task.getIdtask()%></h3>
    <h3><%=task.getTitle() %></h3>
    <h3><%= task.getContent() %></h3>       
    <br>
    <br>

                    <% }
                    %> 

                    <% }%>

</body>
</html>
