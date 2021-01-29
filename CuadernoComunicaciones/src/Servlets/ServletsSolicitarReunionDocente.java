package Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/ServletsSolicitarReunionDocente")
public class ServletsSolicitarReunionDocente extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public ServletsSolicitarReunionDocente() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String usu=ServletsLogin.staticuser;
		
		request.getRequestDispatcher("WEB-INF/SolicitarReunionDocente.jsp").forward(request, response);
		
	}

}
