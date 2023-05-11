package consola.inicio;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

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

public class PanelFormularioRegistro extends JPanel{

	private static final long serialVersionUID = 1L;
	private static final String REGISTRAR = "Registrar";
	private JTextField usuarioTextField;
	private JPasswordField passwordField;
	private JButton bRegistrar;
	private ButtonGroup tipoUsuario;
	private JRadioButton admin, recep, empleG;
	private JLabel titleJLabel;
	private Registro padreRegistro;
	
	public PanelFormularioRegistro(Registro padreRegistro) {
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300, 300));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
		
		this.padreRegistro = padreRegistro;
		
		add(Box.createRigidArea(new Dimension(40, 30)));
		
		JPanel titlePanel = new JPanel(new BorderLayout());
		titleJLabel = new JLabel("Crear Cuenta");
		titlePanel.add(titleJLabel, BorderLayout.CENTER);
		add(titlePanel);
		
		add(Box.createRigidArea(new Dimension(40, 30)));
		
		JPanel usuarioPanel = new JPanel(new BorderLayout());
		JLabel lUsuario = new JLabel("Usuario: ");
		usuarioPanel.add(lUsuario, BorderLayout.WEST);
		add(usuarioPanel);
		
		add(Box.createRigidArea(new Dimension(40, 10)));
		
		usuarioTextField = new JTextField();
		usuarioTextField.setPreferredSize(new Dimension(80, 30));
		add(usuarioTextField);
		
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
		passwordField.setEchoChar('�');
		passwordField.setPreferredSize(new Dimension(40, 30));
		add(passwordField);

		add(Box.createRigidArea(new Dimension(40, 35)));
		
		bRegistrar = new JButton(REGISTRAR);
		bRegistrar.setPreferredSize(new Dimension(100, 40));
		bRegistrar.setAlignmentX(CENTER_ALIGNMENT);
		bRegistrar.addActionListener(this.padreRegistro);
		add(bRegistrar);

		add(Box.createRigidArea(new Dimension(40, 30)));
	}

	public String getUsuarioTextField() {
		return this.usuarioTextField.getText();
	}
	
	public String getPasswordField() {
		char[] caracteres = this.passwordField.getPassword();
		String contraseniaString = new String(caracteres);
		return contraseniaString;
	}
	
	public String getRol() {
		return tipoUsuario.getSelection().getActionCommand();
	}
}

















