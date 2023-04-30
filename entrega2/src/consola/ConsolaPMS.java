package consola;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import modelo.autenticador.Autenticador;

public class ConsolaPMS {

	private InterfazAdministrador interfazAdministradores;
	private InterfazEmpleado interfazEmpleados;
	// private InterfazRecepcion interfazRecepcion;
	private Autenticador autenticador;

	public ConsolaPMS() throws IOException {
		this.interfazAdministradores = new InterfazAdministrador();
		this.interfazEmpleados = new InterfazEmpleado();
		this.autenticador = new Autenticador();
		autenticador.crearAutenticadores();
	}

	public static void main(String[] args) throws IOException {

		ConsolaPMS consola = new ConsolaPMS();

		consola.iniciarAplicacion();
	}

	public void mostrarInicio() {
		System.out.println("*** Bienvenido al sistema de Gestión de Propiedad ***\n");
		System.out.println("1. Ingresar");
		System.out.println("2. Registrarse");
		System.out.println("3. Salir de la aplicación");
	}

	public void mostrarMenuRoles() {
		System.out.println("------------------------------------------------------\n");
		System.out.println("1. Administrador");
		System.out.println("2. Recepcionista");
		System.out.println("3. Empleado general");
	}

	public void iniciarAplicacion() throws IOException {

		boolean continuar = true;
		CoordinadorHotel CH = new CoordinadorHotel();

		while (continuar) {
			try {
				mostrarInicio();
				int opcionAutenticador = Integer.parseInt(input("Por favor seleccione una opción "));

				if (opcionAutenticador == 1) {
					validarIngreso(CH, autenticador);
				} else if (opcionAutenticador == 2) {
					registrarUsuario(CH, autenticador);
				} else if (opcionAutenticador == 3) {
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

	public void registrarUsuario(CoordinadorHotel CH, Autenticador autenticador) throws IOException {
		System.out.println("\n*** Crear cuenta PMS ***");
		mostrarMenuRoles();

		// elegir rol
		int numeroRol = Integer.parseInt(input("Por favor seleccione una opción"));
		String rol = "";
		if (numeroRol == 1) {
			rol = "administrador";
		} else if (numeroRol == 2) {
			rol = "recepcionista";
		} else if (numeroRol == 3) {
			rol = "empleadoGeneral";
		}

		// escribir usuario
		String usuario = input("Ingresar usuario");
		boolean existe = validarUsuario(rol, usuario, autenticador, CH);
		boolean continuar = true;

		while (continuar == true) {
			if (existe == true) {
				System.out.println("El usuario que eligió ya existe.\n");
				usuario = input("Ingresar un nombre de usuario nuevo");
				existe = validarUsuario(rol, usuario, autenticador, CH);

			} else if (existe == false) {
				// escribir contraseña
				String contrasena = input("Ingresar contraseña");

				CH.registrarUsuario(rol, usuario, contrasena, autenticador);

				continuar = false;
			}

		}
	}

	public boolean validarUsuario(String rol, String nombreUsuario, Autenticador autenticador, CoordinadorHotel CH) {

		return CH.validarUsuario(rol, nombreUsuario, autenticador, CH);
	}

	public void validarIngreso(CoordinadorHotel CH, Autenticador autenticador) {
		System.out.println("\n*** Ingreso PMS ***");
		mostrarMenuRoles();

		// elegir rol
		int numeroRol = Integer.parseInt(input("Por favor seleccione una opción"));
		String rol = "";
		if (numeroRol == 1) {
			rol = "administrador";
		} else if (numeroRol == 2) {
			rol = "recepcionista";
		} else if (numeroRol == 3) {
			rol = "empleadoGeneral";
		}
		String usuario = input("Ingresar usuario");

		boolean existeUsuario = CH.validarUsuario(rol, usuario, autenticador, CH);

		boolean continuar = true;

		while (continuar == true) {
			if (existeUsuario == false) {
				System.out.println("El usuario ingresado no existe.\n");
				usuario = input("Ingresar un nombre de usuario nuevo");
				existeUsuario = validarUsuario(rol, usuario, autenticador, CH);
			} else if (existeUsuario == true) {

				String contrasena = input("Ingresar contraseña");
				boolean existeContrasena = CH.validarContrasena(rol, usuario, contrasena, autenticador, CH);

				if (existeContrasena == true) {

					if (rol == "administrador") {
						interfazAdministradores.ejecutarInterfazAdministrador();
					} else if (rol == "recepcionista") {
						// aqui va la coneccion de administrador
					} else if (rol == "empleadoGeneral") {
						interfazEmpleados.ejecutarInterfazEmpleado();
					}

					continuar = false;

				} else if (existeContrasena == false) {
					System.out.println("Contraseña incorrecta.\n");
					continuar = false;
				}

			}
		}
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
