package modelo.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class CargadorServicios {

	private Map<String, Servicio> mapaServicios = new HashMap<>();

	private String archivoServicios = "./data/servicios/servicios.txt";

	public Map<String, Servicio> getMapaServicios() {
		return mapaServicios;
	}

	public void registrarServicio(String nombre, String precio) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoServicios));
		BufferedWriter editor = new BufferedWriter(new FileWriter("./data/servicios/temporal.txt"));

		boolean servicioHallado = false;
		String linea;
		while ((linea = lector.readLine()) != null) {
			if (linea.contains(nombre)) {
				linea = nombre + ";" + precio;
				servicioHallado = true;
			}
			editor.write(linea);
			editor.newLine();
		}

		if (!servicioHallado) {
			editor.write(nombre + ";" + precio);
			editor.newLine();
		}

		lector.close();
		editor.close();

		if (!new File(archivoServicios).delete()) {
			throw new IOException("Error al eliminar el archivo");
		}

		if (!new File("./data/servicios/temporal.txt").renameTo(new File(archivoServicios))) {
			throw new IOException("Error al renombrar el archivo");
		}
	}

	public void anadirServicio(boolean infoNueva, String nombre, String precioString) throws IOException {
		if (infoNueva) {
			registrarServicio(nombre, precioString);
		}
		Float precio = Float.parseFloat(precioString);
		mapaServicios.computeIfAbsent(nombre, k -> new Servicio(nombre, precio));
		mapaServicios.get(nombre).setPrecio(precio);
	}

	public void cargarServicios(boolean infoNueva, String rutaArchivo) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
		String linea;
		while ((linea = lector.readLine()) != null) {
			String[] parametros = linea.split(";");
			String nombre = parametros[0];
			String precio = parametros[1];
			anadirServicio(infoNueva, nombre, precio);
		}
		lector.close();
	}

	public void recuperarInformacion() throws IOException {
		cargarServicios(false, archivoServicios);
	}
}