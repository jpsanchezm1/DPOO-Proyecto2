package modelo.habitaciones;

import java.util.ArrayList;
import modelo.huespedes.Huesped;

public class Reserva {

	private Huesped representante;
	private String fechaInicio;
	private String fechaFin;
	private boolean activa;
	private ArrayList<Integer> habitaciones;

	public Reserva(Huesped representante, String fechaInicio, String fechaFin) {
		this.representante = representante;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		activa = true;
		habitaciones = new ArrayList<>();
	}

	public Huesped getRepresentante() {
		return representante;
	}

	public String getFechaInicio() {
		return fechaInicio;
	}

	public String getFechaFin() {
		return fechaFin;
	}

	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}

	public ArrayList<Integer> getHabitaciones() {
		return habitaciones;
	}

	public void aniadirHabitacion(int id) {
		habitaciones.add(id);
	}

	public void checkOut() {
	}

}
