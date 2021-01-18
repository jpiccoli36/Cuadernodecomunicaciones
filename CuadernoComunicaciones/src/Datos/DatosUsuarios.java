package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Cursos;
import Entidades.Usuarios;

public class DatosUsuarios {
public void AltaUsuario(Usuarios u) throws SQLException,Exception {
		
		java.sql.PreparedStatement stmt = null;
		long dni=Long.parseLong(u.getDNI());

	
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert  into usuario(dni_usuario,nombre,apellido,domicilio,usuario,contraseña,mail,tipo_usuario,estado) values  (?,?,?,?,?,?,?,?,?)  ",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setLong(1, dni);
			stmt.setString(2, u.getNombre());
			stmt.setString(3, u.getApellido());
			stmt.setString(4, u.getDomicilio());	
			stmt.setString(5, u.getUsuario());
			stmt.setString(6, u.getContraseña());
			stmt.setString(7, u.getEmail());
			stmt.setInt(8, u.getTipousuario());
			stmt.setInt(9, 1);
			
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
		stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
				"UPDATE usuario SET estado=? WHERE dni_usuario=?");
		stmt.setInt(1,2);
		stmt.setInt(2,Integer.parseInt(u.getDNI()));
	
		stmt.executeUpdate();
		
		stmt.close();
	} catch (SQLException e1) {

		e1.printStackTrace();
	}

	
	
}

public Usuarios consultarclave(String pass, String usu) throws SQLException {

	java.sql.PreparedStatement stmt =null;
	ResultSet rs = null;
	Usuarios p = new Usuarios();

		try {

			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuario where usuario=? and contraseña=?  ");
		
			stmt.setString(1,usu);
			stmt.setString(2, pass);						
			rs=stmt.executeQuery();
			
			
			if((rs.next())){
							
				p.setDNI(rs.getString("dni_usuario"));							
						
				return p;
				}
		} catch (SQLException e) {					
		 throw	e=new SQLException("usuario o pass incorrectas");
		}

	
	return p;
}

public Usuarios consultarDatosBajaUsuario(String dNI) throws SQLException {
	
	java.sql.PreparedStatement stmt =null;
	ResultSet rs = null;
	Usuarios p = new Usuarios();

		try {

			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuario where dni_usuario=?   ");
		
			stmt.setString(1,dNI);
							
			rs=stmt.executeQuery();
			
			
			if((rs.next())){
							
				p.setDNI(rs.getString("dni_usuario"));
				p.setApellido(rs.getString("apellido"));
				p.setNombre(rs.getString("nombre"));
						
				return p;
				}
		} catch (SQLException e) {					
		 throw	e=new SQLException("usuario o pass incorrectas");
		}

	
	return p;
}
}
