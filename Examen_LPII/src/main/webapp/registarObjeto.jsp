<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Registrar objeto</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

</head>
<body>

<h3 class="text-center">Registro de Productos Ferreteros</h3>
 <div class="container d-flex justify-content-center mt-5">
  <form action="SubjectServlet" method="post" class="w-50" style="background-color: #f8f9fa; padding: 20px; border-radius: 5px;">  
    <table >
       <tr>
         <td>Nombre:</td>
         <td><input type="text" name="txtObjeto" /></td>
       </tr>
       <tr>
         <td>Credito:</td>
         <td><input type="text" name="txtCredito" /></td>
       </tr>
     
    	
       <tr>
         <td colspan="5" style="text-align: right;">
           <input type="hidden" value = "registrar" name="action" />
           <input type="submit" value="Registrar Datos"  style="background-color: green; color: white; border: none; padding: 10px 20px; cursor: pointer;" />
         </td>
       </tr>
	</div>
    </table>
  
  </form>

</div>

</body>
</html>