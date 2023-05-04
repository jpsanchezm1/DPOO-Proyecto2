package modelo.habitaciones;

import java.util.ArrayList;
import modelo.huespedes.Huesped;

public class Reserva {

	private Huesped representante;
	private ArrayList<Huesped> acompanantes;
	private String fechaInicio;
	private String fechaFin;
	private boolean activa;
	private int cuotaTotal;
	private ArrayList<Integer> habitaciones;

	public Reserva(Huesped representante, String fechaInicio, String fechaFin, ArrayList<Huesped> acompanantes) {
		this.representante = representante;
		this.acompanantes = acompanantes;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		activa = true;
		cuotaTotal = 0;
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
	
	public ArrayList<Huesped> getAcompanantes(){
		return acompanantes;
	}

	public void aniadirHabitacion(int id) {
		habitaciones.add(id);
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
