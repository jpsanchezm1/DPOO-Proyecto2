package modelo.servicios.restaurante;

import java.time.LocalTime;

public class ProductoMenu {

	private String nombre;

	private Float precio;

	private LocalTime horaInicio;

	private LocalTime horaFin;

	private Boolean llevableAHabitacion;

	public ProductoMenu(String nombre, float precio, LocalTime horaInicio, LocalTime horaFin,
			boolean llevableAHabitacion) {
		super();
		this.nombre = nombre;
		this.precio = precio;
		this.horaInicio = horaInicio;
		this.horaFin = horaFin;
		this.llevableAHabitacion = llevableAHabitacion;
	}

	public String getNombre() {
		return nombre;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFin() {
		return horaFin;
	}

	public void setHoraFin(LocalTime horaFin) {
		this.horaFin = horaFin;
	}

	public Boolean isLlevableAHabitacion() {
		return llevableAHabitacion;
	}

	public void setLlevableAHabitacion(boolean llevableAHabitacion) {
		this.llevableAHabitacion = llevableAHabitacion;
	}

	@Override
	public String toString() {
		return this.nombre + ": " + this.precio + " - Disponible de " + this.horaInicio + " a " + this.horaFin;
	}
}