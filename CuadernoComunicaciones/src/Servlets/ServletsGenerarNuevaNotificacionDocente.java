package Servlets;

import java.io.File;
import java.io.IOException;

import javax.mail.Session;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Blob;

import Controlador.ControladorNotificaciones;
import Controlador.ControladorUsuario;
import Entidades.Usuarios;
import Util.Mails;

/**
 * Servlet implementation class ServletsGenerarNuevaNotificacionDocente
 */
@WebServlet("/ServletsGenerarNuevaNotificacionDocente")
public class ServletsGenerarNuevaNotificacionDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletsGenerarNuevaNotificacionDocente() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String email = (request.getParameter("curso"));
		System.out.println(email);
		String nota = (request.getParameter("nota"));
			ControladorNotificaciones cn = new ControladorNotificaciones();
		String url=(request.getParameter("archivo"));

		String usu=ServletsLogin.staticuser;
	
		//cn.GenerarNotificacion
		Mails.getInstance().send(email,"Notificación del señor/a "+usu,nota,url);
		doGet(request, response);
		
		
		

		
	}

}
