<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="Entidades.Cursos"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=iso-8859-1" />
<link href="style/fondo.css" rel="stylesheet">
<title>Alta Usuario</title>
</head>

<body>
<h1>Cuaderno de Comunicaciones </h1>
	<form name="Baja Usuario" action="ServletsConfirmarBajaUsuario" method="post">		
		
			<label>DNI</label> <input name="DNI" id="DNI" class="form-control"
			placeholder="DNI" required type="number"> <label>
			<br />
			Password</label> <input
					name="password" id="password" class="form-control"
					placeholder="password"  required type="password"> <label><br />
					Confirmar Password</label> <input
						name="ConfPassword" id="ConfPassword" class="form-control"
						placeholder="Confirmar Password"  required type="password"> .
						
						
		
					
	<button class="btn btn-lg btn-primary btn-block"
												type="submit">Baja Usuario</button>
	</form>
	<br />
	<form action="ServletsLogin" method="post">
		<input type="submit" value="Volver al menú" />
	</form>
	</body>
</html>
