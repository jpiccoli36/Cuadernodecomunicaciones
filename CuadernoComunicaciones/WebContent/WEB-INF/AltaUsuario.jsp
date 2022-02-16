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
	<form name="Agregar Usuario" action="ServletsConfirmarAltaUsuario" method="post">
			Apellido</label> <input
				name="Apellido" id="Apellido" class="form-control"
				placeholder="Apellido"  required type="text"> <label><br />
	
				Nombre</label> <input name="Nombre" id="Nombre" class="form-control"
			placeholder="Nombre"  required type="text"> <label><br /> 
			<label>DNI</label> <input name="DNI" id="DNI" class="form-control"
			placeholder="DNI" required type="number"> <label>
			<br />
			Domicilio</label> <input
					name="Domicilio" id="Domicilio" class="form-control"
					placeholder="Domicilio"  required type="text"> <label><br />
					Email</label> <input
							name="Email" id="Email" class="form-control" placeholder="Email"  required type="email">
								<br />
				 Usuario</label> <input
					name="Usuario" id="Usuario" class="form-control"
					placeholder="Usuario"  required type="text"> <label><br />
					 Password</label> <input
						name="Password" id="Password" class="form-control"
						placeholder="Password"  required type="password"> .
					<label>Tipo Usuario:</label>
		
	
		<select name="tipousuario">

				<option value="1">admin</option>
				<option value="2">padre/madre/tutor</option>
				<option value="3">docente</option>
				
>
		</select>
						
								<label>Curso:</label>
		<select name="curso">
	<option value="null">Ninguno</option>
			<%
			ArrayList<Cursos>listaCur= (ArrayList<Cursos>)request.getAttribute("listaCursos");
			for(Cursos c : listaCur){
			%>
				<option value="<%=c.getNumerocurso()%>">
				<%=c.getAño()+" "+c.getDivision()+" "+c.getTurno() %></option>


			<%
				}
			%>
			</select>
		
					
	<button class="btn btn-lg btn-primary btn-block"
	type="submit">Agregar Usuario</button>
	
	</form>
	<br />
	<input type="button" onclick="history.back()" name="volver atrás" value="Cancelar">
	</body>
</html>

