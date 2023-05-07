package consola;

import javax.swing.JFrame;

import consola.inicio.Inicio;
import consola.inicio.Registro;

public class InterfazPMS extends JFrame {

	private static final long serialVersionUID = 1L;

	private Inicio panelInicio;
	private Registro panelRegistro;
	
	public InterfazPMS() {

		setTitle("Property Managament System");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelInicio = new Inicio(this);
		panelRegistro = new Registro();
		
		add(panelInicio);
		
	}

	public static void main(String[] args) {
		InterfazPMS interfaz = new InterfazPMS();
		interfaz.setVisible(true);
	}

	public void mostrarPanelRegistro() {
		panelRegistro.setVisible(true);
	}
}
