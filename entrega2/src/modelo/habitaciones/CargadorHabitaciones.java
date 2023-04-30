package modelo.habitaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CargadorHabitaciones {

	private HashMap<String, HashMap<Integer, ArrayList<Habitacion>>> mapaHabitaciones;
	private ArrayList<Habitacion> habitaciones;

	public CargadorHabitaciones() {

		mapaHabitaciones = new HashMap<String, HashMap<Integer, ArrayList<Habitacion>>>();
		habitaciones = new ArrayList<Habitacion>();
	}

	public HashMap<String, HashMap<Integer, ArrayList<Habitacion>>> getMapaHabitaciones() {
		return mapaHabitaciones;
	}

	public ArrayList<Habitacion> getHabitaciones() {
		return habitaciones;
	}

	public void cargarHabitaciones(String rutaArchivo) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader(new File(rutaArchivo)));
		String linea = br.readLine();

		while (linea != null) {
			String[] partes = linea.split(";");
			int id = Integer.parseInt(partes[0]);
			String tipoHabitacion = partes[1];
			int capacidad = Integer.parseInt(partes[2]);
			String camas = partes[3];
			boolean balcon = partes[4].equals("si");
			boolean vista = partes[5].equals("si");
			boolean cocina = partes[6].equals("si");

			Habitacion habitacionActual = new Habitacion(id, capacidad, tipoHabitacion, camas, balcon, vista, cocina);

			HashMap<Integer, ArrayList<Habitacion>> mapaCapacidades = mapaHabitaciones.computeIfAbsent(tipoHabitacion,
					k -> new HashMap<>());
			ArrayList<Habitacion> habitaciones = mapaCapacidades.computeIfAbsent(capacidad, k -> new ArrayList<>());
			habitaciones.add(habitacionActual);
			this.habitaciones.add(habitacionActual);

			linea = br.readLine();
		}
		br.close();
	}

}
