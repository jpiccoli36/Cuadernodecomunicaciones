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
import Entidades.Cursos;
import Entidades.Usuarios;


@WebServlet("/ServletsSolicitarReunionDocente")
public class ServletsSolicitarReunionDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletsSolicitarReunionDocente() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ControladorUsuario cu = new ControladorUsuario();
		ControladorAlumno ca = new ControladorAlumno();
		ArrayList<Cursos> cur= new ArrayList<Cursos>();
		ArrayList<Usuarios> alumnos= new ArrayList();
		Usuarios u = new Usuarios();
		String usu=ServletsLogin.staticuser;
		try {
			u=cu.ConsultarDNIDocente(usu);
			//aca tengo el dni del docente			
		
		cur=cu.ConsultaTodosCursosDocente(u);
		// aca tengo todos los cursos con el dni del docente
	
		alumnos=ca.ConsultaDatosAlumnosSegunNumeroCurso(cur);
		//supuestamente aca tengo todos los datos del padre
		
		request.setAttribute("usuarios", alumnos);
		request.setAttribute("cursos", cur);
		
		
		
		request.getRequestDispatcher("WEB-INF/SolicitarReunionDocente.jsp").forward(request, response);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
		
	}


