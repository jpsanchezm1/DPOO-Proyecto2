package modelo.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

public class CargadorRestaurante {

	private Map<String, Map<String, ProductoMenu>> menu = new HashMap<>();

	private Map<String, ProductoMenu> mapaProductos = new HashMap<>();

	private String archivoPlatos = "./data/servicios/menuRestaurante/platos.txt";

	private String archivoBebidas = "./data/servicios/menuRestaurante/bebidas.txt";

	public void cargarMenu(String rutaArchivoPlatos, String rutaArchivoBebidas) throws IOException {
		cargarProductos("platos", rutaArchivoPlatos);
		cargarProductos("bebidas", rutaArchivoBebidas);
	}

	public Map<String, Map<String, ProductoMenu>> getMenu() {
		return menu;
	}

	public Map<String, ProductoMenu> getMapaProductos() {
		return mapaProductos;
	}

	public void registrarProducto(String categoria, String nombre, String precio, String rangoDisp,
			String llevableAHabitacion) throws IOException {

		String archivoBase = (categoria.equals("bebidas")) ? archivoBebidas : archivoPlatos;

		BufferedReader lector = new BufferedReader(new FileReader(archivoBase));
		BufferedWriter editor = new BufferedWriter(new FileWriter("./data/servicios/menuRestaurante/temporal.txt"));

		boolean servicioHallado = false;
		String linea;
		while ((linea = lector.readLine()) != null) {
			if (linea.contains(nombre)) {
				linea = nombre + ";" + precio + ";" + rangoDisp + ";" + llevableAHabitacion;
				servicioHallado = true;
			}
			editor.write(linea);
			editor.newLine();
		}

		if (!servicioHallado) {
			editor.write(nombre + ";" + precio + ";" + rangoDisp);
			editor.newLine();
		}

		lector.close();
		editor.close();

		if (!new File(archivoBase).delete()) {
			throw new IOException("Error al eliminar el archivo");
		}

		if (!new File("./data/servicios/menuRestaurante/temporal.txt").renameTo(new File(archivoBase))) {
			throw new IOException("Error al renombrar el archivo");
		}
	}

	public void anadirProductoMenu(String categoria, String nombre, String precioString, String rangoDisp,
			String llevableAHabitacionString) throws IOException {
		registrarProducto(categoria, nombre, precioString, rangoDisp, llevableAHabitacionString);
		Float precio = Float.parseFloat(precioString);
		boolean llevableAHabitacion = Boolean.parseBoolean(llevableAHabitacionString);
		String[] horasDisp = rangoDisp.split("-"); // rango es de la forma horaInicio-horaFin en formato hh:mm:ss o
													// hh:mm
		LocalTime horaInicio = LocalTime.parse(horasDisp[0]);
		LocalTime horaFin = LocalTime.parse(horasDisp[1]);
		menu.computeIfAbsent(categoria, k -> new HashMap<>());
		ProductoMenu producto = new ProductoMenu(nombre, precio, horaInicio, horaFin, llevableAHabitacion);
		menu.get(categoria).put(nombre, producto);
		mapaProductos.put(nombre, producto);
	}

	public void cargarProductos(String categoria, String rutaArchivo) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
		String linea;
		while ((linea = lector.readLine()) != null) {
			String[] parametros = linea.split(";");
			String nombre = parametros[0];
			String precio = parametros[1];
			String rangoDisponibilidad = parametros[2];
			String llevableAHabitacion = parametros[3];
			anadirProductoMenu(categoria, nombre, precio, rangoDisponibilidad, llevableAHabitacion);
		}
		lector.close();
	}

	public void recuperarInformacion() throws IOException {
		cargarMenu(archivoPlatos, archivoBebidas);
	}

	public static void main(String[] args) throws IOException {
		CargadorRestaurante c = new CargadorRestaurante();
		c.cargarMenu("./archivosEjemplo/platos.txt", "./archivosEjemplo/bebidas.txt");
	}
}
