package Controlador;

import java.sql.Blob;
import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

public class ControladorNotificaciones {
int numero_notificacion;
Date fecha;
String nota;
Blob archivo;
String tipo;
Date fecha_cita;
int numero_curso;

public int getNumero_curso() {
	return numero_curso;
}
public void setNumero_curso(int numero_curso) {
	this.numero_curso = numero_curso;
}
public int getNumero_notificacion() {
	return numero_notificacion;
}
public void setNumero_notificacion(int numero_notificacion) {
	this.numero_notificacion = numero_notificacion;
}
public Date getFecha() {
	return fecha;
}
public void setFecha(Date fecha) {
	this.fecha = fecha;
}
public String getNota() {
	return nota;
}
public void setNota(String nota) {
	this.nota = nota;
}
public Blob getArchivo() {
	return archivo;
}
public void setArchivo(Blob archivo) {
	this.archivo = archivo;
}
public String getTipo() {
	return tipo;
}
public void setTipo(String tipo) {
	this.tipo = tipo;
}
public Date getFecha_cita() {
	return fecha_cita;
}
public void setFecha_cita(Date fecha_cita) {
	this.fecha_cita = fecha_cita;
}

}
