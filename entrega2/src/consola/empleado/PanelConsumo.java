package consola.empleado;

import java.awt.BorderLayout;

import javax.swing.JDialog;

public class PanelConsumo extends JDialog {

	private static final long serialVersionUID = 1L;
	private FormularioRegistroConsumo panelFormularioRegistro;
	private InterfazEmpleado padre;

	public PanelConsumo(InterfazEmpleado padre) {
		this.padre = padre;
		setLayout(new BorderLayout());
		setSize(500, 400);
		setLocationRelativeTo(null);

		panelFormularioRegistro = new FormularioRegistroConsumo(this);
		add(panelFormularioRegistro);
	}
	public InterfazEmpleado getPadre() {
		return this.padre;
	}
	
	public String categoria() {
		return panelFormularioRegistro.categoria();
	}
	
	public String pago() {
		return panelFormularioRegistro.pago();
	}
	public String referencia() {
		panelFormularioRegistro.referencia(); 
		return null;
	}
	public String id() {
		panelFormularioRegistro.id(); 
		return null;
	}
}
