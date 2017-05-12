<%-- 
    Document   : index2
    Created on : 12/05/2017, 10:54:31 AM
    Author     : Labing
--%>

<%@page import=""%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <form action="ServletProfesor" name="formulario" method="get">
            user: <input name="user" type="text"><br>
            nombre: <input name="nombre" type="text"><br>
            : <input name="apellido" type="text"><br>
            Extension: <input name="ext" type="text"><br>
            <input name="enviar" type="submit">
        </form>
        <%
          nombre Obra_Arte = (nombre)request.getAttribute("nombre");
           if(profesor != null){
        %>   
          <br>
        <table >
            <tr>
               <td>Nombre</td>
               <td>Apellido</td> 
            </tr>
            <tr>
               <td><%=obra_Arte.getNombre()%></td>
               <td><%=obra_Arte.getApellido()%></td> 
        </tr>
        </table>
        
        <%
           }
        %>
        
        
    </body>
</html>