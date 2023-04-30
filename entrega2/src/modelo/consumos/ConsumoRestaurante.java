package modelo.consumos;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.huespedes.Huesped;
import modelo.servicios.ProductoMenu;

public class ConsumoRestaurante {

	static Map<String, List<ConsumoRestaurante>> consumosRegistrados = new HashMap<>();

	private Huesped huesped;

	private ProductoMenu productoMenu;

	private boolean pago;

	public ConsumoRestaurante(Huesped huesped, ProductoMenu productoMenu, boolean pago) {
		super();
		this.huesped = huesped;
		this.productoMenu = productoMenu;
		this.pago = pago;
		if (pago) {
			pagarConsumo();
		} else {
			anadirPagoAReserva();
		}
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public ProductoMenu getProductoMenu() {
		return productoMenu;
	}

	public boolean getPago() {
		return pago;
	}

	public Float getPrecio() {
		return this.productoMenu.getPrecio();
	}

	private void anadirPagoAReserva() {
		huesped.getGrupo().añadirAlMonto(getPrecio());
	}

	public void pagarConsumo() {
		if (!pago) {
			Pago pagoConsumo = new Pago(huesped, getPrecio(), detalleConsumo());
		}
	}

	private String detalleConsumo() {
		return productoMenu.getNombre() + "(Restaurante)";
	}
}
