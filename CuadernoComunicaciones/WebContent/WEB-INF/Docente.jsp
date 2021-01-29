<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@page import="Entidades.Usuarios"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Menu Usuario</title>
<link href="style/fondo.css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<style type="text/css">
* {
	margin: 0px;
	padding: 0px;
}

#header {
	width: 100%;
	margin: 0px;
	font-family: Arial, Helvetica, sans-serif;
}

ul, ol {
	list-style: none;
}

.nav>li {
	float: left;
}

.nav li a {
	background-color: black;
	color: #fff;
	text-decoration: none;
	padding: 10px 12px;
	display: block;
}

.nav li ul {
	display: none;
	position: absolute;
	min-width: 100%;
}

.nav li:hover>ul {
	display: block;
}

.nav li ul li {
	position: relative;
}
</style>
</head>
<body>
<h1>Cuaderno de Comuniaciones </h1>
	<h2>
	Bienvenido
		<%=((Usuarios)session.getAttribute("user")).getNombre() %></h2>
	<div id="header" style="width: 100%">
		<ul class="nav">	
	<li><a>Comunicaciones</a>
	<ul>
	<li>
	<form action="ServletsNuevaNotificacionDocente" method="post">
	
		<input type="submit" style="cursor: pointer; background-color: black; color: white; border-style: none; height: 30px; width: 200px; font-size: 12pt"
								 value="Nueva Notificacion" />
	</form>
	</li>
	<li>	

	<form action="ServletsSolicitarReunionDocente" method="post">
							
							<input
								type="submit"
								style="cursor: pointer; background-color: black; color: white; border-style: none; height: 30px; width: 200px; font-size: 12pt"
								value="Solicitar Reunion" /></input>
						</form>
	</li>
	<li>
		<form action="ServletsBuscarReservaUsuario" method="post">
		<input type="submit" style="cursor: pointer; background-color: black; color: white; border-style: none; height: 30px; width: 200px; font-size: 12pt"
								 value="Nueva Sancion" />
	</form>
	</li>
	<li>
		<form action="ServletsBuscarReservaUsuario" method="post">
		<input type="submit" style="cursor: pointer; background-color: black; color: white; border-style: none; height: 30px; width: 200px; font-size: 12pt"
								 value="Solicitar Autorizacion" />
	</form>
	</li>
	
	</ul>
		</li>
	</div>
	<div align="right"
		style="font-size: 27px; padding-top: 0px; padding-right: 150px;">
<form action="index.html" method="post">
		<input type="submit" style="width: 100px; height: 35px;" value="Cerrar Sesion" />
	</form>
	</div>


</body>
</html>