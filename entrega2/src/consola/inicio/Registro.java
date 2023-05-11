package consola.inicio;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JDialog;

import consola.InterfazPMS;

public class Registro extends JDialog implements ActionListener {

	private static final long serialVersionUID = 1L;
	private PanelFormularioRegistro panelFormularioRegistro;
	private InterfazPMS principaInterfazPMS;
	private static final String REGISTRAR = "Registrar";

	public Registro(InterfazPMS p) {

		principaInterfazPMS = p;

		setLayout(new BorderLayout());
		setSize(500, 400);
		setLocationRelativeTo(null);

		panelFormularioRegistro = new PanelFormularioRegistro(this);
		add(panelFormularioRegistro);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(REGISTRAR)) {

			String usuario = panelFormularioRegistro.getUsuarioTextField();
			String rol = panelFormularioRegistro.getRol();
			String contrasenia = panelFormularioRegistro.getPasswordField();

			try {
				principaInterfazPMS.registrarUsuario(rol, usuario, contrasenia);
				dispose();
			} catch (IOException e1) {
				e1.printStackTrace();
			}

		}

	}

}
