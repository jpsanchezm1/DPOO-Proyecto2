package modelo.consumos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.huespedes.Huesped;
import modelo.servicios.restaurante.ProductoMenu;
import modelo.servicios.Servicio;

public class ControladorConsumos {

	private String archivoConsumosServicios = "./data/consumos/consumosServicios.txt";

	private String archivoConsumosRest = "./data/consumos/consumosRestaurante.txt";

	private Map<String, List<ConsumoServicio>> mapaConsumosServicios = new HashMap<>();

	private Map<String, List<ConsumoRestaurante>> mapaConsumosRest = new HashMap<>();

	public ControladorConsumos(Map<String, Huesped> mapaHuespedes, Map<String, ProductoMenu> mapaProductosMenu,
			Map<String, Servicio> mapaServicios) throws IOException {
		recuperarInformacion(mapaHuespedes, mapaServicios, mapaProductosMenu);
	}

	public void crearConsumoServicio(String huespedString, String servicioString, String pagoString,
			Map<String, Huesped> mapaHuespedes, Map<String, Servicio> mapaServicios) {
		Huesped huesped = mapaHuespedes.get(huespedString);
		String representante = huesped.getGrupo().getRepresentante().getNombre();
		Servicio servicio = mapaServicios.get(servicioString);
		ConsumoServicio consumo = new ConsumoServicio(huesped, servicio, Boolean.parseBoolean(pagoString));
		mapaConsumosServicios.computeIfAbsent(representante, k -> new ArrayList<>());
		mapaConsumosServicios.get(representante).add(consumo);
	}

	public void crearConsumoRest(String huespedString, String productoMenu, String pagoString,
			Map<String, Huesped> mapaHuespedes, Map<String, ProductoMenu> mapaProductosMenu) {
		Huesped huesped = mapaHuespedes.get(huespedString);
		String representante = huesped.getGrupo().getRepresentante().getNombre();
		ProductoMenu producto = mapaProductosMenu.get(productoMenu);
		ConsumoRestaurante consumo = new ConsumoRestaurante(huesped, producto, Boolean.parseBoolean(pagoString));
		mapaConsumosRest.computeIfAbsent(representante, k -> new ArrayList<>());
		mapaConsumosRest.get(representante).add(consumo);
	}

	public List<ConsumoServicio> getConsumosServicio(String huespedRepresentante) {
		return mapaConsumosServicios.get(huespedRepresentante);
	}

	public List<ConsumoRestaurante> getConsumosRestaurante(String huespedRepresentante) {
		return mapaConsumosRest.get(huespedRepresentante);
	}

	public void guardarRegistros() throws IOException {
		EditorConsumos editorConsumos = new EditorConsumos();
		editorConsumos.guardarRegistros(archivoConsumosServicios, archivoConsumosRest, mapaConsumosServicios,
				mapaConsumosRest);
	}

	private void recuperarInformacion(Map<String, Huesped> mapaHuespedes, Map<String, Servicio> mapaServicios,
			Map<String, ProductoMenu> mapaProductosMenu) throws IOException {
		CargadorConsumos cargadorConsumos = new CargadorConsumos();
		cargadorConsumos.cargarConsumos(archivoConsumosServicios, archivoConsumosRest, mapaConsumosServicios,
				mapaConsumosRest, mapaHuespedes, mapaServicios, mapaProductosMenu);
	}
}
