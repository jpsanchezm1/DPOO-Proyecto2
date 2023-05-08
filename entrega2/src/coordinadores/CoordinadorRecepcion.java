package coordinadores;

import java.io.IOException;

import modelo.habitaciones.ControladorHabitaciones;
import modelo.huespedes.ControladorHuespedes;
import modelo.pagos.ControladorPagos;
import modelo.reservas.ControladorReserva;

public class CoordinadorRecepcion {

	// Hay que definir el constructor y como se pasa el inventario a contrReserva

	private ControladorReserva contrReserva;

	private ControladorHuespedes controladorHuespedes;

	private ControladorHabitaciones contrHabitacion;
	
	private ControladorPagos controladorPagos;
	
	public CoordinadorRecepcion() throws IOException {
		super();
		this.controladorHuespedes = new ControladorHuespedes();
		this.contrHabitacion = new ControladorHabitaciones();
		this.contrReserva = new ControladorReserva(contrHabitacion.getHabitaciones());
		this.controladorPagos = new ControladorPagos();
	}
	
	public ControladorHuespedes getControladorHuespedes() {
		return controladorHuespedes;
	}
	
	public ControladorPagos getControladorPagos() {
		return controladorPagos;
	}

	public void realizarReserva() {
		System.out.println("Aún no se ha definido");
	}

	public void registrarSalida() {
		System.out.println("Aún no se ha definido");
	}

	public void consultarHabitaciones() {
		System.out.println("Aún no se ha definido");
	}
}
