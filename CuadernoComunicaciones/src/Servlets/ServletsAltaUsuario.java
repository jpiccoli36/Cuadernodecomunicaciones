package Servlets;
import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Controlador.ControladorAlumno;
import Controlador.ControladorUsuario;
import Entidades.Cursos;

/**
 * Servlet implementation class ServletsAltaUsuario
 */
@WebServlet("/ServletsAltaUsuario")
public class ServletsAltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsAltaUsuario() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ControladorUsuario cu = new ControladorUsuario();		
ArrayList<Cursos> cur= new ArrayList<Cursos>();
	cur=cu.ConsultaTodosCursos();
	request.setAttribute("listaCursos", cur=cu.ConsultaTodosCursos());
		request.getRequestDispatcher("WEB-INF/AltaUsuario.jsp").forward(request, response);
	}

}





