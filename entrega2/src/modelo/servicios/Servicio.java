package modelo.servicios;

public class Servicio {

	private String nombre;

	private float precio;

	public Servicio(String nombre, float precio) {
		super();
		this.nombre = nombre;
		this.precio = precio;
	}

	public Servicio(String nombre) {
		super();
		this.nombre = nombre;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	@Override
	public String toString() {
		return this.nombre + ": " + this.precio;
	}
}
