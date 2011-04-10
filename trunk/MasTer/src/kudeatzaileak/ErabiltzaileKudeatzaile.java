package kudeatzaileak;

import interfazeak.EI_Pasahitza_Aldatu;
import interfazeak.EI_TerapeutaOndoSartuDa;
import interfazeak.EI_loginInterfaz;

import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JPasswordField;

import klinikakoInterfaz.EI_Idazkaria;
import klinikakoInterfaz.EI_Terapeuta;

import datuBaseKonexioa.DBKudeatzaile;

public class ErabiltzaileKudeatzaile {
	private EI_Idazkaria eiIdazkaria;
	private EI_Terapeuta eiTerapetua;
	private static ErabiltzaileKudeatzaile instantzia = new ErabiltzaileKudeatzaile();

	private ErabiltzaileKudeatzaile() {
		// hemen aurrerago metodoak egon beharko dira
	}

	/**
	 * 
	 * @return Bueltatzen du kudeatzailearen instantzia (SINGLETON PATROIA)
	 */
	public static ErabiltzaileKudeatzaile getInstantzia() {
		return instantzia;
	}

	/**
	 * Konprobatu erabiltzailea existitzen den, eta ea existitzen den
	 * 
	 * @param erab
	 *            = pasatuko diogu programari erabiltzaileak sartutako izena
	 *            interfazean
	 * @param pasahitza
	 *            = pasatuko diogu programari erabiltzaileak sartutako pasahitza
	 *            interfazean
	 * @return
	 */
	public boolean identifikazioaKonprobatu(String erab, char[] pasahitza) {
		String pass = String.valueOf(pasahitza);
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "SELECT * FROM Erabiltzailea WHERE izena = '" + erab
				+ "' AND pasahitza = MD5('" + pass + "') ";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.last();
			if (rs.getRow() != 1) {
				EI_loginInterfaz.errorea();
			} else {
				rs.beforeFirst();
				rs.next();
				String rol = rs.getString("rol");
				if (rol.equalsIgnoreCase("idazkaria")) {
					eiIdazkaria = new EI_Idazkaria();
				} else if (rol.equalsIgnoreCase("terapeuta")) {
					/*
					 * String K2 =
					 * "SELECT NAN FROM Erabiltzailea WHERE izena = '" + erab +
					 * "' AND pasahitza = MD5('" + pass + "') "; ResultSet rs2 =
					 * dbk.execSQL(K2); rs2.next(); String terapeutaNAN =
					 * rs2.getString("NAN"); eiTerapetua = new
					 * EI_Terapeuta(terapeutaNAN);
					 */
					eiTerapetua = new EI_Terapeuta(rs.getString("NAN"));
				}
				return true;
			}
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
		return false;
	}

	public void pasahitzAldaketa(String id, String zah, String ber, String ber1) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String k1 = "SELECT pasahitza FROM Erabiltzailea WHERE NAN= '" + id
				+ " ' AND pasahitza=MD5('" + zah + "')";
		ResultSet rs = dbk.execSQL(k1);
		try {
			rs.next();
			k1 = "UPDATE Erabiltzailea SET pasahitza='" + ber + "' WHERE NAN="
					+ id;
			dbk.execSQL(k1);
		} catch (SQLException e) {
			// esan nahi du pasahitza okerra dela
			EI_Pasahitza_Aldatu.errorea(2);
		}

	}

	public String lortuIzena(String erID) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT Izena From Erabiltzailea WHERE NAN='" + erID + "'";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.next();
			return rs.getString("Izena");
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
		return null;
	}
}
