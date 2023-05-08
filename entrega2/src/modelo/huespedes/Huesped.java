package modelo.huespedes;

public class Huesped {

	private String nombre;
	private Integer identificacion;
	private int numCelular;
	private String correo;

	public Huesped(String nombre, int identificacion, int numCelular, String correo) {
		super();
		this.nombre = nombre;
		this.identificacion = identificacion;
		this.numCelular = numCelular;
		this.correo = correo;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getIdentificacion() {
		return identificacion;
	}

	public int getNumCelular() {
		return numCelular;
	}

	public String getCorreo() {
		return correo;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setIdentificacion(int identificacion) {
		this.identificacion = identificacion;
	}

	public void setNumCelular(int numCelular) {
		this.numCelular = numCelular;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

}
