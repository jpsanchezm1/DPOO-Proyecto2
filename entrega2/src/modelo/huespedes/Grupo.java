package modelo.huespedes;

import java.util.ArrayList;

import modelo.habitaciones.Reserva;

public class Grupo {

	private Huesped representante;
	private ArrayList<Huesped> acompanantes;
	private Reserva reserva;

	public Grupo(Huesped representante) {
		this.representante = representante;
		acompanantes = new ArrayList<Huesped>();
	}

	public Huesped getRepresentante() {
		return representante;
	}

	public ArrayList<Huesped> getAcompanantes() {
		return acompanantes;
	}

	public Reserva getReserva() {
		return reserva;
	}

	public void setRepresentante(Huesped representante) {
		this.representante = representante;
	}

	public void añadirAcompanante(Huesped acompanante) {
		this.acompanantes.add(acompanante);
	}

	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}

	public void añadirAlMonto(Float monto) {
		reserva.sumarACuotaTotal(monto);
	}

}
