package modelo.servicios.restaurante;

import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class ControladoRestaurante {

	private Map<String, Map<String, ProductoMenu>> menu = new HashMap<>();

	private String archivoPlatos = "./data/servicios/menuRestaurante/platos.txt";

	private String archivoBebidas = "./data/servicios/menuRestaurante/bebidas.txt";

	public ControladoRestaurante() throws IOException{
		recuperarInformacion();
	}

	public void cargarMenu(String rutaArchivoPlatos, String rutaArchivoBebidas) throws IOException {
		CargadorRestaurante cargadorRestaurante = new CargadorRestaurante();
		cargadorRestaurante.cargarMenu(rutaArchivoPlatos, rutaArchivoBebidas, menu);
	}

	public void crearProductoMenu(String categoria, String nombre, String precioString, String horaInicioString,
			String horaFinString, String llevableAHabitacionString) throws IOException {
		Float precio = Float.parseFloat(precioString);
		Boolean llevableAHabitacion = Boolean.parseBoolean(llevableAHabitacionString);
		LocalTime horaInicio = LocalTime.parse(horaInicioString);
		LocalTime horaFin = LocalTime.parse(horaFinString);
		ProductoMenu producto = new ProductoMenu(nombre, precio, horaInicio, horaFin, llevableAHabitacion);
		menu.get(categoria).put(nombre, producto);
	}

	public ProductoMenu consultarProductoMenu(String categoria, String nombre) {
		return menu.get(categoria).get(nombre);
	}

	public Map<String, Map<String, ProductoMenu>> getMenu() {
		return menu;
	}

	private void recuperarInformacion() throws IOException {
		CargadorRestaurante cargadorRestaurante = new CargadorRestaurante();
		cargadorRestaurante.cargarMenu(archivoPlatos, archivoBebidas, menu);
	}
	
	public void guardarRegistros() throws IOException {
		EditorRestaurante editor = new EditorRestaurante();
		editor.guardarRegistros(menu, archivoBebidas, archivoPlatos);
	}
}
