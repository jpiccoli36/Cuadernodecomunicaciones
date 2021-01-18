<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@page import="java.util.ArrayList"%>
<%@page import="Entidades.Usuarios"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href="style/fondo.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Baja Usuarios</title>
</head>
<body>
<h1>Cuaderno de comunicaciones </h1>
	
	<label>DNI: </label><label for="dni" class="sr-only"><%=request.getAttribute("dni") %></label>

			<Br> 
			<label>Nombre: </label><label for="nombre" class="sr-only"><%=request.getAttribute("nombre") %></label> 
			<Br>
				<label>Apellido: </label><label for="apellido" class="sr-only"><%=request.getAttribute("apellido") %></label> 
				
			<Br>
			
					<a href="ServletsFinalizarEliminacionUsuarios?dni=<%=request.getAttribute("dni") %>&nombre=<%=request.getAttribute("nombre") %>&apellido=<%=request.getAttribute("apellido") %>"><button>Confirmar</button></a>
		
	

</body>
</html>