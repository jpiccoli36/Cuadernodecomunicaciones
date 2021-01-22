package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Alumno;
import Entidades.Cursos;
import Entidades.Usuarios;

public class DatosAlumno {

	
	public void AltaAlumno(Alumno al) throws SQLException,Exception {
		
		java.sql.PreparedStatement stmt = null;
		long dni=Long.parseLong(al.getDni());
		
		ResultSet rs = null;
	

		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"insert  into alumno(dni_alumno,nombre,apellido,dni_padre,numero_curso) values  (?,?,?,?,?)  ",
					PreparedStatement.RETURN_GENERATED_KEYS);
			stmt.setString(2, al.getNombre());
			stmt.setString(3, al.getApellido());
			stmt.setLong(1, dni);
			stmt.setLong(4, Long.parseLong(al.getDnipadre()));
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

	public Alumno consultarDatosBajaAlumno(String dNI) throws SQLException {
		
		java.sql.PreparedStatement stmt =null;
		ResultSet rs = null;
		Alumno al = new Alumno();

			try {

				stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from alumno where dni_alumno=?   ");
			
				stmt.setString(1,dNI);
								
				rs=stmt.executeQuery();
				
				
				if((rs.next())){
								
					al.setDni(rs.getString("dni_alumno"));
					al.setApellido(rs.getString("apellido"));
					al.setNombre(rs.getString("nombre"));
					al.setDnipadre(rs.getString("dni_padre"));
							
					return al;
					}
			} catch (SQLException e) {					
			 throw	e=new SQLException("usuario o pass incorrectas");
			}

		
		return al;
	}

	public void BajaAlumno(Alumno al) {			
			java.sql.PreparedStatement stmt = null;
			try {
				stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
						"DELETE FROM alumno  WHERE dni_alumno=?");
				
				stmt.setInt(1,Integer.parseInt(al.getDni()));
			
				stmt.executeUpdate();
				
				stmt.close();
			} catch (SQLException e1) {

				e1.printStackTrace();
			}
		
	}

	public void BajaAlumnoPorBajaPadre(String dNI) {
		java.sql.PreparedStatement stmt = null;
		try {
			stmt = FactoryConexion.getInstancia().getConn().prepareStatement(
					"DELETE FROM alumno  WHERE dni_padre=?");
			
			stmt.setInt(1,Integer.parseInt(dNI));
		
			stmt.executeUpdate();
			
			stmt.close();
		} catch (SQLException e1) {

			e1.printStackTrace();
		}
	
}
	public ArrayList<ArrayList<Usuarios>> ConsultaDatosAlumnosSegunNumeroCurso(ArrayList<Integer> cur) {
		java.sql.PreparedStatement stmt =null;
		java.sql.PreparedStatement stmt1 =null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		ArrayList<ArrayList<Usuarios>> al = new ArrayList();
		ArrayList<Usuarios> user = new ArrayList<Usuarios>();
		
		for (int i = 0; i < cur.size(); i++) {			
			try {	
				System.out.println("este es el indice de ejecucion de for"+i);
				System.out.println("estos son los cursos "+cur);
				stmt =FactoryConexion.getInstancia().getConn().prepareStatement("select * from alumno where numero_curso=?");
				stmt.setInt(1,cur.get(i));
				rs=stmt.executeQuery();
				if (rs != null) {					
					while (rs.next()) {
						System.out.println("este es el dni del padre"+rs.getString("dni_padre"));
						Alumno alumno = new Alumno();
						alumno.setDni(rs.getString("dni_padre"));
						alumno.setNombre(rs.getString("nombre"));
						alumno.setApellido(rs.getString("apellido"));						
						stmt1 =FactoryConexion.getInstancia().getConn().prepareStatement("select * from usuario where dni_usuario=?");
						stmt1.setInt(1,Integer.parseInt(alumno.getDni()));
						rs1=stmt1.executeQuery();
						while (rs1.next()) {
							System.out.println("este es el mail del padre"+rs1.getString("mail"));
						Usuarios u = new Usuarios();
						u.setEmail(rs1.getString("mail"));
						u.setNombre(alumno.getNombre());
						u.setApellido(alumno.getApellido());
						System.out.println("este seria el mail "+u.getEmail());
						user.add(u);						
						
						}
						System.out.println("aca estamos imprimiendo user"+user);
						al.add(user);
					}
			
		}				
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
			
		
	}
		return al;
		
		
	}
}
