package modelo.servicios.restaurante;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class EditorRestaurante {
	private void registrarProducto(String archivoBase, String nombre, String precio, String rangoDisp,
			String llevableAHabitacion) throws IOException {

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
			editor.write(nombre + ";" + precio + ";" + rangoDisp + ";" + llevableAHabitacion);
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

	public void guardarRegistros(Map<String, Map<String, ProductoMenu>> menu, String archivoBebidas,
			String archivoPlatos) throws IOException {
		// el mapa menu está compuesto por categoría = { nombreProducto: Producto} 
		for (String categoria : menu.keySet()) {
			String archivoBase = (categoria.equals("bebidas")) ? archivoBebidas : archivoPlatos;
			for (ProductoMenu producto : menu.get(categoria).values()) {
				String nombre = producto.getNombre();
				String precio = producto.getPrecio().toString();
				String rangoDisp = producto.getHoraInicio().toString() + "-" + producto.getHoraFin().toString();
				String llevableAHabitacion = producto.isLlevableAHabitacion().toString();
				registrarProducto(archivoBase, nombre, precio, rangoDisp, llevableAHabitacion);
			}
		}
	}
}
