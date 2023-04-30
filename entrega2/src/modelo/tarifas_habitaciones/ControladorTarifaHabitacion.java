package modelo.tarifas_habitaciones;

import modelo.utilidades.Utilidades;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.Iterator;

public class ControladorTarifaHabitacion {

	private Float precioActual;
	private CargadorTarifaHabitacion cargadorTarifas;

	public ControladorTarifaHabitacion() {
		this.cargadorTarifas = new CargadorTarifaHabitacion();
	}

	public void cargarTarifas(String rutaArchivo) throws IOException {
		cargadorTarifas.cargarTarifas(rutaArchivo);
	}

	private Float consultarTarifaHabitacion(String tipoHabitacion, String fechaString) {
		Map<String, Map<String, Map<String, Float>>> mapaTipos = this.cargadorTarifas.getMapaTarifas();
		Map<String, Map<String, Float>> mapaTarifas = mapaTipos.get(tipoHabitacion);
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
				String diaDeLaSemana = Utilidades.DIAS_EN_ESPANOL.get(fecha.getDayOfWeek());
				precio = mapaTarifas.get(rango).get(diaDeLaSemana);
				tarifaHallada = true;
			}
		}
		return precio;
	}

	public void consultarTarifaHabitacion(String tipoHabitacion, String fechaInicioString, String fechaFinString) {
		LocalDate fechaInicio = LocalDate.parse(fechaInicioString);
		LocalDate fechaFin = LocalDate.parse(fechaFinString);
		Float precio = 0f;
		LocalDate fecha = fechaInicio;
		while (fecha.isBefore(fechaFin) || fecha.equals(fechaFin)) {
			precio += consultarTarifaHabitacion(tipoHabitacion, fecha.toString());
			fecha = fecha.plusDays(1);
		}
		precioActual = precio;
	}

	public Float getPrecioActual() {
		return precioActual;
	}
}
