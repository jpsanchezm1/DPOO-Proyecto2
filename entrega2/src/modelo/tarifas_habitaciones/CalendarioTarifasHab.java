package modelo.tarifas_habitaciones;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import modelo.utilidades.Utilidades;

public class CalendarioTarifasHab {

	// guardamos el precio de las tarifas por tipo de habitacion, luego por rango de
	// fechas en el que actua y luego por dia de la semana
	private Map<String, Map<String, Map<String, Float>>> calendarioTarifas;

	public CalendarioTarifasHab() {
		calendarioTarifas = new HashMap<>();
	}

	public Map<String, Map<String, Map<String, Float>>> getMapaCalendario() {
		return calendarioTarifas;
	}

	// Recibe el tipo de habitacion y la fecha y retorna el precio de la tarifa que
	// aplica
	public Float consultarTarifaHabitacion(String tipoHabitacion, String fechaString) {
		Map<String, Map<String, Float>> mapaTarifas = calendarioTarifas.get(tipoHabitacion);
		Set<String> rangos = mapaTarifas.keySet();
		Iterator<String> rangosIterator = rangos.iterator();
		LocalDate fecha = LocalDate.parse(fechaString);
		Float precio = null;
		boolean tarifaHallada = false;
		while (rangosIterator.hasNext() && !tarifaHallada) {
			String rango = rangosIterator.next();
			String[] fechas = rango.split(";"); // rango es de la forma: "fechaInicio;fechaFin"
			LocalDate fechaInicio = LocalDate.parse(fechas[0]);
			LocalDate fechaFin = LocalDate.parse(fechas[1]);
			boolean fechaContenida = fecha.isAfter(fechaInicio) && fecha.isBefore(fechaFin);
			if (fechaContenida || rango.contains(fechaString)) {
				String diaDeLaSemana = Utilidades.getDiaEnEspaniol(fecha.getDayOfWeek());
				precio = mapaTarifas.get(rango).get(diaDeLaSemana);
				tarifaHallada = true;
			}
		}
		return precio;
	}

}
