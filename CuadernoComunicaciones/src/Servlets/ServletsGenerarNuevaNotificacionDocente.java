package Servlets;

import java.io.File;
import java.io.IOException;
import java.sql.Date;

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

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int opcion;
		String email;
		String nota;
		String url;
		String usu = ServletsLogin.staticuser;
		opcion = Integer.parseInt((request.getParameter("opcion")));
		ControladorNotificaciones cn = new ControladorNotificaciones();
		switch (opcion) {
		case 1:
			
			email = (request.getParameter("curso"));
			nota = (request.getParameter("nota"));
			url = (request.getParameter("archivo"));
			System.out.println(url);
			if(url.isEmpty())
			{
			
			
						// cn.GenerarNotificacion

			Mails.getInstance().send(email, "Notificación del señor/a " + usu, nota);
			doGet(request, response);
			}
			else{		
				Mails.getInstance().send(email, "Notificación del señor/a " + usu, nota, url);
				doGet(request, response);
				
			}
			break;

		case 2:
			String fecha=(request.getParameter("fecha"));
		
			email = (request.getParameter("curso"));

			nota = (request.getParameter("nota"));
			
			
			
			// cn.GenerarNotificacion	
			
			
			/*String fechahsini = (request.getParameter("fechaini") + " " + request.getParameter("horaini"));
			String fechahsfin = (request.getParameter("fechafin") + " " + request.getParameter("horafin"));
			SimpleDateFormat f = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			
			java.util.Date FechaHoraIni = null;
			java.util.Date FechaHoraFin = null;
			try {
				FechaHoraIni = f.parse(fechahsini);
				FechaHoraFin = f.parse(fechahsfin);*/

			Mails.getInstance().send(email, "Reunion para el dia "+ fecha +"con el Señor/a " + usu, nota );
			doGet(request, response);
		default:
			break;
		}

	}

}
