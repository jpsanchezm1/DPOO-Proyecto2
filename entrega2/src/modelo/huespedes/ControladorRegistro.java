package modelo.huespedes;

import java.util.ArrayList;
import java.util.HashMap;

public class ControladorRegistro {

	private HashMap<Integer, Huesped> huespedesReg;

	//guardamos los huespedes por id. Los valores son el grupo del huesped
	private HashMap<Integer, Grupo> huespedesGruposReg;

	public Grupo crearGrupo(String infoHuesped) {
		String[] partes = infoHuesped.split(";");

		Huesped representante = new Huesped(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]),
				partes[3]);
		Grupo grupo = new Grupo(representante);

		huespedesReg.put(representante.getIdentificacion(), representante);
		huespedesGruposReg.put(representante.getIdentificacion(), grupo);

		return grupo;
	}

	public void aniadirAcompanantes(ArrayList<String> infoAcompanantes, Grupo grupo) {
		ArrayList<Huesped> acompanantes = new ArrayList<>();

		for (String infoAcompanante : infoAcompanantes) {

			String[] partes = infoAcompanante.split(";");

			Huesped acompanante = new Huesped(partes[0], Integer.parseInt(partes[1]), Integer.parseInt(partes[2]),
					partes[3]);
			acompanantes.add(acompanante);
			
			huespedesReg.put(acompanante.getIdentificacion(), acompanante);
			huespedesGruposReg.put(acompanante.getIdentificacion(), grupo);
		}

		grupo.aniadirAcompanantes(acompanantes);
	}
	
	//Recibe una id de un huesped y retorna el grupo al que pertenece el huesped
	public Grupo getGrupoPorId(int id) {
		return huespedesGruposReg.get(id);
	}
	
	//Recibe una id de un huesped y retorna el huesped como objeto
	public Huesped getHuespedPorId(int id) {
		return huespedesReg.get(id);
	}
	
	//Recibe una id de un huesped y un monto y carga el monto al grupo del huesped
	public void cargarMonto(int id, float monto) {
		getGrupoPorId(id).sumarACuotaTotal(monto);
	}

}
