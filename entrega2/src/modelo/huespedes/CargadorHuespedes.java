package modelo.huespedes;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class CargadorHuespedes {

	public void cargarHuespedes(String rutaArchivo, HashMap<Integer, Huesped> huespedes) throws IOException {

		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = br.readLine();

			while (linea != null) {
				String[] partes = linea.split(";");
				String nombre = partes[0];
				int id = Integer.parseInt(partes[1]);
				int numCel = Integer.parseInt(partes[2]);
				String correo = partes[4];

				Huesped huespedActual = new Huesped(nombre, id, numCel, correo);

				huespedes.put(id, huespedActual);

				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

	public void cargarHuespedesGrupos(String rutaArchivo, HashMap<Integer, Huesped> huespedes,
			HashMap<Integer, Grupo> huespedesGruposReg) throws IOException {
		try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {

			String linea = br.readLine();

			while (linea != null) {
				String[] partes = linea.split(";");
				int idRepre = Integer.parseInt(partes[0]);
				Huesped representante = huespedes.get(idRepre);

				Grupo grupoActual = new Grupo(representante);
				huespedesGruposReg.put(idRepre, grupoActual);

				ArrayList<Huesped> acompanantes = new ArrayList<>();

				String[] partesAcompanantes = partes[1].split("-");
				for (String idAcom : partesAcompanantes) {
					acompanantes.add(huespedes.get(Integer.parseInt(idAcom)));
					huespedesGruposReg.put(Integer.parseInt(idAcom), grupoActual);
				}

				Float cuotaTotal = Float.parseFloat(partes[2]);

				grupoActual.aniadirAcompanantes(acompanantes);
				grupoActual.sumarACuotaTotal(cuotaTotal);

				linea = br.readLine();
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}

}
