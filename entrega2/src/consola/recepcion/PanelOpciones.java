package consola.recepcion;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelOpciones extends JPanel implements ActionListener {

	private static final long serialVersionUID = 1L;
	private static final String RESERVAR = "Realizar reserva";
	private static final String REGISTRAR = "Registrar Salida";
	private static final String CONSULTAR = "Consultar habitaciones";
	private JButton bReservar;
	private JButton bRegitrarSalida;
	private JButton bConsultarHabs;
	private InterfazRecepcion principalInterfazRecep;

	public PanelOpciones(InterfazRecepcion p) {

		principalInterfazRecep = p;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(Color.darkGray);
		setSize(700, 600);

		bReservar = new JButton(RESERVAR);
		bReservar.addActionListener(this);
		bReservar.setActionCommand(RESERVAR);
		bReservar.setMaximumSize(new Dimension(300, 50));
		add(bReservar);

		add(Box.createRigidArea(new Dimension(60, 50)));

		bRegitrarSalida = new JButton(REGISTRAR);
		bRegitrarSalida.addActionListener(this);
		bRegitrarSalida.setActionCommand(REGISTRAR);
		bRegitrarSalida.setMaximumSize(new Dimension(300, 50));
		add(bRegitrarSalida);

		add(Box.createRigidArea(new Dimension(60, 50)));

		bConsultarHabs = new JButton(CONSULTAR);
		bConsultarHabs.addActionListener(this);
		bConsultarHabs.setActionCommand(CONSULTAR);
		bConsultarHabs.setMaximumSize(new Dimension(300, 50));
		add(bConsultarHabs);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(RESERVAR)) {
			principalInterfazRecep.mostrarPanelReservar();
		}

	}

}
