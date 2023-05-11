package consola.inicio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import consola.InterfazPMS;

public class Inicio extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private InterfazPMS principalInterfazPMS;
	private static final String CREAR_CUENTA = "Crear cuenta";
	private static final String INICIAR_SESION = "Iniciar sesion";
	private PanelFormulario panelForm;

	public Inicio(InterfazPMS p) {

		principalInterfazPMS = p;
		

		// Panel principal
		new BorderLayout();
		setBackground(Color.darkGray);
		setPreferredSize(new Dimension(900, 600));

		// Panel Norte
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.darkGray);
		panelNorte.setPreferredSize(new Dimension(800, 80));

		// Panel oeste
		JPanel panelImagen = new JPanel(new GridBagLayout());
		panelImagen.setBackground(Color.darkGray);
		panelImagen.setPreferredSize(new Dimension(320, 340));

		JPanel panelOeste = new JPanel();
		panelOeste.setLayout(new GridBagLayout());
		panelOeste.add(panelImagen);

		ImageIcon logoIcon = new ImageIcon("./data/logoApp/IMG-0410.jpg");
		JLabel etiquetaImagen = new JLabel(logoIcon);
		etiquetaImagen.setPreferredSize(new Dimension(300, 300));
		panelImagen.add(etiquetaImagen);

		// Panel centro
		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.setBackground(Color.darkGray);
		panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		panelCentro.setPreferredSize(new Dimension(320, 340));
		panelCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

		panelForm = new PanelFormulario(this);

		panelCentro.add(panelForm, BorderLayout.CENTER);

		add(panelNorte, BorderLayout.NORTH);
		add(panelOeste, BorderLayout.WEST);
		add(panelCentro, BorderLayout.CENTER);

		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(CREAR_CUENTA)) {
			principalInterfazPMS.mostrarPanelRegistro();
		}
		if (comando.equals(INICIAR_SESION)) {
			
			String usuario = panelForm.getTextField1();
			String rol = panelForm.getRol();
			System.out.println(rol);
			String contrasenia = panelForm.getPasswordField();
			
			try {
				principalInterfazPMS.iniciarSesion(rol, usuario, contrasenia);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	

}
