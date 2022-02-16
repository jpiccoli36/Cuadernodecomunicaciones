<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="Entidades.Cursos"%>
    <%@page import="java.util.ArrayList"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Cuaderno Comunicaciones</title>
</head>
<body>


<form name="Alta Alumno" action="ServletsConfirmarAltaAlumno" method="post">
	
			Nombre</label> <input name="Nombre" id="Nombre" class="form-control"
			placeholder="Nombre"  required type="text"> <label><br /> 
			Apellido</label> <input
				name="Apellido" id="Apellido" class="form-control"
				placeholder="Apellido"  required type="text"> <label><br />
				DNI</label> <input name="DNI" id="DNI" class="form-control"
			placeholder="DNI"  required type="number"> <label><br /> 
			DNI PADRE/MADRE/TUTOR</label> <input name="DNIPADRE" id="DNIPADRE" class="form-control"
			placeholder="DNI PADRE/MADRE/TUTOR"  required type="number"> <label><br /> 
				
				
				<label>Curso:</label>
		<select name="curso">

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
		
		<button class="btn btn-lg btn-primary btn-block"   type="submit" >Alta Alumno </button>
<input type="button" onclick="history.back()" name="volver atrás" value="Cancelar">		
	</form>
			
		</body>
</html>