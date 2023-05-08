package consola.recepcion;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;

public class PanelReservar extends JPanel {

	private static final long serialVersionUID = 1L;
	private JTextField fechaInicio;
	private JTextField fechaFin;
	private JList<String> listaHabitaciones;
	private DefaultListModel<String> modelo;
	private InterfazRecepcion principalInterfazRecep;
	private PanelBotonesReservar panelBotones;

	public PanelReservar(InterfazRecepcion p) {

		principalInterfazRecep = p;

		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(300, 300));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));

		JPanel fechas = new JPanel();
		fechas.setLayout(new GridLayout(1, 0));

		JLabel lFechaInicial = new JLabel("Fecha inicial:");
		fechaInicio = new JTextField();
		fechaInicio.setMaximumSize(new Dimension(80, 30));
		JLabel lFechaFin = new JLabel("Fecha fin:");
		fechaFin = new JTextField();
		fechaFin.setPreferredSize(new Dimension(80, 30));

		fechas.add(lFechaInicial);
		fechas.add(fechaInicio);
		fechas.add(lFechaFin);
		fechas.add(fechaFin);

		add(fechas, BorderLayout.NORTH);

		modelo = new DefaultListModel<>();

		listaHabitaciones = new JList<>(modelo);
		listaHabitaciones.setMaximumSize(new Dimension(700, 400));
		listaHabitaciones.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		listaHabitaciones.setCellRenderer(new CustomListCellRenderer());

		JScrollPane scrollPane = new JScrollPane(listaHabitaciones);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

		add(scrollPane);

		JPanel pAbajo = new JPanel();
		pAbajo.setLayout(new BorderLayout());
		panelBotones = new PanelBotonesReservar(p);
		pAbajo.add(panelBotones, BorderLayout.EAST);

		add(pAbajo, BorderLayout.SOUTH);

	}

	private class CustomListCellRenderer extends DefaultListCellRenderer {
		private static final long serialVersionUID = 1L;

		@Override
		public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
				boolean cellHasFocus) {
			Component component = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

			// Aumentar el tamaño del texto
			Font font = component.getFont();
			component.setFont(font.deriveFont(font.getSize() + 7.0f));

			return component;
		}
	}

	private void addToList(String item) {
		modelo.addElement(item);
	}

}
