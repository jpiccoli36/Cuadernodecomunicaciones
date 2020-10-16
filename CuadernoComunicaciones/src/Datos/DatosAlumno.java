package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Alumno;

public class DatosAlumno {

	
	public void AltaAlumno(Alumno al) throws SQLException,Exception {
		
		java.sql.PreparedStatement stmt = null;

		ResultSet rs = null;
		System.out.println(al.getApellido());
		System.out.println(al.getDni());
		System.out.println(al.getDnipadre());
		System.out.println(al.getNombre());
		System.out.println(al.getNumero_curso());
		

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert  into alumno(dni_alumno,nombre,apellido,dni_padre,numero_curso) values  (?,?,?,?,?)  ",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(2, al.getNombre());
			stmt.setString(3, al.getApellido());
			stmt.setLong(1, al.getDni());
			stmt.setLong(4, al.getDnipadre());
			stmt.setInt(5, al.getNumero_curso());
			
			stmt.executeUpdate();

			rs = stmt.getGeneratedKeys();
			
			rs.close();
			stmt.close();

		} catch (SQLException s) {
			
			throw s;
		}
		catch(Exception s){
			
			throw s;
		}
		
	}
}
