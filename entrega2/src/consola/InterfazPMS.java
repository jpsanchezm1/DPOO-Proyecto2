package consola;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import consola.administracion.InterfazAdministracion;
import consola.empleado.InterfazEmpleado;
import consola.inicio.Inicio;
import consola.inicio.Registro;
import consola.recepcion.InterfazRecepcion;
import coordinadores.CoordinadorAdministrador;
import coordinadores.CoordinadorEmpleado;
import coordinadores.CoordinadorRecepcion;
import modelo.autenticador.Autenticador;

public class InterfazPMS extends JFrame {

	private static final long serialVersionUID = 1L;

	private Inicio panelInicio;
	private Registro panelRegistro;
	private InterfazEmpleado interfazEmpleado;
	private InterfazAdministracion interfazAdmin;
	private InterfazRecepcion interfazRecep;
	private Autenticador autenticador = new Autenticador();
	private CoordinadorAdministrador coordinadorAdministrador = new CoordinadorAdministrador();
	private CoordinadorRecepcion coordinadorRecepcion = new CoordinadorRecepcion();
	private CoordinadorEmpleado coordinadorEmpleado;

	public InterfazPMS() throws IOException {

		this.coordinadorEmpleado = new CoordinadorEmpleado(coordinadorRecepcion.getControladorHuespedes(),
				coordinadorRecepcion.getControladorPagos(), coordinadorAdministrador.mapaServicios(),
				coordinadorAdministrador.mapaProductosMenu());;

		setTitle("Property Managament System");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelInicio = new Inicio(this);
		panelRegistro = new Registro(this);

		add(panelInicio);

		autenticador.crearAutenticadores();
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					guardarRegistros();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
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
		iniciarSesion(rol, nombreUsuario, contrasena);
	}

	public void iniciarSesion(String rol, String usuario, String contrasenia) throws IOException {

		boolean validarUsuario = autenticador.validarUsuario(rol, usuario);
		boolean validarContrasena = autenticador.validarContrasena(rol, usuario, contrasenia);

		if (validarContrasena && validarUsuario) {

			if (rol.equals("administrador")) {
				dispose();
				interfazAdmin = new InterfazAdministracion(this);
				interfazAdmin.setVisible(true);
			} else if (rol.equals("recepcionista")) {
				dispose();
				interfazRecep = new InterfazRecepcion(this);
				interfazRecep.setVisible(true);
			} else if (rol.equals("empleadoGeneral")) {
				dispose();
				interfazEmpleado = new InterfazEmpleado(this);
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

	public void guardarRegistros() throws IOException {
		coordinadorEmpleado.guardarRegistros();
		coordinadorAdministrador.guardarRegistros();
	}
}
