package consola;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Inicio extends JPanel {

	private static final long serialVersionUID = 1L;
	private InterfazPMS principalInterfazPMS;

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

		// Crear un panel adicional para el formulario
		JPanel panelForm = new PanelFormulario();

		// Agregar los paneles al panel central
		panelCentro.add(panelForm, BorderLayout.CENTER);

		add(panelNorte, BorderLayout.NORTH);
		add(panelOeste, BorderLayout.WEST);
		add(panelCentro, BorderLayout.CENTER);

		setVisible(true);
	}

}
