package modelo.consumos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EditorConsumos {
	public void registrarConsumo(String rutaArchivo, String huesped, String referencia, String pago)
			throws IOException {
		BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true));
		String registro = (huesped + referencia + pago);
		editor.write(registro);
		editor.newLine();
		editor.close();
	}

	public void guardarRegistros(String archivoConsumosServicios, String archivoConsumosRest,
			Map<String, List<ConsumoServicio>> mapaConsumosServicios,
			Map<String, List<ConsumoRestaurante>> mapaConsumosRestaurante) throws IOException {
		for (String huesped : mapaConsumosServicios.keySet()) {
			for (ConsumoServicio consumo : mapaConsumosServicios.get(huesped)) {
				registrarConsumo(archivoConsumosServicios, consumo.getHuesped().getNombre(),
						consumo.getServicio().getNombre(), consumo.getPago().toString());
			}
		}
		for (String huesped : mapaConsumosRestaurante.keySet()) {
			for (ConsumoRestaurante consumo : mapaConsumosRestaurante.get(huesped)) {
				registrarConsumo(archivoConsumosRest, consumo.getHuesped().getNombre(),
						consumo.getProductoMenu().getNombre(), consumo.getPago().toString());
			}
		}
	}
}
