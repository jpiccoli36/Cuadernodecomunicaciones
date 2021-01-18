package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorUsuario;
import Entidades.Usuarios;



@WebServlet({ "/ServletsBajaUsuario", "/servletsbajausuario", "/servletbajausuario" })
public class ServletsBajaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletsBajaUsuario() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		
		request.getRequestDispatcher("WEB-INF/BajaUsuario.jsp").forward(request, response);
		
	}
	}
