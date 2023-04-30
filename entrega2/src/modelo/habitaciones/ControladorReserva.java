package modelo.habitaciones;

import java.util.ArrayList;

import modelo.huespedes.Huesped;

public class ControladorReserva {

	private Reserva reservaActual;
	private ArrayList<Reserva> reservasActivas;

	public void crearReserva(String fechaInicio, String fechaFin) {

		Reserva reserva = new Reserva(fechaInicio, fechaFin);
		reservasActivas.add(reserva);

		reservaActual = reserva;
	}

	public void añadirHabitacion(Habitacion habitacion) {
		reservaActual.añadirHabitacion(habitacion);
	}

	public void añadirCuotaTotal(Float float1) {
		reservaActual.sumarACuotaTotal(float1);
	}

	public void añadirRepresentante(Huesped representante) {
		reservaActual.setRepresentante(representante);
	}

	public Reserva getReservaActual() {
		return reservaActual;
	}

	public void detenerReservaEnCurso() {
		reservasActivas.remove(reservaActual);
		reservaActual = null;
	}

}