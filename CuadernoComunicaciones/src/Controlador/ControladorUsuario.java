package Controlador;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import Datos.DatosUsuarios;
import Datos.Login;
import Entidades.Usuarios;


public class ControladorUsuario {
	private DatosUsuarios du;

	Scanner w = new Scanner(System.in);
	

	public ControladorUsuario() {
		
		du = new DatosUsuarios();
	}

	

	public void AltaPersona(Usuarios p) throws SQLException, Exception {
		
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

	}
