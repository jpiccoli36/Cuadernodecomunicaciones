package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Usuarios;

public class DatosUsuarios {
public void AltaUsuario(Usuarios u) throws SQLException,Exception {
		
		java.sql.PreparedStatement stmt = null;
		long dni=Long.parseLong(u.getDNI());

	
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert  into usuario(dni_usuario,nombre,apellido,domicilio,usuario,contraseña,mail,tipo_usuario) values  (?,?,?,?,?,?,?,?)  ",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, dni);
			stmt.setString(2, u.getNombre());
			stmt.setString(3, u.getApellido());
			stmt.setString(4, u.getDomicilio());	
			stmt.setString(5, u.getUsuario());
			stmt.setString(6, u.getContraseña());
			stmt.setString(7, u.getEmail());
			stmt.setInt(8, u.getTipousuario());
			
			stmt.executeUpdate();						
		
			stmt.close();

		} catch (SQLException s) {
			
			throw s;
		}
		catch(Exception s){
			
			throw s;
		}
		
	}

public void BajaUsuario(Usuarios u) {
	java.sql.PreparedStatement stmt = null;

	try {

		stmt = FactoryConexion.getInstancia().getConn().prepareStatement("DELETE FROM usuarios where Dni=?");
		stmt.setString(1, u.getDNI());
		stmt.executeUpdate();

	} catch (SQLException s) {

		s.printStackTrace();
	}	
	try {
		stmt.close();
	} catch (SQLException e1) {

		e1.printStackTrace();
	}
	
	
}
}