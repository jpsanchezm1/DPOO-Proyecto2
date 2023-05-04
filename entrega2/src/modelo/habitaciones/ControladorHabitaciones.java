package modelo.habitaciones;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

//Se encarga de generar el inventario de habitaciones. Esta clase es usada por el admin.
public class ControladorHabitaciones {

	//private Habitacion habitacionActual;
	
	//guardamos por id todas las habitaciones
	private HashMap<Integer, Habitacion> habitaciones;

	public ControladorHabitaciones() {

		habitaciones = new HashMap<>();
	}

	public void cargarHabitaciones(String rutaArchivo) throws IOException {
		CargadorHabitaciones cargador = new CargadorHabitaciones();
		cargador.cargarHabitaciones(rutaArchivo, habitaciones);
	}
	
	public void crearHabitacion(int id, String tipo, int capacidad, String descripcion, boolean balcon, boolean vista, boolean cocina) {
		Habitacion nuevaHab = new Habitacion(id, tipo, capacidad, descripcion, balcon, vista, cocina);
		habitaciones.put(id, nuevaHab);
	}
	
	public void actualizarHabitaciones(String rutaArchivo) throws IOException {
		cargarHabitaciones(rutaArchivo);
	}
	
	public HashMap<Integer, Habitacion> getHabitaciones(){
		return habitaciones;
	}

}
