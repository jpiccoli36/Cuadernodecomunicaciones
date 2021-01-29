package Servlets;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorUsuario;
import Entidades.Usuarios;

@WebServlet({ "/ServletsLogin", "/servletslogin" })
public class ServletsLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String staticuser;
	public ServletsLogin() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		staticuser = request.getParameter("user");
		String pass = request.getParameter("pass");

		Usuarios per = new Usuarios();
		per.setContraseña(pass);
		per.setUsuario(staticuser);
		
		ControladorUsuario ctrl = new ControladorUsuario();
		try {		
			per = ctrl.login(per);
			
			if(per.getEstado()==1)
			{

			if (per.getCategoria()==1) {

			request.getSession().setAttribute("user", per);
				request.getSession().setAttribute("admin", per);
				request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
			} 
			else {
				if ((per.getCategoria()==2))
						{	request.getSession().setAttribute("user", per);
						request.getSession().setAttribute("usuario", staticuser);
						request.getSession().setAttribute("categoria", per);
						request.getRequestDispatcher("WEB-INF/Usuario.jsp").forward(request, response);
					
						}
				else{
					if((per.getCategoria()==3))
					{
					request.getSession().setAttribute("user", per);
					request.getSession().setAttribute("usuario", staticuser);
					request.getSession().setAttribute("categoria", per);
					request.getRequestDispatcher("WEB-INF/Docente.jsp").forward(request, response);
				} 
					
				else{
					request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
				}
				}

					
			}
			}
			else{
				request.setAttribute("error", "Usuario/Password Incorrecta O Usuario no habilitado");
				request.setAttribute("url", "index.html");
				request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
			}
		} catch (java.sql.SQLException e) {
			request.setAttribute("error", "Error en la conexion");
			request.setAttribute("url", "index.html");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);
		} catch (Exception k) {

			request.setAttribute("error", "Usuario/Password Incorrecta");
			request.setAttribute("url", "index.html");
			request.getRequestDispatcher("WEB-INF/Error.jsp").forward(request, response);

		}

	}
}

