<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidades.Cursos"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="ServletsNuevaNotificacionDocente" method="post">
<label>Nota</label>  <textarea name="textarea" rows="10" cols="50">Nota</textarea> 
<br>
<label for="archivo"> archivo:</label>
<input type="file" name="archivo" id="archivo">

<select name="curso">

			
		</select>
<button class="btn btn-lg btn-primary btn-block"   type="submit" >Enviar Notificacion </button>

</form>
</body>
</html>