package consola.recepcion;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.TextArea;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class PanelReservar extends JPanel{

	private static final long serialVersionUID = 1L;
	private JTextField fechaInicio;
	private JTextField fechaFin;
	private JTextArea areaHabitaciones;
	private InterfazRecepcion principalInterfazRecep;
	
	public PanelReservar(InterfazRecepcion p) {
		
		principalInterfazRecep = p;
		
		setLayout(new BorderLayout());
        setPreferredSize(new Dimension(300, 300));
		setBorder(BorderFactory.createEmptyBorder(0, 40, 0, 40));
        
        JPanel fechas = new JPanel();
        fechas.setLayout(new GridLayout(1,0));
        
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
        
        areaHabitaciones = new JTextArea();
        add(areaHabitaciones);
        
        
        
        
	}
	
}
