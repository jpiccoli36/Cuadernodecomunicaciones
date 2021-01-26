package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import Datos.DatosAlumno;
import Datos.DatosCursos;
import Datos.DatosUsuarios;
import Entidades.Alumno;
import Entidades.Cursos;
import Entidades.Usuarios;

public class ControladorAlumno {

	private DatosAlumno da;
	
	public ControladorAlumno() {
			
		da = new DatosAlumno();
	}
	
	public void AltaAlumno(Alumno al) throws SQLException, Exception {
		
		
	
		DatosAlumno da = new DatosAlumno();
	da.AltaAlumno(al);
	}

	public ArrayList<Cursos> ConsultaTodosCursos() {
		DatosCursos dc = new DatosCursos();
		return dc.ConsultarTodosCursos();
		
	}
	

	public Alumno consultaDatosBajaAlumno(String dNI) throws SQLException {
		return da.consultarDatosBajaAlumno(dNI);
	}


	public void BajaAlumno(Alumno al) {
	
			da.BajaAlumno(al);
		}


	public void BajaAlumnoPorBajaPadre(String dNI) {
		da.BajaAlumnoPorBajaPadre(dNI);
		
	}
	public ArrayList<Usuarios> ConsultaDatosAlumnosSegunNumeroCurso(ArrayList<Cursos> cur) {
		
		return da.ConsultaDatosAlumnosSegunNumeroCurso(cur);
	}
		
	}

