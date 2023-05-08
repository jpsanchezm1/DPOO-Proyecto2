package modelo.consumos;

import modelo.huespedes.Huesped;
import modelo.servicios.Servicio;

public class ConsumoServicio {

	private Huesped huesped;

	private Servicio servicio;

	public ConsumoServicio(Huesped huesped, Servicio servicio) {
		this.huesped = huesped;
		this.servicio = servicio;
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public Float getPrecio() {
		return servicio.getPrecio();
	}
}
