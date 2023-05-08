package modelo.reservas;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditorReservas {

	public void guardarReserva(int idRepre, Reserva reserva, String rutaArchivo) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {

			String infoReserva = "" + idRepre;
			infoReserva += ";" + reserva.getFechaInicio();
			infoReserva += ";" + reserva.getFechaFin();
			infoReserva += ";" + reserva.isActiva();

			infoReserva += ";";
			for (int idHab : reserva.getHabitaciones()) {
				infoReserva += idHab + "-";
			}
			String newInfoReserva = infoReserva.substring(0, infoReserva.length() - 1);

			editor.newLine();
			editor.write(newInfoReserva);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
