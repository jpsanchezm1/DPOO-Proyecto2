package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.habitaciones.ControladorHabitaciones;
import modelo.habitaciones.ControladorReserva;
import modelo.huespedes.ControladorRegistro;
import modelo.tarifas_habitaciones.ControladorTarifaHabitacion;

public class ConsolaRecepcion {

	private ControladorRegistro controladorRegistro;
	private ControladorReserva controladorReserva;
	private ControladorHabitaciones controladorHabitaciones;
	private ControladorTarifaHabitacion controladorTarifas;

	public ConsolaRecepcion() {
		controladorRegistro = new ControladorRegistro();
		controladorReserva = new ControladorReserva();
		controladorHabitaciones = new ControladorHabitaciones();
	}

	public String input(String mensaje) {
		try {
			System.out.print(mensaje + ": ");
			BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
			return reader.readLine();
		} catch (IOException e) {
			System.out.println("Error leyendo de la consola");
			e.printStackTrace();
		}
		return null;
	}

	private void mostrarOpciones() {
		System.out.println("\nOpciones de la aplicación\n");
		System.out.println("1. Crear reserva");
		System.out.println("2. Cancelar reserva");
		System.out.println("3. Registrar salida de grupo");
		System.out.println("4. Generar facturas de grupo");
		System.out.println("5. Consultar inventario");
	}

	public void ejecutarConsola() {

		System.out.println("\nBienvenido al sistema\n");
		mostrarOpciones();

		int opcionSeleccionada = Integer.parseInt(input("\nPor favor seleccione una opcion: "));
		ejecutarOpcion(opcionSeleccionada);
	}

	private void ejecutarOpcion(int os) {

		if (os == 1) {

			System.out.println("\n---Consultar habitaciones disponibles en las fechas determinadas---");
			String fechaInicio = input("\nPor favor escriba la fecha de inicio de la reserva (formato aaaa-mm-dd): ");
			String fechaFin = input("\nPor favor escriba la fecha de fin de la reserva (formato aaaa-mm-dd): ");

			controladorReserva.crearReserva(fechaInicio, fechaFin);

			System.out.println("\n---Información sobre las habitaciones---");
			int numHab = Integer.parseInt(("\nPor favor escriba el número de habitaciones que se requieren: "));

			for (int i = 1; i <= numHab; i++) {
				String tipoHab = input("\nPara la habitacion número " + i + " por favor escriba el tipo de hab: ");
				int capHab = Integer
						.parseInt(("\nPara la habitacion número " + i + " por favor escriba la capacidad: "));
				controladorHabitaciones.consultarHabitacionDisponible(tipoHab, capHab, fechaInicio, fechaFin);
				controladorReserva.añadirHabitacion(controladorHabitaciones.getHabitacionActual());
				controladorTarifas.consultarTarifaHabitacion(tipoHab, fechaInicio, fechaFin);
				controladorReserva.añadirCuotaTotal(controladorTarifas.getPrecioActual());
			}

			if (controladorReserva.getReservaActual().getHabitaciones().contains(null)) {
				while (controladorReserva.getReservaActual().getHabitaciones().contains(null)) {
					controladorReserva.getReservaActual().getHabitaciones().remove(null);
				}
				System.out.println("\nNo se encontraron todas las habitaciones pedidas");
				System.out.println("\nLas habitaciones encontradas son..."
						+ controladorReserva.getReservaActual().getHabitaciones());
				int opcion = Integer.parseInt(("\n¿Se desea continuar con la reserva? (escriba 1 si sí o 2 si no): "));
				if (opcion == 2) {
					controladorReserva.detenerReservaEnCurso();
				} else {
					realizarRegistro();
				}
			} else {
				realizarRegistro();
			}

			ejecutarConsola();
		}

		else if (os == 2) {

		}

		else if (os == 3) {

		}

		else if (os == 4) {

		}

		else if (os == 5) {

		}

		else {
			System.out.println("Por favor seleccione una opción válida.");
		}

	}

	private void realizarRegistro() {
		System.out.println("\n---Registrar representante de la reserva---");
		String infoCliente = input("\nPor favor ingrese el nombre del cliente");
		infoCliente += ";" + input("\nPor favor ingrese el número de identificación del cliente");
		infoCliente += ";" + input("\nPor favor ingrese el número de celular del cliente");
		infoCliente += ";" + input("\nPor favor ingrese el correo electrónico del cliente");
		controladorRegistro.crearGrupo(infoCliente);

		int numPersonas = Integer.parseInt(input(
				"\nPor favor ingrese el número total de personas que se esperan (incluyendo al representante): "));
		if (numPersonas > 1) {
			System.out.println("\n---Registrar acompanantes---");
			for (int i = 0; i < numPersonas; i++) {
				String infoAcompanante = input("\nPor favor ingrese el nombre del cliente");
				infoAcompanante += ";" + input("\nPor favor ingrese el número de identificación del cliente");
				infoAcompanante += ";" + input("\nPor favor ingrese el número de celular del cliente");
				infoAcompanante += ";" + input("\nPor favor ingrese el correo electrónico del cliente");
				controladorRegistro.añadirAcompanante(infoAcompanante);
			}
		}
		controladorRegistro.setReservaGrupo(controladorReserva.getReservaActual());
	}
}
