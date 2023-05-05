package modelo.habitaciones;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import modelo.huespedes.Huesped;

//Utiliza el inventario de habitaciones para encargarse de las reservas. Esta clase es usada por el recepcionista.
public class ControladorReserva {

	private ArrayList<Reserva> reservasActivas;

	// guardamos las habitaciones que aún no han sido reservadas
	private Set<Integer> habitacionesDis;

	// guardamos las habitaciones reservadas por id. Los valores son los rangos de
	// las reservas de la habitacion
	// los rangos son de la forma fechaInicio;fechaFin
	private HashMap<Integer, ArrayList<String>> habitacionesRes;

	public ControladorReserva(Map<Integer, Habitacion> inventario) {
		habitacionesDis = inventario.keySet();
		reservasActivas = new ArrayList<>();
		habitacionesRes = new HashMap<>();
	}

	public void crearReserva(Huesped representante, String fechaInicio, String fechaFin,
			ArrayList<Huesped> acompanantes) {

		Reserva reserva = new Reserva(representante, fechaInicio, fechaFin, acompanantes);
		reservasActivas.add(reserva);

	}

	public void reservarHabitacion(int idHab, Reserva reserva) {
		reserva.aniadirHabitacion(idHab);
		habitacionesDis.remove(idHab);

		String rangoFecha = reserva.getFechaInicio() + ";" + reserva.getFechaFin();
		if (habitacionesRes.containsKey(idHab)) {
			habitacionesRes.get(idHab).add(rangoFecha);
		} else {
			ArrayList<String> nuevaReservas = new ArrayList<>();
			nuevaReservas.add(rangoFecha);
			habitacionesRes.put(idHab, nuevaReservas);
		}
	}

	// Recibe un rango de fechas y retorna una lista con los id's de las
	// habitaciones disponibles en dicho rango
	public List<Integer> consultarHabitacionesDisponibles(String SfechaInicio, String SfechaFin) {

		ArrayList<Integer> habitacionesEncontradas = new ArrayList<>();

		if (!(habitacionesDis.isEmpty())) {
			for (Integer id : habitacionesDis) {
				habitacionesEncontradas.add(id);
			}
		}

		LocalDate fechaInicio = LocalDate.parse(SfechaInicio);
		LocalDate fechaFin = LocalDate.parse(SfechaFin);

		for (Entry<Integer, ArrayList<String>> habEntry : habitacionesRes.entrySet()) {

			if (estaDisponible(fechaInicio, fechaFin, habEntry.getValue())) {
				habitacionesEncontradas.add(habEntry.getKey());
			}
		}
		return habitacionesEncontradas;
	}

	private boolean estaDisponible(LocalDate fechaInicio, LocalDate fechaFin, ArrayList<String> rangos) {
		for (String rango : rangos) {
			String[] fechas = rango.split(";");
			LocalDate inicio = LocalDate.parse(fechas[0]);
			LocalDate fin = LocalDate.parse(fechas[1]);
			if ((fechaInicio.isBefore(fin) || fechaInicio.isEqual(fin))
					&& (fechaFin.isAfter(inicio) || fechaFin.isEqual(inicio))) {
				return false;
			}
		}
		return true;
	}
}

