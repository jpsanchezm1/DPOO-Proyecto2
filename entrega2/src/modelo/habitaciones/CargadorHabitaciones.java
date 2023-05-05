package modelo.habitaciones;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CargadorHabitaciones {

	public CargadorHabitaciones() {
	}

	public void cargarHabitaciones(String rutaArchivo, HashMap<Integer, Habitacion> mapaHabitaciones) throws IOException {

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

			Habitacion habitacionActual = new Habitacion(id, tipoHabitacion, capacidad, camas, balcon, vista, cocina);

			mapaHabitaciones.put(id, habitacionActual);

			linea = br.readLine();
		}
		br.close();
	}

}
