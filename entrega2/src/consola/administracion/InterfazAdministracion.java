package consola.administracion;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

import consola.InterfazPMS;
import coordinadores.CoordinadorAdministrador;
import modelo.habitaciones.ControladorHabitaciones;

public class InterfazAdministracion extends JFrame {

	private static final long serialVersionUID = 1L;
	private PanelOpciones panelOpciones;
	private CoordinadorAdministrador coordAdministrador;
	private InterfazPMS padre;

	public InterfazAdministracion(InterfazPMS padreI) throws IOException {
		
		this.padre = padreI;
		setTitle("Administracion");
		setSize(700, 600);
		setResizable(false);
		setLayout(new GridBagLayout());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setBackground(Color.DARK_GRAY);
		
		coordAdministrador = new CoordinadorAdministrador();

		panelOpciones = new PanelOpciones(this);
		JPanel panelOpsCentrado = new JPanel();
		panelOpsCentrado.setLayout(new GridBagLayout());
		panelOpsCentrado.add(panelOpciones);

		add(panelOpciones);
		
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					padre.guardarRegistros();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});

	}

	public void cargarHabitaciones() throws IOException {

		JFileChooser archivoHabitaciones = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
		archivoHabitaciones.setFileFilter(filtro);
		archivoHabitaciones.setMultiSelectionEnabled(false);
		int resultado = archivoHabitaciones.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			
			File selectedFile = archivoHabitaciones.getSelectedFile();
		    String filePath = selectedFile.getAbsolutePath();
		    try {
				coordAdministrador.cargarHabitaciones(filePath);
			} catch (IOException ex) {
				ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "El archivo seleccionado no es un archivo de texto.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void cargarTarifas() {

		JFileChooser archivoTarifas = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
		archivoTarifas.setFileFilter(filtro);
		archivoTarifas.setMultiSelectionEnabled(false);
		int resultado = archivoTarifas.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File selectedFile = archivoTarifas.getSelectedFile();
		    String filePath = selectedFile.getAbsolutePath();
		    try {
				coordAdministrador.cargarTarifas(filePath);
			} catch (IOException ex) {
				ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "El archivo seleccionado no es un archivo de texto.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
	//Nofunciona
	public void cargarMenu() {
		JFileChooser archivoMenu = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
		archivoMenu.setFileFilter(filtro);
		archivoMenu.setMultiSelectionEnabled(false);
		int resultado = archivoMenu.showOpenDialog(this);
		
		if (resultado == JFileChooser.APPROVE_OPTION) {
			File selectedFile = archivoMenu.getSelectedFile();
		    String filePath = selectedFile.getAbsolutePath();
		    try {
				coordAdministrador.cargarServicios(filePath);
			} catch (IOException ex) {
				ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "El archivo seleccionado no es un archivo de texto.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}

	public void registrarHabitacion() {
		// TODO Auto-generated method stub

	}

	public void registrarTarifa() {
		// TODO Auto-generated method stub

	}

	public void cargarServicios() {

		JFileChooser archivoServicios = new JFileChooser();
		FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de texto (.txt)", "txt");
		archivoServicios.setFileFilter(filtro);
		archivoServicios.setMultiSelectionEnabled(false);
		int resultado = archivoServicios.showOpenDialog(this);

		if (resultado == JFileChooser.APPROVE_OPTION) {
			File selectedFile = archivoServicios.getSelectedFile();
		    String filePath = selectedFile.getAbsolutePath();
		    try {
				coordAdministrador.cargarServicios(filePath);
			} catch (IOException ex) {
				ex.printStackTrace();
		        JOptionPane.showMessageDialog(null, "No se pudo cargar el archivo", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			JOptionPane.showMessageDialog(null, "El archivo seleccionado no es un archivo de texto.", "Error",
					JOptionPane.ERROR_MESSAGE);
		}
	}
}
