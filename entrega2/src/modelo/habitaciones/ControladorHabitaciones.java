package modelo.habitaciones;

import java.io.IOException;
import java.util.HashMap;

//Se encarga de generar el inventario de habitaciones. Esta clase es usada por el admin.
public class ControladorHabitaciones {

	// guardamos por id todas las habitaciones
	private HashMap<Integer, Habitacion> habitaciones;

	private String archivoHabitaciones = "./data/habitaciones/habitaciones.txt";

	public ControladorHabitaciones() throws IOException {

		habitaciones = new HashMap<>();
		recuperarInformacion();
	}

	public void cargarHabitaciones(String rutaArchivo) throws IOException {
		CargadorHabitaciones cargador = new CargadorHabitaciones();
		cargador.cargarHabitaciones(rutaArchivo, habitaciones);
	}

	public void crearHabitacion(String infoHabitacion) {
		String[] partes = infoHabitacion.split(";");
		int id = Integer.parseInt(partes[0]);
		String tipoHabitacion = partes[1];
		int capacidad = Integer.parseInt(partes[2]);
		String camas = partes[3];
		boolean balcon = partes[4].equals("si");
		boolean vista = partes[5].equals("si");
		boolean cocina = partes[6].equals("si");

		Habitacion nuevaHab = new Habitacion(id, tipoHabitacion, capacidad, camas, balcon, vista, cocina);
		habitaciones.put(id, nuevaHab);
		EditorHabitaciones editorHabitaciones = new EditorHabitaciones();
		editorHabitaciones.guardarHabitacion(infoHabitacion, archivoHabitaciones);
	}

	// Recibe un archivo con informacion modificada de habitaciones existentes e
	// incorpora dichas modificaciones
	public void actualizarHabitaciones(String rutaArchivo) throws IOException {
		cargarHabitaciones(rutaArchivo);
	}

	private void recuperarInformacion() throws IOException {
		CargadorHabitaciones cargador = new CargadorHabitaciones();
		cargador.cargarHabitaciones(archivoHabitaciones, habitaciones);
	}

	public HashMap<Integer, Habitacion> getHabitaciones() {
		return habitaciones;
	}

}
