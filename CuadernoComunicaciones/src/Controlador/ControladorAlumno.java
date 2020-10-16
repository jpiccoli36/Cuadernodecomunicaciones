package Controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import Datos.DatosAlumno;
import Datos.DatosCursos;
import Entidades.Alumno;
import Entidades.Cursos;

public class ControladorAlumno {

	public void AltaAlumno(Alumno al) throws SQLException, Exception {
	
		DatosAlumno da = new DatosAlumno();
	da.AltaAlumno(al);
	}

	public ArrayList<Cursos> ConsultaTodosCursos() {
		DatosCursos dc = new DatosCursos();
		return dc.ConsultarTodosCursos();
		
	}
}
