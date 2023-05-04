package modelo.habitaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;

import modelo.huespedes.Huesped;

//Utiliza el inventario de habitaciones para encargarse de las reservas. Esta clase es usada por el recepcionista.
public class ControladorReserva {

	private ArrayList<Reserva> reservasActivas;

	private HashMap<Integer, Habitacion> inventario;

	// guardamos por rango las habitaciones que tienen al menos una reserva
	private HashMap<Integer, ArrayList<String>> habitacionesRes;

	public ControladorReserva(HashMap<Integer, Habitacion> inventario) {
		this.inventario = inventario;
	}

	public void crearReserva(Huesped representante, String fechaInicio, String fechaFin,
			ArrayList<Huesped> acompanantes) {

		Reserva reserva = new Reserva(representante, fechaInicio, fechaFin, acompanantes);
		reservasActivas.add(reserva);

	}

	public void reservarHabitacion(int idHab, Reserva reserva) {
		reserva.aniadirHabitacion(idHab);
		habitacionesRes.
	}

	public void añadirCuotaTotal(Float float1) {
		reservaActual.sumarACuotaTotal(float1);
	}

	// Recibe un rango de fechas y retorna una lista con los id's de las
	// habitaciones disponibles en dicho rango
	public ArrayList<Integer> consultarHabitacionesDisponibles(String SfechaInicio, String SfechaFin) {

		ArrayList<Integer> habitacionesEncontradas = new ArrayList<>();

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
	}

}