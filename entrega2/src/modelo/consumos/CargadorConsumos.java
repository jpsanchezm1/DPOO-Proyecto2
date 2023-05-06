package modelo.consumos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import modelo.huespedes.Huesped;
import modelo.servicios.restaurante.ProductoMenu;
import modelo.servicios.Servicio;

public class CargadorConsumos {

	private void cargarConsumosServicios(String archivoConsumos,
			Map<String, List<ConsumoServicio>> mapaConsumosServicios, Map<String, Huesped> mapaHuespedes,
			Map<String, Servicio> mapaServicios) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoConsumos));
		String linea;
		while ((linea = lector.readLine()) != null) {
			String[] partes = linea.split(";");
			Huesped huesped = mapaHuespedes.get(partes[0]);
			String representante = huesped.getGrupo().getRepresentante().getNombre();
			Servicio servicio = mapaServicios.get(partes[1]);
			ConsumoServicio consumo = new ConsumoServicio(huesped, servicio, Boolean.parseBoolean(partes[2]));
			mapaConsumosServicios.computeIfAbsent(representante, k -> new ArrayList<>());
			mapaConsumosServicios.get(representante).add(consumo);
		}
		lector.close();
	}

	private void cargarConsumosRestaurante(String archivoConsumos,
			Map<String, List<ConsumoRestaurante>> mapaConsumosRestaurante, Map<String, Huesped> mapaHuespedes,
			Map<String, ProductoMenu> mapaProductosMenu) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoConsumos));
		String linea;
		while ((linea = lector.readLine()) != null) {
			String[] partes = linea.split(";");
			Huesped huesped = mapaHuespedes.get(partes[0]);
			String representante = huesped.getGrupo().getRepresentante().getNombre();
			ProductoMenu producto = mapaProductosMenu.get(partes[1]);
			ConsumoRestaurante consumo = new ConsumoRestaurante(huesped, producto, Boolean.parseBoolean(partes[2]));
			mapaConsumosRestaurante.computeIfAbsent(representante, k -> new ArrayList<>());
			mapaConsumosRestaurante.get(representante).add(consumo);
		}
		lector.close();
	}

	public void cargarConsumos(String archivoConsumosServicios, String archivoConsumosRest,
			Map<String, List<ConsumoServicio>> mapaConsumosServicios,
			Map<String, List<ConsumoRestaurante>> mapaConsumosRestaurante, Map<String, Huesped> mapaHuespedes,
			Map<String, Servicio> mapaServicios, Map<String, ProductoMenu> mapaProductosMenu) throws IOException {
		cargarConsumosServicios(archivoConsumosServicios, mapaConsumosServicios, mapaHuespedes, mapaServicios);
		cargarConsumosRestaurante(archivoConsumosRest, mapaConsumosRestaurante, mapaHuespedes, mapaProductosMenu);
	}
}