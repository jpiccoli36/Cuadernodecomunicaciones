package Servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorUsuario;
import Entidades.Usuarios;

@WebServlet("/ServletsVerUsuarios")
public class ServletsVerUsuarios extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorUsuario cu=new ControladorUsuario();
		ArrayList<Usuarios>usu=new ArrayList<Usuarios>();
		usu=cu.ConsultaTodosUsuarios();
		request.setAttribute("listausu", usu);
		request.getRequestDispatcher("WEB-INF/BajaUsuario.jsp").forward(request, response);
	}

}
