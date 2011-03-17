package klinikakoInterfaz;

import java.awt.EventQueue;
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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EI_TerapiaMotaGehitu frame = new EI_TerapiaMotaGehitu();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * 
	 * @param izena
	 * @param prezioa
	 */
	public void terapiaMotaGehitu(String izena, int iraupena, float prezioa) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "SELECT COUNT(*) AS m FROM TerapiaMota WHERE izena='"
				+ izena + "'";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.next();
			if (rs.getInt("m") != 0) {
				new EI_Error_TerapiaMotaExistu();
			} else {
				K1 = "INSERT INTO TerapiaMota VALUES(0,'" + izena + "','"
						+ iraupena + "','" + prezioa + "')";
				dbk.execSQL(K1);
				new EI_TerapiaMotaGehituta(izena, iraupena, prezioa);
			}
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
	}
}
