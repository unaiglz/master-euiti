package kudeatzaileak;

import interfazeak.EI_TerapeutaDatuAldaketa;
import interfazeak.EI_Terapeuta_Datuak_Bistaratu;

import java.sql.ResultSet;
import java.sql.SQLException;

import datuBaseKonexioa.DBKudeatzaile;

public class TerapeutaKudeatzaile {
	private static TerapeutaKudeatzaile instantzia = new TerapeutaKudeatzaile();

	private TerapeutaKudeatzaile() {
		// TODO Auto-generated constructor stub
	}

	public static TerapeutaKudeatzaile getInstantzia() {
		return instantzia;
	}

	public void terapeutaAldatzekoEskaera(String id) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "SELECT * FROM Terapeuta WHERE id='" + id + "'";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.next();
			String izena = rs.getString("izena");
			String helbidea = rs.getString("helbidea");
			int aktiboa = rs.getInt("aktiboa");
			rs.close();
			new EI_TerapeutaDatuAldaketa(id, izena, helbidea, aktiboa);
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
	}

	public void terapeutaAldatu(String id, String izena, String helbidea,
			int aktiboa) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "UPDATE Erabiltzailea SET izena='" + izena
				+ "' AND helbidea ='" + helbidea + "' AND aktiboa='" + aktiboa
				+ "' WHERE NAN='" + id + "'";
		dbk.execSQL(K1);

		new EI_Terapeuta_Datuak_Bistaratu(izena, helbidea, aktiboa);

	}
}
