package modelo.habitaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditorHabitaciones {

	public void guardarHabitacion(String infoHabitacion, String rutaArchivo) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			editor.newLine();
			editor.write(infoHabitacion);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
