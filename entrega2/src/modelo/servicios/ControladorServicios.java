package modelo.servicios;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class ControladorServicios {

	private Map<String, Servicio> mapaServicios = new HashMap<>();

	private String archivoServicios = "./data/servicios/servicios.txt";

	public ControladorServicios() throws IOException {
		recuperarInformacion();
	}

	public void cargarServicios(String rutaArchivo) throws IOException {
		CargadorServicios cargadorServicios = new CargadorServicios();
		cargadorServicios.cargarServicios(rutaArchivo, mapaServicios);
	}

	public void crearServicio(String nombre, String precioString) throws IOException {
		Float precio = Float.parseFloat(precioString);
		mapaServicios.computeIfAbsent(nombre, k -> new Servicio(nombre, precio));
		mapaServicios.get(nombre).setPrecio(precio);
	}

	public Servicio consultarServicio(String nombre) {
		return mapaServicios.get(nombre);
	}

	public void guardarRegistros() throws IOException {
		EditorServicios editor = new EditorServicios();
		editor.guardarRegistros(mapaServicios, archivoServicios);
	}

	private void recuperarInformacion() throws IOException {
		CargadorServicios cargadorServicios = new CargadorServicios();
		cargadorServicios.cargarServicios(archivoServicios, mapaServicios);
	}

	public Map<String, Servicio> getMapaServicios() {
		return mapaServicios;
	}
}
