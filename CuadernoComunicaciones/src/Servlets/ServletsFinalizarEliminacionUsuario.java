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


@WebServlet("/ServletsFinalizarEliminacionUsuarios")
public class ServletsFinalizarEliminacionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsFinalizarEliminacionUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String DNI=request.getParameter("dni");
		
		ControladorUsuario cu = new ControladorUsuario();	
		ControladorAlumno ca = new ControladorAlumno();
		
			Usuarios u = new Usuarios();
			Alumno al = new Alumno();
		try {
					
		
			u.setDNI(DNI);		
			cu.BajaUsuario(u);
			ca.BajaAlumnoPorBajaPadre(DNI);
					
			request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
			}
			catch (Exception s) {
				request.setAttribute("error", "error al agregar el usuario");
				request.setAttribute("url", "ServletsAdmin");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			}
			
		
		
		
	
		}
	
	
protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
/*		
		
		String DNI=request.getParameter("dni");
		System.out.println(DNI);
		ControladorUsuario cu = new ControladorUsuario();	
		
			Usuarios u = new Usuarios();
		try {
					
			u.setDNI(DNI);		
			cu.BajaUsuario(u);
					
			request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
			}
			catch (Exception s) {
				request.setAttribute("error", "error al agregar el usuario");
				request.setAttribute("url", "ServletsAdmin");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			}
			
		
		
		
	
		}
		*/
	}
}


