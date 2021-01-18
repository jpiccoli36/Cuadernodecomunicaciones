package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;

import Entidades.Usuarios;;

public class Login {
	public Usuarios login(Usuarios w) throws SQLException {
		java.sql.PreparedStatement stmt =null;
		ResultSet rs = null;
		Usuarios p = new Usuarios();
	
			try {

				stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuario where usuario=? and contraseña=? and estado=1 ");
			
				stmt.setString(1,w.getUsuario());
				stmt.setString(2, w.getContraseña());						
				rs=stmt.executeQuery();
				
				
				if((rs.next())){
					p.setNombre(rs.getString("nombre"));
					p.setApellido(rs.getString("apellido"));				
					p.setDNI(rs.getString("dni_usuario"));
					p.setCategoria(rs.getInt("tipo_usuario"));					
					p.setUsuario(w.getUsuario());
					p.setEmail(rs.getString("mail"));
					
					}
			} catch (SQLException e) {					
			 throw	e=new SQLException("usuario o pass incorrectas");
			}
	
		
		return p;
	}

}
