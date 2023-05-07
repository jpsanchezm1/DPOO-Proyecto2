package consola;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextField;

public class SugerenciaJTextField extends JTextField implements FocusListener, KeyListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String sugerencia;
	private Color colorSugerencia;
	private Color colorTexto;

	public SugerenciaJTextField(String sugerencia) {
		this(sugerencia, Color.LIGHT_GRAY);
	}

	public SugerenciaJTextField(String textoSugerencia, Color colorSugerencia) {
		this.sugerencia = textoSugerencia;
		this.colorSugerencia = colorSugerencia;
		this.colorTexto = getForeground();
		addFocusListener(this);
		addKeyListener(this);
		setForeground(colorSugerencia);
		setText(sugerencia);
	}

	@Override
	public void keyTyped(KeyEvent e) {
	}

	@Override
	public void keyPressed(KeyEvent e) {
	}

	@Override
	public void keyReleased(KeyEvent e) {
		if (getText().isEmpty()) {
			setText(sugerencia);
			setForeground(colorSugerencia);
		} else {
			setForeground(colorTexto);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		if (getText().equals(sugerencia)) {
			setText("");
			setForeground(colorTexto);
		}
	}

	@Override
	public void focusLost(FocusEvent e) {
		if (getText().isEmpty()) {
			setText(sugerencia);
			setForeground(colorSugerencia);
		}
	}
}
