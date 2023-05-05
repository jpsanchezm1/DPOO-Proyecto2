package modelo.habitaciones;

public class Habitacion {

	private int id;
	private String tipo;
	private int capacidad;
	private String descripcion;
	private boolean balcon;
	private boolean vista;
	private boolean cocina;

	public Habitacion(int id, String tipo, int capacidad, String descripcion, boolean balcon, boolean vista,
			boolean cocina) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.capacidad = capacidad;
		this.descripcion = descripcion;
		this.balcon = balcon;
		this.vista = vista;
		this.cocina = cocina;

	}

	public int getId() {
		return id;
	}

	public int getCapacidad() {
		return capacidad;
	}

	public String getTipo() {
		return tipo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public boolean isBalcon() {
		return balcon;
	}

	public boolean isVista() {
		return vista;
	}

	public boolean isCocina() {
		return cocina;
	}

	public void setBalcon(boolean balcon) {
		this.balcon = balcon;
	}

	public void setVista(boolean vista) {
		this.vista = vista;
	}

	public void setCocina(boolean cocina) {
		this.cocina = cocina;
	}

	@Override
	public String toString() {
		return "\nTipo Habitacion: " + tipo + "\n" + "Capacidad habitacion: " + capacidad;
	}

}
