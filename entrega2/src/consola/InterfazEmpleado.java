package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Map;

import modelo.huespedes.Huesped;
import modelo.consumos.ConsumoRestaurante;
import coordinadores.CoordinadorEmpleado;
import modelo.servicios.ProductoMenu;
import modelo.servicios.Servicio;

public class InterfazEmpleado {

	CoordinadorEmpleado coordinador;

	public InterfazEmpleado(Map<String, Huesped> mapaHuespedes, Map<String, ProductoMenu> mapaProductosMenu,
			Map<String, Servicio> mapaServicios) throws IOException {
		this.coordinador = new CoordinadorEmpleado(mapaHuespedes, mapaProductosMenu, mapaServicios);
	}

	public void mostrarOpcionesEmpleado() {
		System.out.println("\n*** Property Managament System ***\n");
		System.out.println("1. Registrar consumo");
		System.out.println("2. Salir. ");
	}

	public void ejecutarInterfazEmpleado() {

		boolean continuar = true;

		while (continuar) {
			try {
				mostrarOpcionesEmpleado();

				int opcionInterfaz = Integer.parseInt(input("Por favor seleccione una opción "));

				if (opcionInterfaz == 1) {
					System.out.println("*** Registro de consumo ***\n");

				} else if (opcionInterfaz == 2) {
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

	public void ejecutarRegistroDeConsumo() {
	String consumoDeRestaurante = input("¿Es el consumo relacionado a un producto del restaurante? si/no");
	tipoConsumo = (ConsumoRestaurante.equals("si")) ? ""
	coordinador.registrarConsumo(tipoConsumo, huespedString, referencia, pagoString);
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
