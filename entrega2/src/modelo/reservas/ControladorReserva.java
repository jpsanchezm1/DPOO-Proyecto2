package modelo.reservas;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import modelo.habitaciones.Habitacion;

//Utiliza el inventario de habitaciones para encargarse de las reservas. Esta clase es usada por el recepcionista.
public class ControladorReserva {

	// guardamos las reservas activas por id del representante
	private HashMap<Integer, Reserva> reservasActivas;

	// guardamos las habitaciones que a�n no han sido reservadas
	private Set<Integer> habitacionesDis;

	// guardamos las habitaciones reservadas por id. Los valores son los rangos de
	// las reservas de la habitacion
	// los rangos son de la forma fechaInicio;fechaFin
	private HashMap<Integer, ArrayList<String>> habitacionesRes;

	private String archivoReservas = "./data/reservas/reservas.txt";

	public ControladorReserva(Map<Integer, Habitacion> inventario) throws IOException {
		habitacionesDis = inventario.keySet();
		reservasActivas = new HashMap<>();
		habitacionesRes = new HashMap<>();
		recuperarInformacion();
	}

	public void crearReserva(int idRepresentante, String fechaInicio, String fechaFin) {

		Reserva reserva = new Reserva(idRepresentante, fechaInicio, fechaFin);
		reservasActivas.put(idRepresentante, reserva);

		EditorReservas editorReservas = new EditorReservas();
		editorReservas.guardarReserva(idRepresentante, reserva, archivoReservas);

	}

	public void reservarHabitaciones(ArrayList<Integer> idsHab, Reserva reserva) {
		for (Integer idHab : idsHab) {

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

	// Recibe la id de un huesped y retorna su reserva activa
	public Reserva getReservaPorIdHuesped(int id) {
		return reservasActivas.get(id);
	}

	private void recuperarInformacion() throws IOException {
		CargadorReservas cargadorReservas = new CargadorReservas();
		cargadorReservas.cargarReservas(archivoReservas, reservasActivas);

		for (Reserva reserva : reservasActivas.values()) {
			reservarHabitaciones(reserva.getHabitaciones(), reserva);
		}
	}

}
