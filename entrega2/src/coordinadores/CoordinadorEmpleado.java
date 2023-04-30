package coordinadores;

import java.io.IOException;
import java.util.Map;

import modelo.huespedes.Huesped;
import modelo.consumos.ControladorConsumos;
import modelo.servicios.ProductoMenu;
import modelo.servicios.Servicio;

public class CoordinadorEmpleado {

	ControladorConsumos controladorConsumos;

	public CoordinadorEmpleado(Map<String, Huesped> mapaHuespedes, Map<String, ProductoMenu> mapaProductosMenu,
			Map<String, Servicio> mapaServicios) throws IOException {
		this.controladorConsumos = new ControladorConsumos(null, null, null);
	}

	public void registrarConsumo(String tipoConsumo, String huespedString, String referencia, String pagoString)
			throws IOException {
		controladorConsumos.crearConsumo(tipoConsumo, huespedString, referencia, pagoString);
	}
}
