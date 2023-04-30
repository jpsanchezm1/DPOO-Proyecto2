package consola;

import java.io.IOException;

import modelo.autenticador.Autenticador;

public class CoordinadorHotel {

	public CoordinadorHotel() {

	}

	public void registrarUsuario(String rol, String nombreUsuario, String contrasena, Autenticador Autenticador)
			throws IOException {
		Autenticador.registrarUsuario(rol, nombreUsuario, contrasena);
	}

	public boolean validarUsuario(String rol, String nombreUsuario, Autenticador Autenticador, CoordinadorHotel CH) {
		return Autenticador.validarUsuario(rol, nombreUsuario);
	}

	public boolean validarContrasena(String rol, String nombreUsuario, String contrasena, Autenticador Autenticador,
			CoordinadorHotel CH) {
		return Autenticador.validarContrasena(rol, nombreUsuario, contrasena);
	}

}