package Datos;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import Entidades.Cursos;

public class DatosCursos {

	public ArrayList<Cursos> ConsultarTodosCursos() {
		
		
			ResultSet rs = null;
			ArrayList<Cursos> cur = new ArrayList<Cursos>();

			try {
				Statement stmt = FactoryConexion.getInstancia().getConn().createStatement();

				rs = stmt.executeQuery("select * from curso");
				if (rs != null) {
					while (rs.next()) {
						Cursos c = new Cursos();
						c.setAño(rs.getInt("año"));
						c.setDivision(rs.getString("division"));
						c.setTurno(rs.getString("turno"));					
						c.setNumerocurso(rs.getInt("numero_curso"));
						cur.add(c);

					}
					
				}
				rs.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
			
			return cur;
		}
		
	}


