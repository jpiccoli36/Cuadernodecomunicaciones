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

/**
 * Servlet implementation class ServletsAltaAlumno
 */
@WebServlet("/ServletsConfirmarAltaAlumno")
public class ServletsConfirmarAltaAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public ServletsConfirmarAltaAlumno() {
        super();
           }	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DNI=request.getParameter("DNI");
		String Nombre=request.getParameter("Nombre");
		String Apellido=request.getParameter("Apellido");		
		String dnipadre= request.getParameter("DNIPADRE");
		int curso=Integer.parseInt(request.getParameter("curso"));		
		
		Alumno al = new Alumno();
		al.setApellido(Apellido);		
		al.setDni(DNI);
		al.setNombre(Nombre);
		al.setNumero_curso(curso);
		al.setDnipadre(dnipadre);
		ControladorAlumno ctrl= new ControladorAlumno();		
		try{
			ctrl.AltaAlumno(al);		
		
				
		request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
		}
		catch (Exception s) {
			request.setAttribute("error", "error al agregar el usuario");
			request.setAttribute("url", "ServletsAdmin");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		}
	}

	

}
