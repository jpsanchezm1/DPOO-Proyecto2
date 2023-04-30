package modelo.servicios;

import java.io.IOException;
import java.util.Map;

public class ControladorRestaurante {

	private CargadorRestaurante cargadorRestaurante = new CargadorRestaurante();

	private Restaurante restaurante;

	public ControladorRestaurante() throws IOException {
		cargadorRestaurante.recuperarInformacion();
		this.restaurante = new Restaurante(cargadorRestaurante.getMenu(), cargadorRestaurante.getMapaProductos());
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void cargarMenu(String rutaArchivoPlatos, String rutaArchivoBebidas) throws IOException {
		cargadorRestaurante.cargarMenu(rutaArchivoPlatos, rutaArchivoBebidas);
	}

	public void cargarPlatos(String rutaArchivoPlatos) throws IOException {
		cargadorRestaurante.cargarProductos("platos", rutaArchivoPlatos);
	}

	public void cargarBebidas(String rutaArchivoBebidas) throws IOException {
		cargadorRestaurante.cargarProductos("bebidas", rutaArchivoBebidas);
	}

	public void crearProductoMenu(String categoria, String nombre, String precio, String rangoDisp,
			String llevableAHabitacion) throws IOException {
		cargadorRestaurante.anadirProductoMenu(categoria, nombre, precio, rangoDisp, llevableAHabitacion);
	}

	public ProductoMenu consultarProductoMenu(String categoria, String nombre) {
		Map<String, Map<String, ProductoMenu>> menu = restaurante.getMenu();
		return menu.get(categoria).get(nombre);
	}

	public ProductoMenu consultarProductoMenu(String nombre) {
		Map<String, ProductoMenu> mapaProductos = restaurante.getMapaProductos();
		return mapaProductos.get(nombre);
	}
}
