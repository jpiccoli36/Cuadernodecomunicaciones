package Controlador;

import java.sql.SQLException;

import Datos.DatosAlumno;
import Entidades.Alumno;

public class ControladorAlumno {

	public void AltaAlumno(Alumno al) throws SQLException, Exception {
	
		DatosAlumno da = new DatosAlumno();
	da.AltaAlumno(al);
	}

}
