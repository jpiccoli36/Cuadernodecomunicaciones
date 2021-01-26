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
		<br> <label for="archivo"> archivo:</label> <input type="file"
			name="archivo" id="archivo" onselect="">		
		<%
			ArrayList<Usuarios> usuarios = (ArrayList<Usuarios>) request.getAttribute("usuarios");
		%>
		
		<select name="curso" >
		<option value="todos" >Todos</option>

			<%
				for (Usuarios usu : usuarios) {
			%>


			<option value="<%=usu.getEmail()%>"><%=usu.getNombre() + " " + usu.getApellido() +"  "+usu.getDomicilio()%> </option>

			<%
				}
			%>


		</select>	
		<input type="hidden"
				name="nombre" value=<%=request.getParameter("nombre") %> >
				<input type="hidden"
				name="apellido" value=<%=request.getParameter("apellido") %> >
		

		<button class="btn btn-lg btn-primary btn-block" type="submit">Enviar
			Notificacion</button>

	</form>


</body>
</html>