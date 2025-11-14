package app.gui.modelo;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class Camarero {


	private String nombre;
	private Map<String,Boolean> disponibilidad;
	private List<String> horarioFinal;
	private int contadorHoras;
	public String genero;
	public Camarero() {
		contadorHoras=0;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public List<String> getHorarioFinal() {
		return horarioFinal;
	}

	public void setHorarioFinal(List<String> horarioFinal) {
		this.horarioFinal = horarioFinal;
	}

	

	public Map<String, Boolean> getDisponibilidad() {
		return disponibilidad;
	}

	public void setDisponibilidad(Map<String, Boolean> disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	

	

	@Override
	public String toString() {
		return "Camarero [nombre=" + nombre + ", disponibilidad=" + disponibilidad + ", horarioFinal=" + horarioFinal
				+ ", contadorHoras=" + contadorHoras + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(nombre);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Camarero other = (Camarero) obj;
		return Objects.equals(nombre, other.nombre);
	}

	public int getContadorHoras() {
		return contadorHoras;
	}

	public void setContadorHoras(int contadorHoras) {
		this.contadorHoras = contadorHoras;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}
	
}
