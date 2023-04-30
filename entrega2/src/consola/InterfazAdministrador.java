package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import coordinadores.CoordinadorAdministrador;

public class InterfazAdministrador {

	CoordinadorAdministrador coord;

	public InterfazAdministrador() throws IOException {
		CoordinadorAdministrador coord = new CoordinadorAdministrador();
	}

	public void mostrarOpcionesRecepcion() {
		System.out.println("\n*** Property Managament System ***\n");
		System.out.println("1. Cargar archivo de habitaciones. ");
		System.out.println("2. Crear habitación. ");
		System.out.println("3. Editar habitación. ");
		System.out.println("4. Cargar archivo de tarifas para habitaciones. ");
		System.out.println("5. Crear tarifas habitacion. ");
		System.out.println("6. Cargar archivo de tarifas de servicios. ");
		System.out.println("7. Crear tarifas de servicios. ");
		System.out.println("8. Cargar archivo de menú. ");
		System.out.println("9. Crear producto del menú. ");
		System.out.println("10. Salir. ");
	}

	public void ejecutarInterfazAdministrador() {

		boolean continuar = true;

		while (continuar) {
			try {
				mostrarOpcionesRecepcion();

				int opcionInterfaz = Integer.parseInt(input("Por favor seleccione una opción "));

				if (opcionInterfaz == 1) {
					System.out.println("*** Cargar archivo de habitaciones ***\n");

				} else if (opcionInterfaz == 2) {
					System.out.println("*** Crear habitación ***\n");

				} else if (opcionInterfaz == 3) {
					System.out.println("*** Editar habitación ***\n");

				} else if (opcionInterfaz == 4) {
					System.out.println("*** Cargar archivo de tarifas para habitaciones ***\n");
				} else if (opcionInterfaz == 5) {
					System.out.println("*** Crear tarifas habitacion ***\n");
				} else if (opcionInterfaz == 6) {
					System.out.println("*** Cargar archivo de tarifas de servicios ***\n");
				} else if (opcionInterfaz == 7) {
					System.out.println("*** Crear tarifas de servicios ***\n");
				} else if (opcionInterfaz == 8) {
					System.out.println("*** Cargar archivo de menú ***\n");
				} else if (opcionInterfaz == 9) {
					System.out.println("*** Crear producto del menú ***\n");
				} else if (opcionInterfaz == 10) {
					System.out.println("Saliendo de la aplicación ...");
					continuar = false;
				} else {
					System.out.println("Por favor seleccione una opción válida.");
				}
			} catch (NumberFormatException e) {
				System.out.println("Debe seleccionar uno de los números de las opciones.");
			}
		}
	}

	public void ejecutarOpcionUno() {
		coord.ejecutarOpcionUno();
	}

	public void ejecutarOpcionDos() {
		coord.ejecutarOpcionDos();
	}

	public void ejecutarOpcionTres() {
		coord.ejecutarOpcionTres();
	}

	public void ejecutarOpcionCuatro() {
		coord.ejecutarOpcionCuatro();
	}

	public void ejecutarOpcionCinco() {
		coord.ejecutarOpcionCinco();
	}

	public void ejecutarOpcionSeis() {
		coord.ejecutarOpcionSeis();
	}

	public void ejecutarOpcionSiete() {
		coord.ejecutarOpcionSiete();
	}

	public void ejecutarOpcionOcho() {
		coord.ejecutarOpcionOcho();
	}

	public void ejecutarOpcionNueve() {
		coord.ejecutarOpcionNueve();
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

}
