package modelo.habitaciones;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

public class ControladorHabitaciones {

	private Habitacion habitacionActual;
	private CargadorHabitaciones cargadorHabitaciones;

	public ControladorHabitaciones() {

		cargadorHabitaciones = new CargadorHabitaciones();
	}

	public void cargarHabitaciones(String rutaArchivo) throws IOException {
		cargadorHabitaciones.cargarHabitaciones(rutaArchivo);
	}

	public void consultarHabitacionDisponible(String tipoHabitacion, int capacidad, String SfechaInicio,
			String SfechaFin) {

		HashMap<String, HashMap<Integer, ArrayList<Habitacion>>> mapaTipos = cargadorHabitaciones.getMapaHabitaciones();
		HashMap<Integer, ArrayList<Habitacion>> mapaCapacidades = mapaTipos.get(tipoHabitacion);
		ArrayList<Habitacion> habitaciones = mapaCapacidades.get(capacidad);

		LocalDate fechaInicio = LocalDate.parse(SfechaInicio);
		LocalDate fechaFin = LocalDate.parse(SfechaFin);

		boolean habitacionHallada = false;
		Habitacion habDisponible = null;
		int i = 0;
		while ((i < habitaciones.size()) && !habitacionHallada) {
			Habitacion habActual = habitaciones.get(i);

			if (habActual.getReservas().size() == 0) {
				habDisponible = habActual;
				habitacionHallada = true;
			} else {
				for (Reserva reserva : habActual.getReservas()) {
					LocalDate inicioReserva = reserva.getFechaInicio();
					LocalDate finReserva = reserva.getFechaFin();

					if ((fechaInicio.isBefore(inicioReserva) || fechaInicio.isEqual(inicioReserva))
							|| (fechaFin.isAfter(finReserva) || fechaFin.isEqual(finReserva))) {

						habDisponible = habActual;
						habitacionHallada = true;
					}
				}
			}
			i++;
		}
		this.habitacionActual = habDisponible;
	}

	public Habitacion getHabitacionActual() {
		return habitacionActual;
	}

}
