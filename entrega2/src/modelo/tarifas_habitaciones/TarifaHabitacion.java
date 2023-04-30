package modelo.tarifas_habitaciones;

import java.time.LocalDate;

public class TarifaHabitacion {

	private String tipoHabitacion;

	private LocalDate fechaInicio;

	private LocalDate fechaFin;

	private String dias;

	private float precio;

	public TarifaHabitacion(String tipoHabitacion, LocalDate fechaInicio, LocalDate fechaFin, String dias,
			float precio) {
		super();
		this.tipoHabitacion = tipoHabitacion;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.dias = dias;
		this.precio = precio;
	}

	public String getTipoHabitacion() {
		return tipoHabitacion;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public String getDias() {
		return dias;
	}

	public float getPrecio() {
		return precio;
	}
}
