<%@page import="java.util.List"%>
<%@page import="com.cibertec.model.Subject"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Listado de Objetos</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>

<h2 class="text-center">Listado de Objetos</h2>

	<div class="card-body">
		<a class ="btn btn-success" href="registrarObjeto.jsp">Nuevo Objeto</a> 
		<hr/>
	</div>

<table class = "table table-striped table-hover">
  <thead>
    <th>Id</th>
    <th>Nombre</th>
    <th>Créditos</th>
 
    <th>Acciones</th>
  </thead>
  <tbody>
 
  <%
  	
    List<Subject> lista = (List<Subject>) request.getAttribute("data");
    if (!lista.isEmpty()) {
    	for(Subject item:lista) {
  %>
    <tr>
        <td><%= item.getIdsubject() %></td>
        <td><%= item.getSubject() %></td>
        <td><%= item.getCredits() %></td>
        <td colspan="2">
          <a href="SubjectServlet?action=detalle&id=<%=item.getIdsubject()%>">Editar</a>
          <a href="SubjectServlet?action=eliminar&id=<%=item.getIdsubject()%>">Eliminar</a>
        </td>
    </tr>
  <%
    	}
    } else {
  %> 
    <tr>
      <td colspan="8"><span style="color:red;font-weight:bold">No hay objetos registrados...</span></td>
    </tr>   
  <% } %>
  </tbody>
</table>

</body>
</html>