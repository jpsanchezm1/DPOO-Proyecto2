package consola.recepcion;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;

import javax.swing.JDialog;
import javax.swing.JFrame;

public class InterfazRecepcion extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private PanelOpciones panelOpciones;
	private JDialog dialogReservar;
	private PanelReservar panelReservar;
	private PanelRegistrarSalida opcionRegistrarSalida;
	private PanelConsultarHabitaciones opcionConsultar;
	
	public InterfazRecepcion() {
		
		setLayout(new GridBagLayout());
		setTitle("Recepcion");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(700, 600);
        getContentPane().setBackground(Color.DARK_GRAY);
		setResizable(false);
        setLocationRelativeTo(null); // Centra la ventana en la pantalla
        
        panelOpciones = new PanelOpciones(this);
        add(panelOpciones);
        
        dialogReservar = new JDialog();
        dialogReservar.setTitle("Reservar habitaciones");
        dialogReservar.setSize(700, 600);
        dialogReservar.setLocationRelativeTo(null);
		dialogReservar.add(new PanelReservar(this));

        
        // Configuración del layout
        //setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

	}
	
	public static void main(String[] args) {
		InterfazRecepcion interfaz = new InterfazRecepcion();
		interfaz.setVisible(true);
	}

	public void mostrarPanelReservar() {
		// TODO Auto-generated method stub
		dialogReservar.setVisible(true);
	}

}
