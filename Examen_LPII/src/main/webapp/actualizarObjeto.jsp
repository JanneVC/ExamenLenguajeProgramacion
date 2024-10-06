<%@page import="com.cibertec.model.Subject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Actualizar Objeto</title>
</head>
<body>

<h3 class="text-center">Actualización de Objetos</h3>
  
  <%
  	Subject subject = (Subject) request.getAttribute("objeto");
  %>
  
  <form action="SubjectServlet" method="post" class="w-50" style="background-color: #f8f9fa; padding: 20px; border-radius: 5px;">  
    <table>
       <tr>
         <td>Nombre:</td>
         <td><input type="text" name="txtObjeto" value="<%= subject.getSubject() %>" /></td>
       </tr>
       <tr>
         <td>Crédito:</td>
         <td><input type="text" name="txtCredito" value="<%= subject.getCredits()%>" /></td>
       </tr>
       
       <tr>
         <td colspan="2" style="text-align: right;">
           <input type="hidden" value = "<%= subject.getIdsubject() %>" name="txtId" />
           <input type="hidden" value = "actualizar" name="action" />
           <input type="submit" value="Actualizar Datos" style="background-color: green; color: white; border: none; padding: 10px 20px; cursor: pointer;" />
         </td>
       </tr>
    </table>
  
  </form>


</body>
</html>