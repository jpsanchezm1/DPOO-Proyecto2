package modelo.consumos;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import modelo.huespedes.Huesped;
import modelo.servicios.ProductoMenu;
import modelo.servicios.Servicio;

public class ControladorConsumos {

	private CargadorConsumos cargadorConsumos;

	public ControladorConsumos(Map<String, Huesped> mapaHuespedes, Map<String, ProductoMenu> mapaProductosMenu,
			Map<String, Servicio> mapaServicios) throws IOException {
		this.cargadorConsumos = new CargadorConsumos(mapaHuespedes, mapaProductosMenu, mapaServicios);
		cargadorConsumos.recuperarInformacion("ConsumoServicio");
		cargadorConsumos.recuperarInformacion("ConsumoRestaurante");
	}

	public Map<String, List<ConsumoServicio>> getmapaConsumosServicios() {
		return cargadorConsumos.getMapaConsumosServicios();
	}

	public Map<String, List<ConsumoRestaurante>> getmapaConsumosRestaurante() {
		return cargadorConsumos.getMapaConsumosRestaurante();
	}

	public void crearConsumo(String tipoConsumo, String huespedString, String referencia, String pagoString)
			throws IOException {
		cargadorConsumos.crearConsumo(true, tipoConsumo, huespedString, referencia, pagoString);
	}

	public List<ConsumoServicio> getConsumosServicio(String huespedRepresentante) {
		return cargadorConsumos.getMapaConsumosServicios().get(huespedRepresentante);
	}

	public List<ConsumoRestaurante> getConsumosRestaurante(String huespedRepresentante) {
		return cargadorConsumos.getMapaConsumosRestaurante().get(huespedRepresentante);
	}
}
