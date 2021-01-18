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


@WebServlet("/ServletsConfirmarBajaAlumno")
public class ServletsConfirmarBajaAlumno extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletsConfirmarBajaAlumno() {
        super();        
    }
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String usu=ServletsLogin.staticuser;
		String DNI=request.getParameter("DNI");
		String pass=request.getParameter("password");
		String repass=request.getParameter("ConfPassword");
		ControladorAlumno ca = new ControladorAlumno();
		ControladorUsuario cu = new ControladorUsuario();
		Alumno al = new Alumno();
	
		if(pass.equals(repass)){		
			Usuarios u = new Usuarios();
			
		try {
			cu.consultarclave(pass,usu);
			
			al=ca.consultaDatosBajaAlumno(DNI);
			
			request.setAttribute("dni",al.getDni());
			request.setAttribute("nombre", al.getNombre());
			request.setAttribute("apellido", al.getApellido());
			
					
			request.getRequestDispatcher("WEB-INF/ConfirmarEliminacionAlumno.jsp").forward(request, response);
			}
			catch(SQLException s){
				request.setAttribute("error", "error al agregar el usuario");
				request.setAttribute("url", "ServletsAdmin");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
				
			} catch (Exception s) {
				request.setAttribute("error", "error al agregar el usuario");
				request.setAttribute("url", "ServletsAdmin");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			}
			
		}
	}
}
		