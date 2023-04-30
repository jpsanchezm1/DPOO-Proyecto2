package modelo.huespedes;

public class Huesped {

	private String nombre;
	private int identificacion;
	private int numCelular;
	private String correo;
	private Grupo grupo;

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

	public int getIdentificacion() {
		return identificacion;
	}

	public int getNumCelular() {
		return numCelular;
	}

	public String getCorreo() {
		return correo;
	}

	public Grupo getGrupo() {
		return grupo;
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

	public void setGrupo(Grupo grupo) {
		this.grupo = grupo;
	}

}
