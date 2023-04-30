package coordinadores;

import java.io.IOException;

import modelo.habitaciones.ControladorHabitaciones;
import modelo.servicios.ControladorRestaurante;
import modelo.servicios.ControladorServicios;
import modelo.tarifas_habitaciones.ControladorTarifaHabitacion;

public class CoordinadorAdministrador {

	public CoordinadorAdministrador() throws IOException {
		ControladorHabitaciones contrHab = new ControladorHabitaciones();
		ControladorTarifaHabitacion contrTarifaHabi = new ControladorTarifaHabitacion();
		ControladorServicios contrServicios = new ControladorServicios();
		ControladorRestaurante contrResta = new ControladorRestaurante();

	}

	public void ejecutarOpcionUno() {

	}

	public void ejecutarOpcionDos() {

	}

	public void ejecutarOpcionTres() {

	}

	public void ejecutarOpcionCuatro() {

	}

	public void ejecutarOpcionCinco() {

	}

	public void ejecutarOpcionSeis() {

	}

	public void ejecutarOpcionSiete() {

	}

	public void ejecutarOpcionOcho() {

	}

	public void ejecutarOpcionNueve() {

	}

}
