package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Alumno;
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
	Usuarios u = new Usuarios();

		try {

			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuario where dni_usuario=?   ");
		
			stmt.setString(1,dNI);
							
			rs=stmt.executeQuery();
			
			
			if((rs.next())){
							
				u.setDNI(rs.getString("dni_usuario"));
				u.setApellido(rs.getString("apellido"));
				u.setNombre(rs.getString("nombre"));
				u.setCategoria(rs.getInt("tipo_usuario"));
				u.setDNI(rs.getString("dni_usuario"));
				u.setApellido(rs.getString("apellido"));
				u.setNombre(rs.getString("nombre"));
						
				return u;
				}
		} catch (SQLException e) {					
		 throw	e=new SQLException("usuario o pass incorrectas");
		}

	
	return u;
}

public Usuarios ConsultarDNIDocente(String usu) throws SQLException {
	java.sql.PreparedStatement stmt =null;
	ResultSet rs = null;
	Usuarios doc = new Usuarios();

		try {

			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from docente where usuario=?   ");
		
			stmt.setString(1,usu);
							
			rs=stmt.executeQuery();
			
			
			if((rs.next())){
							
				doc.setDNI(rs.getString("dni_docente"));
				doc.setApellido(rs.getString("apellido"));
				doc.setNombre(rs.getString("nombre"));
				doc.setEmail(rs.getString("mail"));
						
				return doc;
				}
		} catch (SQLException e) {					
		 throw	e=new SQLException("usuario o pass incorrectas");
		}

	
	return doc;
	
}

public ArrayList<Cursos> ConsulaTodosCursosDocentes(Usuarios u) {
	
	ArrayList<Cursos> cursos = new ArrayList<Cursos>();
	ResultSet rs = null;		
	java.sql.PreparedStatement stmt = null;						
	
	try {
		stmt = FactoryConexion.getInstancia().getConn()
				.prepareStatement("select * from curso where dni_docente=?");
		stmt.setObject(1, u.getDNI());
		
		rs = stmt.executeQuery();
		if (rs != null) {
			while (rs.next()) {
				Cursos c = new Cursos();
			c.setAño(Integer.parseInt(rs.getString("año")));
				c.setDivision(rs.getString("division"));
				c.setNumerocurso(Integer.parseInt(rs.getString("numero_curso")));
				c.setTurno(rs.getString("turno"));
				c.setDniDocente(rs.getString("dni_docente"));
											
				cursos.add(c);

			}
			rs.close();
			stmt.close();
		}

	} catch (SQLException e) {

		e.printStackTrace();
	}
	return cursos;

}

public Alumno consultaDatosAlumnoBajaPadre(String dNI) throws SQLException {
	
	java.sql.PreparedStatement stmt =null;
	ResultSet rs = null;
	Alumno al = new Alumno();

		try {

			stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from alumno  where dni_padre=?   ");
		
			stmt.setString(1,dNI);
							
			rs=stmt.executeQuery();
			
			
			if((rs.next())){
							
				al.setDni(rs.getString("dni_alumno"));				
				al.setNombre(rs.getString("nombre"));
						
				return al;
				}
		} catch (SQLException e) {					
		 throw	e=new SQLException("usuario o pass incorrectas");
		}

	
	return al;
}

public void AltaDocente(Usuarios u, String curso) throws SQLException {
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
		//falta agregar en curso 
		
		stmt.executeUpdate();						
	
		stmt.close();

	} catch (SQLException s) {
		
		throw s;
	}
	catch(Exception s){
		
		throw s;
	}
	
	
}
}

