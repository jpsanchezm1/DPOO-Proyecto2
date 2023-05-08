package consola;

import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import consola.administracion.InterfazAdministracion;
import consola.empleado.InterfazEmpleado;
import consola.inicio.Inicio;
import consola.inicio.Registro;
import coordinadores.CoordinadorAdministrador;
import coordinadores.CoordinadorEmpleado;
import coordinadores.CoordinadorRecepcion;
import modelo.autenticador.Autenticador;

public class InterfazPMS extends JFrame {

	private static final long serialVersionUID = 1L;

	private Inicio panelInicio;
	private Registro panelRegistro;
	private InterfazEmpleado interfazEmpleado;
	private Autenticador autenticador = new Autenticador();
	private CoordinadorAdministrador coordinadorAdministrador = new CoordinadorAdministrador();
	private CoordinadorRecepcion coordinadorRecepcion = new CoordinadorRecepcion();
	private CoordinadorEmpleado coordinadorEmpleado;

	public InterfazPMS() throws IOException {

		this.coordinadorEmpleado = new CoordinadorEmpleado(coordinadorRecepcion.getControladorHuespedes(),
				coordinadorRecepcion.getControladorPagos(), coordinadorAdministrador.mapaServicios(),
				coordinadorAdministrador.mapaProductosMenu());

		this.interfazEmpleado = new InterfazEmpleado(this);

		setTitle("Property Managament System");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelInicio = new Inicio(this);
		panelRegistro = new Registro(this);

		add(panelInicio);

		autenticador.crearAutenticadores();
	}

	public static void main(String[] args) throws IOException {
		InterfazPMS interfaz = new InterfazPMS();
		interfaz.setVisible(true);
	}

	public void mostrarPanelRegistro() {
		panelRegistro.setVisible(true);
	}

	public void registrarUsuario(String rol, String nombreUsuario, String contrasena) throws IOException {
		autenticador.registrarUsuario(rol, nombreUsuario, contrasena);
		if (rol.equals("empleado")) {
			dispose();
			interfazEmpleado.setVisible(true);
		}
	}

	public void iniciarSesion(String rol, String usuario, String contrasenia) throws IOException {

		boolean validarUsuario = autenticador.validarUsuario(rol, usuario);
		boolean validarContrasena = autenticador.validarContrasena(rol, usuario, contrasenia);

		if (validarContrasena && validarUsuario) {

			if (rol.equals("administrador")) {

				dispose();
				InterfazAdministracion interfazAdmin = new InterfazAdministracion();
				interfazAdmin.setVisible(true);

			} else if (rol.equals("recepcionista")) {

			} else if (rol.equals("empleado")) {
				dispose();
				interfazEmpleado.setVisible(true);
			}

		} else {
			JOptionPane.showMessageDialog(null, "Usuario y/o contraseña inválidos", "Error de autenticación",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public void registrarConsumo(String categoria,String id,String referencia, String pago) {
		coordinadorEmpleado.registrarConsumo(categoria, id, referencia, pago);
	}
}
