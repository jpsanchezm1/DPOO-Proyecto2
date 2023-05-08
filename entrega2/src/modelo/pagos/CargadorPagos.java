package modelo.pagos;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CargadorPagos {
	public void cargarPagos(String archivoPagos, Map<Integer, List<Pago>> pagosPorHuesped,
			Map<String, Pago> pagosDeReserva) throws IOException {
		BufferedReader lector = new BufferedReader(new FileReader(archivoPagos));
		String linea;
		while ((linea = lector.readLine()) != null) {
			if (linea.contains(":")) {
				String[] partes = linea.split(":");
				Pago pago = new Pago(Integer.parseInt(partes[0]), partes[1], LocalTime.parse(partes[2]));
				pagosDeReserva.put(linea, pago);
			} else {
				String[] partes = linea.split(";");
				Integer id = Integer.parseInt(partes[0]);
				Pago pago = new Pago(id, partes[1], LocalTime.parse(partes[2]));
				pagosPorHuesped.computeIfAbsent(id, k -> new ArrayList<>());
				pagosPorHuesped.get(id).add(pago);
			}
		}
		lector.close();
	}
}
