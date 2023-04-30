package modelo.habitaciones;

import java.util.ArrayList;

public class Habitacion {

	private int id;
	private int capacidad;
	private String tipo;
	private String descripcion;
	private boolean balcon;
	private boolean vista;
	private boolean cocina;
	private ArrayList<Reserva> reservas;

	public Habitacion(int id, int capacidad, String tipo, String descripcion, boolean balcon, boolean vista,
			boolean cocina) {
		super();
		this.id = id;
		this.capacidad = capacidad;
		this.tipo = tipo;
		this.descripcion = descripcion;
		this.balcon = balcon;
		this.vista = vista;
		this.cocina = cocina;
		reservas = new ArrayList<Reserva>();
	}

	public int getId() {
		return id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isBalcon() {
		return balcon;
	}

	public boolean isVista() {
		return vista;
	}

	public boolean isCocina() {
		return cocina;
	}

	public ArrayList<Reserva> getReservas() {
		return reservas;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	public void setVista(boolean vista) {
		this.vista = vista;
	}

	public void setCocina(boolean cocina) {
		this.cocina = cocina;
	}

	public void añadirReserva(Reserva reserva) {
		this.reservas.add(reserva);
	}

	@Override
	public String toString() {
		return "\nTipo Habitacion: " + tipo + "\n" + "Capacidad habitación: " + capacidad;
	}

}
