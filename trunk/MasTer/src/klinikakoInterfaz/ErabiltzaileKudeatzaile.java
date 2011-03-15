package klinikakoInterfaz;

import java.sql.ResultSet;
import java.sql.SQLException;

import datuBaseKonexioa.DBKudeatzaile;

public class ErabiltzaileKudeatzaile {

	public static void identifikazioaKonprobatu(String erab, char[] pasahitza) {
		String pass = String.valueOf(pasahitza);
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "SELECT * FROM Erabiltzailea WHERE izena = '" + erab
				+ "' AND pasahitza = SHA5('" + pass + "') ";
		// SHA5-rekin errorea ematen du
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.last();
			if (rs.getRow() != 1) {
				loginInterfaz.errorea();
			} else {
				rs.beforeFirst();
				rs.next();
				String rol = rs.getString("rol");
				if (rol.equalsIgnoreCase("idazkaria")) {
					new EI_Idazkaria();
				} else if (rol.equalsIgnoreCase("terapeuta")) {
					new EI_Terapeuta();
				} // Beste kasu berezi bat inplementatzea ez du merezi
			}
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
	}
}
