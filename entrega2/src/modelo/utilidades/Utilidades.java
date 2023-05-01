package modelo.utilidades;

import java.time.DayOfWeek;
import java.util.HashMap;
import java.util.Map;

public class Utilidades {

	private static final Map<DayOfWeek, String> DIAS_EN_ESPANOL = new HashMap<>();
	static {
		DIAS_EN_ESPANOL.put(DayOfWeek.MONDAY, "L");
		DIAS_EN_ESPANOL.put(DayOfWeek.TUESDAY, "M");
		DIAS_EN_ESPANOL.put(DayOfWeek.WEDNESDAY, "I");
		DIAS_EN_ESPANOL.put(DayOfWeek.THURSDAY, "J");
		DIAS_EN_ESPANOL.put(DayOfWeek.FRIDAY, "V");
		DIAS_EN_ESPANOL.put(DayOfWeek.SATURDAY, "S");
		DIAS_EN_ESPANOL.put(DayOfWeek.SUNDAY, "D");
	}
	public static String getDiaEnEspaniol(DayOfWeek dia) {
		return DIAS_EN_ESPANOL.get(dia);
	}
	
}
