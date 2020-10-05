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

				stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuarios where Usuario=? and Contraseña=? ");
			
				stmt.setString(1,w.getUsuario());
				stmt.setString(2, w.getContraseña());						
				rs=stmt.executeQuery();
				
				
				if((rs.next())){
					p.setNombre(rs.getString("NombreUsuarios"));
					p.setApellido(rs.getString("ApellidoUsuarios"));				
					p.setDNI(rs.getString("Dni"));
					p.setCategoria(rs.getString("Categoria"));				
					p.setUsuario(w.getUsuario());
					p.setEmail(rs.getString("Email"));
					
					}
			} catch (SQLException e) {					
			 throw	e=new SQLException("usuario o pass incorrectas");
			}
	
		
		return p;
	}

}
