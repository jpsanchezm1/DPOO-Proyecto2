package modelo.consumos;

import modelo.huespedes.Huesped;
import modelo.servicios.Servicio;

public class ConsumoServicio {

	private Huesped huesped;

	private Servicio servicio;

	private Boolean pago;

	public ConsumoServicio(Huesped huesped, Servicio servicio, boolean pago) {
		this.huesped = huesped;
		this.servicio = servicio;
		this.pago = pago;
		if (this.pago) {
			pagarConsumo();
		} else {
			anadirPagoAReserva();
		}
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public Servicio getServicio() {
		return servicio;
	}

	public Boolean getPago() {
		return pago;
	}

	public Float getPrecio() {
		return servicio.getPrecio();
	}

	private void anadirPagoAReserva() {
		this.huesped.getGrupo().añadirAlMonto(this.getPrecio());
	}

	public void pagarConsumo() {
		if (!pago) {
			Pago pagoConsumo = new Pago(huesped, getPrecio(), getServicio().getNombre());
		}
	}
}
