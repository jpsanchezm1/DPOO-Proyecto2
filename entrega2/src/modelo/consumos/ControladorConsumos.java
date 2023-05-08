package modelo.consumos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import modelo.huespedes.ControladorRegistro;
import modelo.huespedes.Huesped;
import modelo.servicios.restaurante.ProductoMenu;
import modelo.servicios.Servicio;

public class ControladorConsumos {

	private String archivoConsumosServicios = "./data/consumos/consumosServicios.txt";

	private String archivoConsumosRest = "./data/consumos/consumosRestaurante.txt";

	private Map<Integer, List<ConsumoServicio>> mapaConsumosServicios = new HashMap<>(); // id representante: consumos

	private Map<Integer, List<ConsumoRestaurante>> mapaConsumosRest = new HashMap<>(); // id representante: consumos

	private ControladorRegistro controladorRegistro;

	private Map<String, ProductoMenu> mapaProductosMenu;

	private Map<String, Servicio> mapaServicios;

	public ControladorConsumos(ControladorRegistro controladorRegistro, Map<String, ProductoMenu> mapaProductosMenu,
			Map<String, Servicio> mapaServicios) throws IOException {
		this.controladorRegistro = controladorRegistro;
		this.mapaProductosMenu = mapaProductosMenu;
		this.mapaServicios = mapaServicios;
		recuperarInformacion();
	}

	public void crearConsumoServicio(String idHuesped, String servicioString, ControladorRegistro controladorRegistro,
			Map<String, Servicio> mapaServicios) {
		Huesped huesped = controladorRegistro.getHuespedPorId(Integer.parseInt(idHuesped));
		Integer id = controladorRegistro.getGrupoPorId(Integer.parseInt(idHuesped)).getRepresentante()
				.getIdentificacion();
		Servicio servicio = mapaServicios.get(servicioString);
		ConsumoServicio consumo = new ConsumoServicio(huesped, servicio);
		mapaConsumosServicios.computeIfAbsent(id, k -> new ArrayList<>());
		mapaConsumosServicios.get(id).add(consumo);
	}

	public void crearConsumoRest(String idHuesped, String productoMenu, ControladorRegistro controladorRegistro,
			Map<String, ProductoMenu> mapaProductosMenu) {
		Huesped huesped = controladorRegistro.getHuespedPorId(Integer.parseInt(idHuesped));
		Integer id = controladorRegistro.getGrupoPorId(Integer.parseInt(idHuesped)).getRepresentante()
				.getIdentificacion();
		ProductoMenu producto = mapaProductosMenu.get(productoMenu);
		ConsumoRestaurante consumo = new ConsumoRestaurante(huesped, producto);
		mapaConsumosRest.computeIfAbsent(id, k -> new ArrayList<>());
		mapaConsumosRest.get(id).add(consumo);
	}

	public List<ConsumoServicio> getConsumosServicio(Integer idRepresentante) {
		return mapaConsumosServicios.get(idRepresentante);
	}

	public List<ConsumoRestaurante> getConsumosRestaurante(Integer idRepresentante) {
		return mapaConsumosRest.get(idRepresentante);
	}

	public void guardarRegistros() throws IOException {
		EditorConsumos editorConsumos = new EditorConsumos();
		editorConsumos.guardarRegistros(archivoConsumosServicios, archivoConsumosRest, mapaConsumosServicios,
				mapaConsumosRest);
	}

	private void recuperarInformacion() throws IOException {
		CargadorConsumos cargadorConsumos = new CargadorConsumos();
		cargadorConsumos.cargarConsumos(archivoConsumosServicios, archivoConsumosRest, mapaConsumosServicios,
				mapaConsumosRest, controladorRegistro, mapaServicios, mapaProductosMenu);
	}
}
