package modelo.pagos;

import java.time.LocalTime;

public class Pago {
	private Integer idHuesped;

	private String referencia;

	private LocalTime tiempo;

	public Pago(Integer idHuesped, String referencia, LocalTime tiempo) {
		super();
		this.idHuesped = idHuesped;
		this.referencia = referencia;
		this.tiempo = tiempo;
	}

	public Integer getIdHuesped() {
		return idHuesped;
	}

	public String getReferencia() {
		return referencia;
	}

	public LocalTime getTiempo() {
		return tiempo;
	}

}
