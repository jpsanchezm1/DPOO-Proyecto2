package modelo.reservas;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CargadorReservas {

	public void cargarReservas(String rutaArchivo, HashMap<Integer, Reserva> reservas) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = br.readLine();

			while (linea != null) {
				String[] partes = linea.split(";");
				int idRepre = Integer.parseInt(partes[0]);
				String fechaInicio = partes[1];
				String fechaFin = partes[2];
				boolean activa = partes[3].equals("true");
				ArrayList<Integer> habitaciones = new ArrayList<>();

				String[] partesHabitaciones = partes[4].split("-");
				for (String idHab : partesHabitaciones) {
					habitaciones.add(Integer.parseInt(idHab));
				}

				Reserva reservaActual = new Reserva(idRepre, fechaInicio, fechaFin, activa, habitaciones);

				reservas.put(idRepre, reservaActual);

				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
