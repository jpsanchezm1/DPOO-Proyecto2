package modelo.huespedes;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class EditorHuespedes {

	public void guardarHuesped(String infoHuesped, String rutaArchivo) {

		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo, true))) {
			editor.newLine();
			editor.write(infoHuesped);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void guardarGrupos(HashMap<Integer, Grupo> grupos, String rutaArchivo) {
		try (BufferedWriter editor = new BufferedWriter(new FileWriter(rutaArchivo));) {
			ArrayList<Integer> representantesGuardados = new ArrayList<>();

			for (Grupo grupo : grupos.values()) {
				int idRepre = grupo.getRepresentante().getIdentificacion();
				if (!representantesGuardados.contains(idRepre)) {
					String infoGrupo = "" + idRepre;
					infoGrupo += ";";

					for (Huesped acompanante : grupo.getAcompanantes()) {
						infoGrupo += acompanante.getIdentificacion() + "-";
					}
					String nuevaInfoGrupo = infoGrupo.substring(0, infoGrupo.length() - 1);

					nuevaInfoGrupo += ";" + grupo.getCuotaTotal();

					editor.newLine();
					editor.write(nuevaInfoGrupo);
					representantesGuardados.add(idRepre);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
