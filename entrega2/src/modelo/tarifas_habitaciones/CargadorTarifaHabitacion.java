package modelo.tarifas_habitaciones;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class CargadorTarifaHabitacion {

	public void agregarTarifa(String infoTarifa, CalendarioTarifasHab calendarioTarifas) {

		String[] parametros = infoTarifa.split(";");
		String tipoHabitacion = parametros[0];
		String rango = parametros[1] + ";" + parametros[2];
		String dias = parametros[3];
		Float precio = Float.parseFloat(parametros[4]);
		Map<String, Map<String, Float>> mapaRangos = calendarioTarifas.getMapaCalendario()
				.computeIfAbsent(tipoHabitacion, k -> new HashMap<>());
		Map<String, Float> mapaDias = mapaRangos.computeIfAbsent(rango, k -> new HashMap<>());
		for (String dia : dias.split("-")) {
			mapaDias.put(dia, precio);
		}
	}

	public void cargarTarifas(String rutaArchivo, CalendarioTarifasHab calendarioTarifas) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea = br.readLine();
			linea = br.readLine();
			while (linea != null) {
				agregarTarifa(linea, calendarioTarifas);
				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
}