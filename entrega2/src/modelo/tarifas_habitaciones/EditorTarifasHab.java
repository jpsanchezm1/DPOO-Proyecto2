package modelo.tarifas_habitaciones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class EditorTarifasHab {

	public void guardarTarifa(String infoTarifa, String rutaArchivo) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			editor.newLine();
			editor.write(infoTarifa);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
