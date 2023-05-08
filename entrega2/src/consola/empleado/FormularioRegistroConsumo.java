package consola.empleado;

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
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class FormularioRegistroConsumo extends JPanel {

	private static final long serialVersionUID = 1L;
	private static final String REGISTRAR = "Registrar";
	private JTextField idHuesped, referencia;
	private JButton bRegistrar;
	private PanelConsumo padre;
	private ButtonGroup tipoConsumoGroup,pagoGroup;
	private JRadioButton restaurante, servicio, si, no;

	public FormularioRegistroConsumo(PanelConsumo padre) {
		this.padre = padre;
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.WHITE);
		setPreferredSize(new Dimension(300, 300));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

		add(Box.createRigidArea(new Dimension(40, 30)));

		JPanel tipoConsumoPanel = new JPanel(new BorderLayout());
		JLabel lTipoConsumo = new JLabel("Tipo de Consumo");
		tipoConsumoPanel.add(lTipoConsumo, BorderLayout.WEST);
		add(tipoConsumoPanel);

		add(Box.createRigidArea(new Dimension(40, 10)));

		restaurante = new JRadioButton("Restaurante");
		servicio = new JRadioButton("Servicio");
		tipoConsumoGroup = new ButtonGroup();
		tipoConsumoGroup.add(restaurante);
		tipoConsumoGroup.add(servicio);
		JPanel tipoConsumoRadioPanel = new JPanel();
		tipoConsumoRadioPanel.setLayout(new BoxLayout(tipoConsumoRadioPanel, BoxLayout.X_AXIS));
		tipoConsumoRadioPanel.add(Box.createRigidArea(new Dimension(40, 10)));
		tipoConsumoRadioPanel.add(restaurante);
		tipoConsumoRadioPanel.add(Box.createRigidArea(new Dimension(40, 10)));
		tipoConsumoRadioPanel.add(servicio);
		tipoConsumoRadioPanel.add(Box.createRigidArea(new Dimension(40, 10)));
		add(tipoConsumoRadioPanel);

		add(Box.createRigidArea(new Dimension(40, 20)));

		JPanel usuarioPanel = new JPanel(new BorderLayout());
		JLabel lUsuario = new JLabel("ID del huesped");
		usuarioPanel.add(lUsuario, BorderLayout.WEST);
		add(usuarioPanel);

		add(Box.createRigidArea(new Dimension(40, 10)));

		idHuesped = new JTextField();
		idHuesped.setPreferredSize(new Dimension(80, 30));
		add(idHuesped);

		add(Box.createRigidArea(new Dimension(40, 10)));

		JPanel rolPanel = new JPanel(new BorderLayout());
		JLabel lrol = new JLabel("Referencia (producto del menú o servicio)");
		rolPanel.add(lrol, BorderLayout.WEST);
		add(rolPanel);

		add(Box.createRigidArea(new Dimension(40, 10)));

		referencia = new JTextField();
		referencia.setPreferredSize(new Dimension(80, 30));
		add(referencia);

		add(Box.createRigidArea(new Dimension(40, 10)));
		
		JPanel pagoPanel = new JPanel();
		pagoPanel.setLayout(new BoxLayout(pagoPanel, BoxLayout.X_AXIS));
		JLabel lPago = new JLabel("Pago: ");
		pagoPanel.add(lPago);
		si = new JRadioButton("Sí");
		no = new JRadioButton("No");
		pagoGroup = new ButtonGroup();
		pagoGroup.add(si);
		pagoGroup.add(no);
		pagoPanel.add(si);
		pagoPanel.add(no);
		add(pagoPanel);
		
		add(Box.createRigidArea(new Dimension(40, 10)));
		
		bRegistrar = new JButton(REGISTRAR);
		bRegistrar.setPreferredSize(new Dimension(100, 40));
		bRegistrar.setAlignmentX(CENTER_ALIGNMENT);
		bRegistrar.addActionListener(this.padre.getPadre());
		bRegistrar.setActionCommand(REGISTRAR);
		add(bRegistrar);

		add(Box.createRigidArea(new Dimension(40, 30)));
	}
	
	public String categoria() {
		return tipoConsumoGroup.getSelection().getActionCommand();
	}
	
	public String pago() {
		return pagoGroup.getSelection().getActionCommand();
	}

	public String id() {
		return idHuesped.getText();
	}

	public String referencia() {
		return referencia.getText();
	}
}
