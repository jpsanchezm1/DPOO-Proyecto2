package modelo.tarifas_habitaciones;

import java.io.IOException;
import java.time.LocalDate;

public class ControladorTarifaHabitacion {

	private CalendarioTarifasHab calendarioTarifas;

	private String archivoTarifas = "./data/tarifas_habitaciones/tarifasHabs.txt";

	public ControladorTarifaHabitacion() throws IOException {
		calendarioTarifas = new CalendarioTarifasHab();
		recuperarInformacion();
	}

	public void configurarTarifa(String infoTarifa) {
		CargadorTarifaHabitacion cargadorTarifas = new CargadorTarifaHabitacion();
		EditorTarifasHab editorTarifas = new EditorTarifasHab();
		cargadorTarifas.agregarTarifa(infoTarifa, calendarioTarifas);
		editorTarifas.guardarTarifa(infoTarifa, archivoTarifas);
	}

	public void cargarTarifas(String rutaArchivo) throws IOException {
		CargadorTarifaHabitacion cargadorTarifas = new CargadorTarifaHabitacion();
		cargadorTarifas.cargarTarifas(rutaArchivo, calendarioTarifas);
	}

	// Recibe el tipo de habitacion y el rango de fechas y retorna el precio total
	// de la tarifa que aplica
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

	private void recuperarInformacion() throws IOException {
		CargadorTarifaHabitacion cargadorTarifas = new CargadorTarifaHabitacion();
		cargadorTarifas.cargarTarifas(archivoTarifas, calendarioTarifas);
	}
}
