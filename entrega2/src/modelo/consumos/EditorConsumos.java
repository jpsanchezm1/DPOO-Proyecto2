package modelo.consumos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class EditorConsumos {
	public void registrarConsumo(String rutaArchivo, String idRepresentante, String referencia) throws IOException {
		BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true));
		String registro = (idRepresentante + ";" + referencia);
		editor.write(registro);
		editor.newLine();
		editor.close();
	}

	public void guardarRegistros(String archivoConsumosServicios, String archivoConsumosRest,
			Map<Integer, List<ConsumoServicio>> mapaConsumosServicios,
			Map<Integer, List<ConsumoRestaurante>> mapaConsumosRestaurante) throws IOException {
		for (Integer idRepresentante : mapaConsumosServicios.keySet()) {
			for (ConsumoServicio consumo : mapaConsumosServicios.get(idRepresentante)) {
				registrarConsumo(archivoConsumosServicios, consumo.getHuesped().getIdentificacion().toString(),
						consumo.getServicio().getNombre());
			}
		}
		for (Integer idRepresentante : mapaConsumosRestaurante.keySet()) {
			for (ConsumoRestaurante consumo : mapaConsumosRestaurante.get(idRepresentante)) {
				registrarConsumo(archivoConsumosRest, consumo.getHuesped().getIdentificacion().toString(),
						consumo.getProductoMenu().getNombre());
			}
		}
	}
}
