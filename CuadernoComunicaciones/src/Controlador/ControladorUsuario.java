package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.DatosAlumno;
import Datos.DatosCursos;
import Datos.DatosUsuarios;
import Datos.Login;
import Entidades.Alumno;
import Entidades.Cursos;
import Entidades.Usuarios;


public class ControladorUsuario {
	private DatosUsuarios du;

	public ControladorUsuario() {
		
		du = new DatosUsuarios();

	}

	

	public void AltaUsuario(Usuarios p) throws SQLException, Exception {
		
		du.AltaUsuario(p);

	}
//	public Persona ConsultarEstado(int iD) {
//		
//		return du.ConsultarEstado(iD);
//
//	}
//
//	public void InhabilitarUsuario(Persona p) {
//		du.InhabilitarUsuario(p);
//
//	}
//
//	public void HabilitarUsuario(Persona p) {
//		du.HabilitarUsuario(p);
//
//	}

	
	public Usuarios login(Usuarios p) throws SQLException  {
		
			Login log = new Login();	
			return log.login(p);
			
		
		}



	public void BajaUsuario(Usuarios u) {
		du.BajaUsuario(u);
	}



	public ArrayList<Usuarios> ConsultaTodosUsuarios() {
		
		return null;
	}



	public ArrayList<Cursos> ConsultaTodosCursos() {
		DatosCursos dc = new DatosCursos();
		return dc.ConsultarTodosCursos();
		
	}



	public Usuarios consultarclave(String pass, String usu) throws SQLException {
		return du.consultarclave(pass,usu);
		
	}



	public Usuarios consultaDatosBajaUsuario(String dNI) throws SQLException {
		
		return du.consultarDatosBajaUsuario(dNI);
	}


	
	public Alumno consultaDatosAlumnoBajaPadre(String dNI) throws SQLException {
		
		return du.consultaDatosAlumnoBajaPadre(dNI);
	}

	public Usuarios ConsultarDNIDocente(String usu) throws SQLException {
		
		return du.ConsultarDNIDocente(usu);
	}



	public ArrayList<Cursos> ConsultaTodosCursosDocente(Usuarios u) {
	
		return du.ConsulaTodosCursosDocentes(u);
	}


	}
