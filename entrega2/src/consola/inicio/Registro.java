package consola.inicio;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class Registro extends JDialog {

	private static final long serialVersionUID = 1L;
	private PanelFormularioRegistro panelFormularioRegistro;

	public Registro() {
		setLayout(new BorderLayout());
		setSize(500, 400);
		setLocationRelativeTo(null);

		panelFormularioRegistro = new PanelFormularioRegistro();
		add(panelFormularioRegistro);

	}

}
