package consola;

import java.io.IOException;

import modelo.autenticador.Autenticador;

public class Hotel {

	public Hotel() {
	}

	public static void main(String[] args) throws IOException {

		Hotel hotel = new Hotel();

		Autenticador Autenticador = new Autenticador();

		hotel.crearAutenticadores(Autenticador);

		ConsolaPMS consola = new ConsolaPMS();

		consola.iniciarAplicacion(Autenticador);
	}

	public void crearAutenticadores(Autenticador Autenticador) throws IOException {
		String rutaAdmin = Autenticador.getRutaArchivoAdministradores();
		String rutaRecep = Autenticador.getRutaArchivoRecepcionistas();
		String rutaEmpleadoGen = Autenticador.getRutaArchivoEmpleadosGenerales();

		Autenticador.crearMapaAdministradores(rutaAdmin);
		Autenticador.crearMapaRecepcionistas(rutaRecep);
		Autenticador.crearMapaEmpleadosGenerales(rutaEmpleadoGen);
	}

}