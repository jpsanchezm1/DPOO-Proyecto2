package modelo.servicios;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class EditorServicios {
	private void registrarServicio(String nombre, String precio, String archivoServicios) throws IOException {
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

	public void guardarRegistros(Map<String, Servicio> mapaServicios, String archivoServicios) throws IOException {
		for (Servicio servicio : mapaServicios.values()) {
			String nombre = servicio.getNombre();
			String precio = servicio.getPrecio().toString();
			registrarServicio(nombre, precio, archivoServicios);
		}
	}
}
