package modelo.servicios;

import java.util.Map;

public class Restaurante {

	private Map<String, Map<String, ProductoMenu>> menu;

	private Map<String, ProductoMenu> mapaProductos;

	public Restaurante(Map<String, Map<String, ProductoMenu>> menu, Map<String, ProductoMenu> mapaProductos) {
		this.menu = menu;
		this.mapaProductos = mapaProductos;
	}

	public void setMenu(Map<String, Map<String, ProductoMenu>> menu) {
		this.menu = menu;
	}

	public void setMapaProductos(Map<String, ProductoMenu> mapaProductos) {
		this.mapaProductos = mapaProductos;
	}

	public Map<String, Map<String, ProductoMenu>> getMenu() {
		return menu;
	}

	public Map<String, ProductoMenu> getMapaProductos() {
		return mapaProductos;
	}
}
