package consola.recepcion;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesReservar extends JPanel implements ActionListener {

	private static final String CONSULTAR = "Consultar";
	private static final String RESERVAR = "Reservar";
	private static final long serialVersionUID = 1L;
	private JButton bConsultar;
	private JButton bReservar;
	private InterfazRecepcion principalInterfazRecep;

	public PanelBotonesReservar(InterfazRecepcion p) {

		principalInterfazRecep = p;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));

		bConsultar = new JButton(RESERVAR);
		bConsultar.addActionListener(this);
		bConsultar.setActionCommand(CONSULTAR);
		add(bConsultar);

		add(Box.createRigidArea(new Dimension(60, 50)));

		bReservar = new JButton(CONSULTAR);
		bReservar.addActionListener(this);
		bReservar.setActionCommand(CONSULTAR);
		add(bReservar);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String comando = e.getActionCommand();

		if (comando.equals(RESERVAR)) {
			principalInterfazRecep.mostrarPanelRegistrar();
		}

	}

}
