package modelo.tarifas_habitaciones;

import java.io.IOException;
import java.time.LocalDate;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CargadorTarifaHabitacion {

	private Map<String, Map<String, Map<String, Float>>> mapaTarifas = new HashMap<>();

	private List<TarifaHabitacion> listaTarifas = new ArrayList<>();

	public void cargarTarifas(String rutaArchivo) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
			String linea = br.readLine();
			linea = br.readLine();
			while (linea != null) {
				String[] parametros = linea.split(";");
				String tipoHabitacion = parametros[0];
				LocalDate fechaInicio = LocalDate.parse(parametros[1]);
				LocalDate fechaFin = LocalDate.parse(parametros[2]);
				String rango = parametros[1] + ";" + parametros[2];
				String dias = parametros[3];
				Float precio = Float.parseFloat(parametros[4]);
				Map<String, Map<String, Float>> mapaRangos = mapaTarifas.computeIfAbsent(tipoHabitacion,
						k -> new HashMap<>());
				Map<String, Float> mapaDias = mapaRangos.computeIfAbsent(rango, k -> new HashMap<>());
				for (String dia : dias.split("-")) {
					mapaDias.put(dia, precio);
				}
				TarifaHabitacion tarifa = new TarifaHabitacion(tipoHabitacion, fechaInicio, fechaFin, dias, precio);
				listaTarifas.add(tarifa);
				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public Map<String, Map<String, Map<String, Float>>> getMapaTarifas() {
		return mapaTarifas;
	}
}