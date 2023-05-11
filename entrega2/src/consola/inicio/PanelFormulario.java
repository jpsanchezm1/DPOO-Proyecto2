package consola.inicio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class PanelFormulario extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String CREAR_CUENTA = "Crear cuenta";
	private static final String INICIAR_SESION = "Iniciar sesion";
	private JTextField textField1;
	private JPasswordField passwordField;
	private JButton bCrearCuenta;
	private JButton bInicio;
	private ButtonGroup tipoUsuario;
	private JRadioButton admin, recep, empleG;
	private JPanel panelLinea;
	private Inicio padreInicio;

	public PanelFormulario(Inicio padreIncio) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(280, 220));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

		this.padreInicio = padreIncio;

		add(Box.createRigidArea(new Dimension(40, 30)));

		JPanel usuarioPanel = new JPanel(new BorderLayout());
		JLabel lUsuario = new JLabel("Usuario: ");
		usuarioPanel.add(lUsuario, BorderLayout.WEST);
		add(usuarioPanel);

		add(Box.createRigidArea(new Dimension(40, 10)));

		textField1 = new JTextField();
		textField1.setPreferredSize(new Dimension(80, 30));
		add(textField1);

		add(Box.createRigidArea(new Dimension(40, 10)));

		JPanel rolPanel = new JPanel(new BorderLayout());
		rolPanel.setLayout(new BoxLayout(rolPanel, BoxLayout.X_AXIS));

		JLabel rolLabel = new JLabel("Rol: ");
		rolPanel.add(rolLabel);

		admin = new JRadioButton("Admin");
		admin.setActionCommand("administrador");
		recep = new JRadioButton("Recepcionista");
		recep.setActionCommand("recepcionista");
		empleG = new JRadioButton("Empleado");
		empleG.setActionCommand("empleadoGeneral");

		tipoUsuario = new ButtonGroup();
		tipoUsuario.add(admin);
		tipoUsuario.add(recep);
		tipoUsuario.add(empleG);

		JPanel buttonsPanel = new JPanel();
		buttonsPanel.setLayout(new BoxLayout(buttonsPanel, BoxLayout.Y_AXIS));
		buttonsPanel.add(admin);
		buttonsPanel.add(recep);
		rolPanel.add(buttonsPanel);

		rolPanel.add(empleG, BorderLayout.LINE_START);

		add(rolPanel);

		add(Box.createRigidArea(new Dimension(40, 10)));

		JPanel contraseniaPanel = new JPanel(new BorderLayout());
		JLabel lContrasenia = new JLabel("Contrasenia: ");
		contraseniaPanel.add(lContrasenia, BorderLayout.WEST);
		add(contraseniaPanel);

		add(Box.createRigidArea(new Dimension(40, 10)));

		passwordField = new JPasswordField();
		passwordField.setEchoChar('•');
		passwordField.setPreferredSize(new Dimension(40, 30));
		add(passwordField);

		add(Box.createRigidArea(new Dimension(40, 10)));

		bInicio = new JButton(INICIAR_SESION);
		bInicio.setPreferredSize(new Dimension(100, 40));
		bInicio.addActionListener(this.padreInicio);
		bInicio.setAlignmentX(CENTER_ALIGNMENT);
		add(bInicio);

		add(Box.createRigidArea(new Dimension(40, 30)));

		panelLinea = new JPanel() {

			private static final long serialVersionUID = 1L;

			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				g.setColor(Color.darkGray);
				g.drawLine(0, 0, getWidth(), 0);
			}
		};
		panelLinea.setPreferredSize(new Dimension(0, 1));
		panelLinea.setAlignmentX(CENTER_ALIGNMENT);
		add(panelLinea);

		add(Box.createRigidArea(new Dimension(40, 30)));

		bCrearCuenta = new JButton(CREAR_CUENTA);
		bCrearCuenta.setPreferredSize(new Dimension(100, 40));
		bCrearCuenta.setAlignmentX(CENTER_ALIGNMENT);
		bCrearCuenta.addActionListener(this.padreInicio);
		add(bCrearCuenta);

		add(Box.createRigidArea(new Dimension(40, 30)));

		setVisible(true);
	}

	public String getTextField1() {
		return this.textField1.getText();
	}

	public String getPasswordField() {
		char[] caracteres = this.passwordField.getPassword();
		return new String(caracteres);
	}
	
	public String getRol() {
		return tipoUsuario.getSelection().getActionCommand();
	}

}
