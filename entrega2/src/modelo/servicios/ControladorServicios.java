package modelo.servicios;

import java.io.IOException;
import java.util.Map;

public class ControladorServicios {

	private CargadorServicios cargadorServicios = new CargadorServicios();

	public ControladorServicios() throws IOException {
		cargadorServicios.recuperarInformacion();
	}

	public void cargarServicios(String rutaArchivo) throws IOException {
		cargadorServicios.cargarServicios(true, rutaArchivo);
	}

	public void crearServicio(String nombre, String precio) throws IOException {
		cargadorServicios.anadirServicio(true, nombre, precio);
	}

	public Map<String, Servicio> getMapaServicios() {
		return cargadorServicios.getMapaServicios();
	}

	public Servicio consultarServicio(String nombre) {
		return getMapaServicios().get(nombre);
	}

	public static void main(String[] args) throws IOException {
		ControladorServicios c = new ControladorServicios();
		c.cargarServicios("./archivosEjemplo/servicios.txt");
		System.out.println(c.consultarServicio("TV").getPrecio());
	}
}
