package Servlets;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorAlumno;
import Controlador.ControladorUsuario;
import Entidades.Alumno;
import Entidades.Cursos;
import Entidades.Usuarios;

/**
 * Servlet implementation class ServletsNuevaNotificacion
 */
@WebServlet("/ServletsNuevaNotificacionDocente")
public class ServletsNuevaNotificacionDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		ControladorUsuario cu = new ControladorUsuario();
		ControladorAlumno ca = new ControladorAlumno();
		ArrayList<Integer> cur= new ArrayList<Integer>();
		ArrayList<ArrayList<Usuarios>> alumnos= new ArrayList();
		Usuarios u = new Usuarios();
		String usu=ServletsLogin.staticuser;
		try {
			u=cu.ConsultarDNIDocente(usu);
			//aca tengo el dni del docente, ahora tengo que traer todos los cursos que tengan ese dni del docente
			
		
		cur=cu.ConsultaTodosCursosDocente(u);
		// aca tengo todos los cursos con el dni del docente
	
		alumnos=ca.ConsultaDatosAlumnosSegunNumeroCurso(cur);
		//supuestamente aca tengo todos los datos...
	
		
		request.getRequestDispatcher("WEB-INF/GenerarNotificacionDocente.jsp").forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}

}
