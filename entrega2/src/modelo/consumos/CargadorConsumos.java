package modelo.consumos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.huespedes.ControladorHuespedes;
import modelo.huespedes.Huesped;
import modelo.servicios.restaurante.ProductoMenu;
import modelo.servicios.Servicio;

public class CargadorConsumos {

	private void cargarConsumosServicios(String archivoConsumos,
			Map<Integer, List<ConsumoServicio>> mapaConsumosServicios, ControladorHuespedes controladorRegistro,
			Map<String, Servicio> mapaServicios) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoConsumos));
		String linea;
		while ((linea = lector.readLine()) != null) {
			String[] partes = linea.split(";");
			Huesped huesped = controladorRegistro.getHuespedPorId(Integer.parseInt(partes[0]));
			Integer id = controladorRegistro.getGrupoPorId(huesped.getIdentificacion()).getRepresentante()
					.getIdentificacion();
			Servicio servicio = mapaServicios.get(partes[1]);
			ConsumoServicio consumo = new ConsumoServicio(huesped, servicio);
			mapaConsumosServicios.computeIfAbsent(id, k -> new ArrayList<>());
			mapaConsumosServicios.get(id).add(consumo);
		}
		lector.close();
	}

	private void cargarConsumosRestaurante(String archivoConsumos,
			Map<Integer, List<ConsumoRestaurante>> mapaConsumosRestaurante, ControladorHuespedes controladorRegistro,
			Map<String, ProductoMenu> mapaProductosMenu) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoConsumos));
		String linea;
		while ((linea = lector.readLine()) != null) {
			String[] partes = linea.split(";");
			Huesped huesped = controladorRegistro.getHuespedPorId(Integer.parseInt(partes[0]));
			Integer id = controladorRegistro.getGrupoPorId(huesped.getIdentificacion()).getRepresentante()
					.getIdentificacion();
			ProductoMenu producto = mapaProductosMenu.get(partes[1]);
			ConsumoRestaurante consumo = new ConsumoRestaurante(huesped, producto);
			mapaConsumosRestaurante.computeIfAbsent(id, k -> new ArrayList<>());
			mapaConsumosRestaurante.get(id).add(consumo);
		}
		lector.close();
	}

	public void cargarConsumos(String archivoConsumosServicios, String archivoConsumosRest,
			Map<Integer, List<ConsumoServicio>> mapaConsumosServicios,
			Map<Integer, List<ConsumoRestaurante>> mapaConsumosRestaurante, ControladorHuespedes controladorRegistro,
			Map<String, Servicio> mapaServicios, Map<String, ProductoMenu> mapaProductosMenu) throws IOException {
		cargarConsumosServicios(archivoConsumosServicios, mapaConsumosServicios, controladorRegistro, mapaServicios);
		cargarConsumosRestaurante(archivoConsumosRest, mapaConsumosRestaurante, controladorRegistro, mapaProductosMenu);
	}
}