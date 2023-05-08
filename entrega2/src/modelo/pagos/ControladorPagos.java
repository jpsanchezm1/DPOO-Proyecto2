package modelo.pagos;

import java.io.IOException;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControladorPagos {
	private Map<Integer, List<Pago>> pagosPorHuesped = new HashMap<>(); // id del huesped, lista de pagos

	private Map<String, Pago> pagosDeReserva = new HashMap<>(); // referencia de la reserva, pago

	private String archivoPagos = "./data/consumos/pagos.txt";

	public ControladorPagos() throws IOException {
		recuperarInformacion();
	}

	public void pagarConsumo(String ide, String referencia) {
		LocalTime tiempoActual = LocalTime.now();
		Integer id = Integer.parseInt(ide);
		Pago pago = new Pago(id, referencia, tiempoActual);
		pagosPorHuesped.computeIfAbsent(id, k -> new ArrayList<>());
		pagosPorHuesped.get(id).add(pago);
		EditorPagos editorPagos = new EditorPagos();
		String infoPago = id.toString() + ";" + referencia + ";" + tiempoActual.toString();
		editorPagos.registarPago(archivoPagos, infoPago);
	}

	public void pagarReserva(String ide, String referencia) {
		LocalTime tiempoActual = LocalTime.now();
		Integer id = Integer.parseInt(ide);
		Pago pago = new Pago(id, referencia, tiempoActual);
		pagosDeReserva.put(referencia, pago);
		EditorPagos editorPagos = new EditorPagos();
		String infoPago = id.toString() + ":" + referencia + ":" + tiempoActual.toString();
		editorPagos.registarPago(archivoPagos, infoPago);
	}

	private void recuperarInformacion() throws IOException {
		CargadorPagos cargadorPagos = new CargadorPagos();
		cargadorPagos.cargarPagos(archivoPagos, pagosPorHuesped, pagosDeReserva);
	}
}
