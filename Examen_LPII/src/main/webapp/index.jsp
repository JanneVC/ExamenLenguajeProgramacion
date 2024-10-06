<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Servicio CRUD</title>
</head>
<body>

<%
String redirectUrl = "SubjectServlet?action=listar";
response.sendRedirect(redirectUrl);
%>

</body>
</html>