package consola.empleado;

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
	private static final String REGISTRAR_CONSUMO = "Realizar reserva";
	private JButton bRegistrarConsumo;
	private InterfazEmpleado principalInterfazEmp;

	public PanelOpciones(InterfazEmpleado p) {

		principalInterfazEmp = p;

		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		setBackground(Color.darkGray);
        setSize(700, 600);

        bRegistrarConsumo = new JButton(REGISTRAR_CONSUMO);
        bRegistrarConsumo.addActionListener(this);
        bRegistrarConsumo.setActionCommand(REGISTRAR_CONSUMO);
        bRegistrarConsumo.setMaximumSize(new Dimension(300,50));
        add(bRegistrarConsumo);

        add(Box.createRigidArea(new Dimension(60, 50)));

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String comando = e.getActionCommand();

		if (comando.equals(REGISTRAR_CONSUMO)) {
			principalInterfazEmp.mostrarPanelConsumo();
		}

	}
}
