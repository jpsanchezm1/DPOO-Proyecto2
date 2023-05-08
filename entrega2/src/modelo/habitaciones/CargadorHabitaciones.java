package modelo.habitaciones;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class CargadorHabitaciones {

	public void cargarHabitaciones(String rutaArchivo, HashMap<Integer, Habitacion> mapaHabitaciones)
			throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = br.readLine();

			while (linea != null) {
				String[] partes = linea.split(";");
				int id = Integer.parseInt(partes[0]);
				String tipoHabitacion = partes[1];
				int capacidad = Integer.parseInt(partes[2]);
				String camas = partes[3];
				boolean balcon = partes[4].equals("true");
				boolean vista = partes[5].equals("true");
				boolean cocina = partes[6].equals("true");

				Habitacion habitacionActual = new Habitacion(id, tipoHabitacion, capacidad, camas, balcon, vista,
						cocina);

				mapaHabitaciones.put(id, habitacionActual);

				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
