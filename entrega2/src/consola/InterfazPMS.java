package consola;

import javax.swing.JFrame;

public class InterfazPMS extends JFrame {


	private static final long serialVersionUID = 1L;

	private Inicio panelInicio;
	
	public InterfazPMS() {

		setTitle("Property Managament System");
		setSize(700, 600);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panelInicio = new Inicio(this);
		
		add(panelInicio);
	}

	public static void main(String[] args) {
		InterfazPMS interfaz = new InterfazPMS();
		interfaz.setVisible(true);
	}
}
