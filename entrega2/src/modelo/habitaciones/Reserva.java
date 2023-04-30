package modelo.habitaciones;

import java.time.LocalDate;
import java.util.ArrayList;

import modelo.huespedes.Huesped;

public class Reserva {

	private Huesped representante;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private boolean activa;
	private int cuotaTotal;
	private ArrayList<Habitacion> habitaciones;

	public Reserva(String fechaInicio, String fechaFin) {
		this.fechaInicio = LocalDate.parse(fechaInicio);
		this.fechaFin = LocalDate.parse(fechaFin);
		activa = true;
		cuotaTotal = 0;
		habitaciones = new ArrayList<>();
	}

	public Huesped getRepresentante() {
		return representante;
	}

	public void setRepresentante(Huesped representante) {
		this.representante = representante;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void añadirHabitacion(Habitacion habitacion) {
		this.habitaciones.add(habitacion);
	}

	public int getCuotaTotal() {
		return cuotaTotal;
	}

	public void sumarACuotaTotal(Float float1) {
		this.cuotaTotal += float1;
	}

	public void checkOut() {
	}

}
