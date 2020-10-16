package Entidades;

import java.io.Serializable;

import javax.swing.Spring;

public class Usuarios implements Serializable{
	
	String apellido;
	String DNI;
	String nombre;
	String usuario;
	int Categoria;
	String Email;
	int tipousuario;
	
	
	
	public String getDomicilio() {
		return Domicilio;
	}
	public void setDomicilio(String domicilio) {
		Domicilio = domicilio;
	}
	String contraseña;

	String Domicilio;
	
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}	

	
	public int getCategoria() {
		return Categoria;
	}
	public void setCategoria(int categoria) {
		Categoria = categoria;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
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
	public String getDNI() {
		return DNI;
	}
	public int getTipousuario() {
		return tipousuario;
	}
	public void setTipousuario(int tipousuario) {
		this.tipousuario = tipousuario;
	}
	public void setDNI(String dNI) {
		DNI = dNI;
	}
	

	
	
	

}
