package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Inicio extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JTextField textField1;
	private static final String CREAR_CUENTA = "Crear cuenta";
	private static final String INICIAR_SESION = "Iniciar sesion";

	public Inicio() {
		// Panel principal
		new BorderLayout();
		setBackground(Color.darkGray);
		setPreferredSize(new Dimension(900, 600));

		// Panel Norte
		JPanel panelNorte = new JPanel();
		panelNorte.setBackground(Color.darkGray);
		panelNorte.setPreferredSize(new Dimension(800, 80));

		// Panel Sur
		JPanel panelSur = new JPanel();
		panelSur.setBackground(Color.darkGray);
		panelSur.setPreferredSize(new Dimension(800, 80));

		// Panel oeste
		JPanel panelOeste = new JPanel();
		panelOeste.setBackground(Color.darkGray);
		panelOeste.setPreferredSize(new Dimension(320, 340));

		ImageIcon logoIcon = new ImageIcon("./data/logoApp/IMG-0410.jpg");
		JLabel etiquetaImagen = new JLabel(logoIcon);
		etiquetaImagen.setPreferredSize(new Dimension(300, 300));
		panelOeste.add(etiquetaImagen);

		// Panel centro
		JPanel panelCentro = new JPanel(new BorderLayout());
		panelCentro.setBackground(Color.darkGray);
		panelCentro.setBorder(BorderFactory.createEmptyBorder(0, 20, 0, 20));
		panelCentro.setPreferredSize(new Dimension(320, 340));
		panelCentro.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1, true));

		// Crear un panel adicional para el formulario
		JPanel panelForm = new JPanel();
		panelForm.setLayout(new BoxLayout(panelForm, BoxLayout.Y_AXIS));
		panelForm.setBackground(Color.WHITE);
		panelForm.setPreferredSize(new Dimension(280, 220));
		panelForm.setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

		panelForm.add(Box.createRigidArea(new Dimension(40, 30)));

		textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(80, 30));
		panelForm.add(textField1);

		panelForm.add(Box.createRigidArea(new Dimension(40, 30)));

		JPasswordField passwordField = new JPasswordField();
		passwordField.setEchoChar('.');
		passwordField.setPreferredSize(new Dimension(40, 30));
		panelForm.add(passwordField);

		panelForm.add(Box.createRigidArea(new Dimension(40, 35)));

		JButton bInicio = new JButton(INICIAR_SESION);
		bInicio.setPreferredSize(new Dimension(100, 40));
		bInicio.setAlignmentX(CENTER_ALIGNMENT);
		panelForm.add(bInicio);

		panelForm.add(Box.createRigidArea(new Dimension(40, 30)));

		// Agrega la línea en la zona norte
		JPanel panelLinea = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.darkGray);
				g.drawLine(0, 0, getWidth(), 0);
			}
		};
		panelLinea.setPreferredSize(new Dimension(0, 1));
		panelLinea.setAlignmentX(CENTER_ALIGNMENT);
		panelForm.add(panelLinea);

		// Crear un panel adicional para el botón de Registro
		JPanel panelBotonRegistro = new JPanel();
		panelBotonRegistro.setLayout(new BoxLayout(panelBotonRegistro, BoxLayout.Y_AXIS));
		panelBotonRegistro.setBackground(Color.WHITE);
		panelBotonRegistro.setPreferredSize(new Dimension(280, 100));

		panelBotonRegistro.add(Box.createRigidArea(new Dimension(40, 25)));

		JButton bCrearCuenta = new JButton(CREAR_CUENTA);
		bCrearCuenta.setPreferredSize(new Dimension(100, 50));
		bCrearCuenta.setAlignmentX(CENTER_ALIGNMENT);
		panelBotonRegistro.add(bCrearCuenta);
		panelBotonRegistro.add(Box.createRigidArea(new Dimension(45, 25)));

		// Agregar los paneles al panel central
		panelCentro.add(panelForm, BorderLayout.CENTER);
		panelCentro.add(panelBotonRegistro, BorderLayout.SOUTH);

		// Panel east
		JPanel panelEste = new JPanel();
		panelEste.setBackground(Color.darkGray);
		panelEste.setOpaque(true);
		panelEste.setPreferredSize(new Dimension(20, 340));

		add(panelNorte, BorderLayout.NORTH);
		add(panelEste, BorderLayout.EAST);
		add(panelOeste, BorderLayout.WEST);
		add(panelCentro, BorderLayout.CENTER);
		add(panelSur, BorderLayout.SOUTH);

		setVisible(true);
	}

}
