package app.gui.modelo;

import java.util.List;
import java.util.Objects;

public class Usuario {


	private String nombre;
	private List<String>disponibilidad;
	private String correo;
	private String contraseña;
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public List<String> getDisponibilidad() {
		return disponibilidad;
	}
	public void setDisponibilidad(List<String> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	

	@Override
	public String toString() {
		return "Usuario [nombre=" + nombre + ", disponibilidad=" + disponibilidad + ", correo=" + correo
				+ ", contraseña=" + contraseña + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(correo);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(correo, other.correo);
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getContraseña() {
		return contraseña;
	}
	public void setContraseña(String contraseña) {
		this.contraseña = contraseña;
	}
	
	
}
