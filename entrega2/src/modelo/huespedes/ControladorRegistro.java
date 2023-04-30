package modelo.huespedes;

import java.util.ArrayList;

import modelo.habitaciones.Reserva;

public class ControladorRegistro {

	private Grupo grupoActual;
	private ArrayList<Huesped> huespedesRegistrados;

	public void crearGrupo(String infoHuesped) {
		String[] partes = infoHuesped.split(";");

		Huesped representante = new Huesped(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]),
				partes[3]);
		Grupo grupo = new Grupo(representante);

		representante.setGrupo(grupo);
		huespedesRegistrados.add(representante);

		this.grupoActual = grupo;
	}

	public void añadirAcompanante(String infoAcompanante) {
		String[] partes = infoAcompanante.split(";");

		Huesped acompanante = new Huesped(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]),
				partes[3]);
		this.grupoActual.añadirAcompanante(acompanante);
		acompanante.setGrupo(this.grupoActual);
		huespedesRegistrados.add(acompanante);
	}

	public void setReservaGrupo(Reserva reserva) {
		this.grupoActual.setReserva(reserva);
	}

}
