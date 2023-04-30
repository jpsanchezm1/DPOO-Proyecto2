package modelo.consumos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.huespedes.Huesped;
import modelo.servicios.ProductoMenu;
import modelo.servicios.Servicio;

public class CargadorConsumos {

	private String archivoConsumosServicios = "./data/consumos/consumosServicios.txt";

	private String archivoConsumosRestaurante = "./data/consumos/consumosRestaurante.txt";

	private Map<String, List<ConsumoServicio>> mapaConsumosServicios = new HashMap<>();

	private Map<String, List<ConsumoRestaurante>> mapaConsumosRestaurante = new HashMap<>();

	private Map<String, Huesped> mapaHuespedes;

	private Map<String, ProductoMenu> mapaProductosMenu;

	private Map<String, Servicio> mapaServicios;

	public CargadorConsumos(Map<String, Huesped> mapaHuespedes, Map<String, ProductoMenu> mapaProductosMenu,
			Map<String, Servicio> mapaServicios) {
		super();
		this.mapaHuespedes = mapaHuespedes;
		this.mapaProductosMenu = mapaProductosMenu;
		this.mapaServicios = mapaServicios;
	}

	public Map<String, List<ConsumoServicio>> getMapaConsumosServicios() {
		return mapaConsumosServicios;
	}

	public Map<String, List<ConsumoRestaurante>> getMapaConsumosRestaurante() {
		return mapaConsumosRestaurante;
	}

	public void registrarConsumo(String rutaArchivo, String servicio) throws IOException {
		BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true));
		editor.write(servicio);
		editor.newLine();
		editor.close();
	}

	public void recuperarInformacion(String tipoConsumo) throws IOException {
		String rutaArchivo = (tipoConsumo.equals("ConsumoServicio")) ? archivoConsumosServicios
				: archivoConsumosRestaurante;
		BufferedReader lector = new BufferedReader(new FileReader(rutaArchivo));
		String linea;
		while ((linea = lector.readLine()) != null) {
			String[] partes = linea.split(";");
			crearConsumo(false, rutaArchivo, partes[0], partes[1], partes[2]);
		}
		lector.close();
	}

	public void crearConsumo(boolean infoNueva, String tipoConsumo, String huespedString, String referencia,
			String pagoString) throws IOException {
		String rutaArchivo = (tipoConsumo.equals("ConsumoServicio")) ? archivoConsumosServicios
				: archivoConsumosRestaurante;
		String registro = huespedString + ";" + referencia + ";" + pagoString;
		if (infoNueva) {
			registrarConsumo(rutaArchivo, registro);
		}
		Huesped huesped = mapaHuespedes.get(huespedString);
		String representate = huesped.getGrupo().getRepresentante().getNombre();
		boolean pago = (pagoString.equals("si"));
		if (tipoConsumo.equals("ConsumoServicio")) {
			Servicio servicio = mapaServicios.get(referencia);
			ConsumoServicio consumo = new ConsumoServicio(huesped, servicio, pago);
			mapaConsumosServicios.computeIfAbsent(representate, k -> new ArrayList<>());
			mapaConsumosServicios.get(representate).add(consumo);
		} else {
			ProductoMenu producto = mapaProductosMenu.get(referencia);
			ConsumoRestaurante consumo = new ConsumoRestaurante(huesped, producto, pago);
			mapaConsumosRestaurante.computeIfAbsent(representate, k -> new ArrayList<>());
			mapaConsumosRestaurante.get(representate).add(consumo);
		}
	}
}