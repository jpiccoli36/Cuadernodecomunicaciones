package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorUsuario;
import Entidades.Alumno;
import Entidades.Usuarios;

@WebServlet("/ServletsConfirmarBajaUsuario")
public class ServletsConfirmarBajaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ServletsConfirmarBajaUsuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String usu = ServletsLogin.staticuser;
		String DNI = request.getParameter("DNI");
		String pass = request.getParameter("password");
		String repass = request.getParameter("ConfPassword");
		ControladorUsuario cu = new ControladorUsuario();

		if (pass.equals(repass)) {
			Usuarios u = new Usuarios();
			Alumno al = new Alumno();

			try {
				cu.consultarclave(pass, usu);
				u = cu.consultaDatosBajaUsuario(DNI);
				
				al= cu.consultaDatosAlumnoBajaPadre(DNI);
			


				request.setAttribute("dni", u.getDNI());
				request.setAttribute("nombre", u.getNombre());
				request.setAttribute("apellido", u.getApellido());
				request.setAttribute("dnialumno", al.getDni());
				request.setAttribute("nombrealumno",al.getNombre());			
				if (u.getCategoria() == 2) {
					request.setAttribute("tipo", "PADRE/MADRE/TUTOR");
					request.getRequestDispatcher("WEB-INF/ConfirmarEliminacionUsuario.jsp").forward(request, response);

				} else {
					request.setAttribute("tipo", "PROFESOR");
					request.getRequestDispatcher("WEB-INF/ConfirmarEliminacionUsuario.jsp").forward(request, response);

				}

			} catch (SQLException s) {
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
