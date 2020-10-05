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


@WebServlet({ "/ServletsAltaUsuario","/AltaUsuario", "/altausuario", "/Altausuarios", "/altausuarios", "/altaUsuarios" })
public class ServletsAltaUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;       
    
    public ServletsAltaUsuario() {
        super();
           }

	
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String DNI=request.getParameter("DNI");
		String Nombre=request.getParameter("Nombre");
		String Apellido=request.getParameter("Apellido");
		String Usuario=request.getParameter("Usuario");
		String Password=request.getParameter("Password");
		String Domicilio=request.getParameter("Domicilio");
		String Email=request.getParameter("Email");		
		String categoria=request.getParameter("Categoria");		
		
	Usuarios u= new Usuarios(); 
		u.setCategoria(categoria);
		u.setApellido(Apellido);
		u.setContraseña(Password);
		u.setDNI(DNI);
		u.setNombre(Nombre);
		u.setEmail(Email);
		u.setUsuario(Usuario);
		u.setDomicilio(Domicilio);
		
		ControladorUsuario ctrl= new ControladorUsuario();		
		try{
			ctrl.AltaPersona(u);		
		
		request.getSession().setAttribute("user", u);			
		request.getRequestDispatcher("WEB-INF/Admin.jsp").forward(request, response);
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
