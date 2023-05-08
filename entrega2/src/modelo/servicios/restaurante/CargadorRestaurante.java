package modelo.servicios.restaurante;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class CargadorRestaurante {

	private void anadirProductoMenu(String categoria, String nombre, String precioString, String rangoDisp,
			String llevableAHabitacionString, Map<String, Map<String, ProductoMenu>> menu,
			Map<String, ProductoMenu> menuSimple) throws IOException {
		Float precio = Float.parseFloat(precioString);
		Boolean llevableAHabitacion = Boolean.parseBoolean(llevableAHabitacionString);
		String[] horasDisp = rangoDisp.split("-"); // rango es de la forma horaInicio-horaFin en formato hh:mm:ss o
													// hh:mm
		LocalTime horaInicio = LocalTime.parse(horasDisp[0]);
		LocalTime horaFin = LocalTime.parse(horasDisp[1]);
		menu.computeIfAbsent(categoria, k -> new HashMap<>());
		ProductoMenu producto = new ProductoMenu(nombre, precio, horaInicio, horaFin, llevableAHabitacion);
		menu.get(categoria).put(nombre, producto);
		menuSimple.put(nombre, producto);
	}

	private void cargarProductos(String categoria, String rutaArchivo, Map<String, Map<String, ProductoMenu>> menu,
			Map<String, ProductoMenu> menuSimple) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
		String linea;
		while ((linea = lector.readLine()) != null) {
			String[] parametros = linea.split(";");
			String nombre = parametros[0];
			String precio = parametros[1];
			String rangoDisponibilidad = parametros[2];
			String llevableAHabitacion = parametros[3];
			anadirProductoMenu(categoria, nombre, precio, rangoDisponibilidad, llevableAHabitacion, menu, menuSimple);
		}
		lector.close();
	}

	public void cargarMenu(String rutaArchivoPlatos, String rutaArchivoBebidas,
			Map<String, Map<String, ProductoMenu>> menu, Map<String, ProductoMenu> menuSimple) throws IOException {
		// el mapa menu está compuesto por categoría = { nombreProducto: Producto}
		cargarProductos("platos", rutaArchivoPlatos, menu, menuSimple);
		cargarProductos("bebidas", rutaArchivoBebidas, menu, menuSimple);
	}
}
