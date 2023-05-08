package modelo.autenticador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

public class Autenticador {

	private String rutaArchivoAdministradores = "./data/usuariosSistema/archivoAdministradores.txt";

	private String rutaArchivoEmpleadosGenerales = "./data/usuariosSistema/archivoEmpleadosGenerales.txt";

	private String rutaArchivoRecepcionistas = "./data/usuariosSistema/archivoRecepcionistas.txt";

	private HashMap<String, String> mapaAdministradores;

	private HashMap<String, String> mapaRecepcionistas;

	private HashMap<String, String> mapaEmpleadoGeneral;

	public void registrarUsuario(String rol, String nombreUsuario, String contrasena) throws IOException {

		if (rol.equals("administrador")) {
			String linea = nombreUsuario + ";" + contrasena;
			File archivoAdministradores = new File(rutaArchivoAdministradores);
			FileWriter fw = new FileWriter(archivoAdministradores, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(linea);
			bw.newLine();

			bw.close();
			mapaAdministradores.put(nombreUsuario, contrasena);
			
		} else if (rol.equals("recepcionista")) {
			String linea = nombreUsuario + ";" + contrasena;
			File archivoRecepcionistas = new File(rutaArchivoRecepcionistas);
			FileWriter fw = new FileWriter(archivoRecepcionistas, true);
			BufferedWriter bw = new BufferedWriter(fw);

			bw.write(linea);
			bw.newLine();
			bw.close();

			mapaRecepcionistas.put(nombreUsuario, contrasena);
			
		} else if (rol.equals("empleadoGeneral")) {
			String linea = nombreUsuario + ";" + contrasena;
			File archivoEmpleadoGeneral = new File(rutaArchivoEmpleadosGenerales);
			FileWriter fw = new FileWriter(archivoEmpleadoGeneral, true);
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(linea);
			bw.newLine();
			bw.close();

			mapaEmpleadoGeneral.put(nombreUsuario, contrasena);
		}
	}

	public boolean validarContrasena(String rol, String nombreUsuario, String contrasena) {

		boolean existe = false;

		if (rol.equals("administrador")) {

			String password = mapaAdministradores.get(nombreUsuario);
			boolean match = password.equals(contrasena);

			if (match == true) {
				existe = true;
			} else {
				existe = false;
			}
		} else if (rol.equals("recepcionista")) {
			String password = mapaRecepcionistas.get(nombreUsuario);
			boolean match = password.equals(contrasena);

			if (match == true) {
				return true;
			} else {
				return false;
			}
		} else if (rol.equals("empleadoGeneral")) {
			String password = mapaEmpleadoGeneral.get(nombreUsuario);
			boolean match = password.equals(contrasena);

			if (match == true) {
				return true;
			} else {
				return false;
			}
		}
		return existe;
	}

	public boolean validarUsuario(String rol, String nombreUsuario) {

		boolean existe = false;

		if (rol.equals("administrador")) {
			boolean vacio = mapaAdministradores.isEmpty();
			if (vacio == false) {
				if (mapaAdministradores.containsKey(nombreUsuario)) {
					existe = true;
				}
			}

		} else if (rol.equals("recepcionista")) {
			boolean vacio = mapaRecepcionistas.isEmpty();
			if (vacio == false) {
				if (mapaRecepcionistas.containsKey(nombreUsuario)) {
					existe = true;
				}
			}
		} else if (rol.equals("empleadoGeneral")) {
			boolean vacio = mapaEmpleadoGeneral.isEmpty();
			if (vacio == false) {
				if (mapaEmpleadoGeneral.containsKey(nombreUsuario)) {
					existe = true;
				}
			}
		}
		return existe;
	}

	public void crearMapaAdministradores(String rutaArchivoAdministradores) throws IOException {
		HashMap<String, String> mapaAdministradores = new HashMap<>();
		File archivoAdministradores = new File(rutaArchivoAdministradores);

		FileReader fr = new FileReader(archivoAdministradores);
		BufferedReader br = new BufferedReader(fr);

		String linea = br.readLine();

		while (linea != null) {

			String[] partes = linea.split(";");

			String usuario = partes[0];
			String contrasena = partes[1];

			mapaAdministradores.put(usuario, contrasena);
			linea = br.readLine();
		}
		this.mapaAdministradores = mapaAdministradores;
		br.close();

	}

	public void crearMapaRecepcionistas(String rutaArchivoRecepcionistas) throws IOException {
		HashMap<String, String> mapaRecepcionistas = new HashMap<>();
		File archivoRecepcionistas = new File(rutaArchivoRecepcionistas);

		FileReader fr = new FileReader(archivoRecepcionistas);
		BufferedReader br = new BufferedReader(fr);

		String linea = br.readLine();

		while (linea != null) {

			String[] partes = linea.split(";");

			String usuario = partes[0];
			String contrasena = partes[1];

			mapaRecepcionistas.put(usuario, contrasena);
			linea = br.readLine();
		}
		this.mapaRecepcionistas = mapaRecepcionistas;
		br.close();
	}

	public void crearMapaEmpleadosGenerales(String rutaArchivoEmpleadosGenerales) throws IOException {
		HashMap<String, String> mapaEmpleadosGenerales = new HashMap<>();
		File archivoEmpleadosGenerales = new File(rutaArchivoEmpleadosGenerales);

		FileReader fr = new FileReader(archivoEmpleadosGenerales);
		BufferedReader br = new BufferedReader(fr);

		String linea = br.readLine();

		while (linea != null) {

			String[] partes = linea.split(";");

			String usuario = partes[0];
			String contrasena = partes[1];

			mapaEmpleadosGenerales.put(usuario, contrasena);
			linea = br.readLine();
		}
		this.mapaEmpleadoGeneral = mapaEmpleadosGenerales;
		br.close();
	}

	public void crearAutenticadores() throws IOException {
		String rutaAdmin = rutaArchivoAdministradores;
		String rutaRecep = rutaArchivoRecepcionistas;
		String rutaEmpleadoGen = rutaArchivoEmpleadosGenerales;

		crearMapaAdministradores(rutaAdmin);
		crearMapaRecepcionistas(rutaRecep);
		crearMapaEmpleadosGenerales(rutaEmpleadoGen);
	}
}
