package modelo.tarifas_habitaciones;

import java.io.IOException;
import java.time.LocalDate;

public class ControladorTarifaHabitacion {
	
	private CalendarioTarifasHab calendarioTarifas;

	public ControladorTarifaHabitacion() {
		calendarioTarifas = new CalendarioTarifasHab();
	}

	public void cargarTarifas(String rutaArchivo) throws IOException {
		CargadorTarifaHabitacion cargadorTarifas = new CargadorTarifaHabitacion();
		cargadorTarifas.cargarTarifas(rutaArchivo,calendarioTarifas);
	}

	public float consultarTarifaHabitacion(String tipoHabitacion, String fechaInicioString, String fechaFinString) {
		LocalDate fechaInicio = LocalDate.parse(fechaInicioString);
		LocalDate fechaFin = LocalDate.parse(fechaFinString);
		Float precio = 0f;
		LocalDate fecha = fechaInicio;
		while (fecha.isBefore(fechaFin) || fecha.equals(fechaFin)) {
			precio += calendarioTarifas.consultarTarifaHabitacion(tipoHabitacion, fecha.toString());
			fecha = fecha.plusDays(1);
		}
		return precio;
	}
}
