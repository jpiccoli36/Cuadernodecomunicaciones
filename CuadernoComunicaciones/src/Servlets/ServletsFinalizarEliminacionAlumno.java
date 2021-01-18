package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorAlumno;
import Controlador.ControladorUsuario;
import Entidades.Alumno;
import Entidades.Usuarios;


@WebServlet("/ServletsFinalizarEliminacionAlumno")
public class ServletsFinalizarEliminacionAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ServletsFinalizarEliminacionAlumno() {
        super();
       
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String DNI=request.getParameter("dni");
		
		ControladorAlumno ca = new ControladorAlumno();	
		
			Alumno al = new Alumno();
		try {
					
			al.setDni(DNI);		
			ca.BajaAlumno(al);
					
			request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
			}
			catch (Exception s) {
				request.setAttribute("error", "error al agregar el usuario");
				request.setAttribute("url", "ServletsAdmin");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			}

	}
}
		
		