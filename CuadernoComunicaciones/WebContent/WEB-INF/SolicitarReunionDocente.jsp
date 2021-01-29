<%@page import="javax.swing.text.StyledEditorKit.ForegroundAction"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Cursos"%>
<%@page import="Entidades.Usuarios"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="ServletsGenerarNuevaNotificacionDocente" method="post"
		id="curso">
		<label>Nota</label>
		<textarea name="nota" rows="10" cols="50">Nota</textarea>
	
		
	<label>Fecha de Reunion</label>
	<input  type="date" id="fecha" name="fecha" >
		
		

		<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar Solicitud</button>

	</form>


</body>
</html>