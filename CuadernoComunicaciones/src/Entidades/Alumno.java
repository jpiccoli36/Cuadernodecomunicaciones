package Entidades;

public class Alumno {
	
	String nombre;
	String apellido;
	int numero_curso;
	long dni;
	long dnipadre;
	public long getDnipadre() {
		return dnipadre;
	}
	public void setDnipadre(long dnipadre) {
		this.dnipadre = dnipadre;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public int getNumero_curso() {
		return numero_curso;
	}
	public void setNumero_curso(int numero_curso) {
		this.numero_curso = numero_curso;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}

}
