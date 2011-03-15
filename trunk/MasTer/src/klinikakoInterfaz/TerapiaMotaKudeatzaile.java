package klinikakoInterfaz;

import java.sql.ResultSet;
import java.sql.SQLException;

import datuBaseKonexioa.DBKudeatzaile;

public class TerapiaMotaKudeatzaile {
	private static TerapiaMotaKudeatzaile instantzia = new TerapiaMotaKudeatzaile();

	private TerapiaMotaKudeatzaile() {
		// TODO Auto-generated constructor stub
	}

	public static TerapiaMotaKudeatzaile getInstantzia() {
		return instantzia;

	}

	/**
	 * TerapiaMota gehitzeko interfazea irekiko da
	 */
	public void terapiaGehitzekoEskaera() {

	}

	/**
	 * 
	 * @param izena
	 * @param prezioa
	 */
	public void terapiaMotaGehitu(String izena, int iraupena, float prezioa) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "SELECT COUNT(*) FROM terapiaMota WHERE izena='" + izena
				+ "'";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.next();
			if (rs.getInt(0) != 0) {
				// Pop-up pantaila programatu errorearen berri ematen duena;
			} else {
				K1 = "INSERT INTO terapiaMota VALUES(0,'" + izena + "','"
						+ iraupena + "','" + prezioa + "')";
				dbk.execSQL(K1);
				// Pop-up pantaila ok esanez
			}
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
	}
}
