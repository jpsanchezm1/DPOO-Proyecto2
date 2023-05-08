package modelo.consumos;

import modelo.huespedes.Huesped;
import modelo.servicios.restaurante.ProductoMenu;

public class ConsumoRestaurante {

	private Huesped huesped;

	private ProductoMenu productoMenu;

	public ConsumoRestaurante(Huesped huesped, ProductoMenu productoMenu) {
		super();
		this.huesped = huesped;
		this.productoMenu = productoMenu;
	}

	public Huesped getHuesped() {
		return huesped;
	}

	public ProductoMenu getProductoMenu() {
		return productoMenu;
	}

	public Float getPrecio() {
		return this.productoMenu.getPrecio();
	}
}
