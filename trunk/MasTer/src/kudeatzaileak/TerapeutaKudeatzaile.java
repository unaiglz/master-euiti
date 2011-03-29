package kudeatzaileak;

import interfazeak.EI_DataGaizki;
import interfazeak.EI_TerapeutaDatuAldaketa;
import interfazeak.EI_TerapeutaOndoSartuDa;
import interfazeak.EI_Terapeuta_Datuak_Bistaratu;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.ComboBoxModel;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import datuBaseKonexioa.DBKudeatzaile;

public class TerapeutaKudeatzaile {
	private EI_TerapeutaOndoSartuDa terapeutaOndoSartuDa;
	private static TerapeutaKudeatzaile instantzia = new TerapeutaKudeatzaile();
	java.util.Date utilDate;

	private TerapeutaKudeatzaile() {
		utilDate = new java.util.Date(); // fecha actual
		long lnMilisegundos = utilDate.getTime();

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

	/**
	 * Terapeuta datu basean dagoen konprobatuko du, horrela bada bere rola
	 * aktibo bezala jarriko du. Bestalde, ez badago, datu basean sartutako
	 * parametroekin erabiltzaile bat sortuko du.
	 * 
	 * @param izena
	 * @param nan
	 * @param pasahitza
	 * @param helbidea
	 * @param jaiotzeData
	 */

	public void terapeutaGehitu(String izena, String nan, String pasahitza,
			String helbidea, Calendar jaiotzeData) {
		// Idazkaria identifikatuta dagoela konprobatu behar da lehenengo eta

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		// Terapeuta datu-basean dagoen begiratzeko
		String k1 = "SELECT NAN FROM Erabiltzailea WHERE NAN= '" + nan + " ' ";

		ResultSet emaitza1 = dbk.execSQL(k1);
		try {
			emaitza1.next();
			if (emaitza1.getRow() == 0) {
				// Terapeuta ez dago datu-basean eta honetan sartzen dugu

				String k2 = "INSERT INTO Erabiltzailea VALUES" + "('" + nan
						+ "','" + izena + "','MD5('" + pasahitza + "'),'"
						+ helbidea + "','" + "','" + jaiotzeData
						+ "','Terapeuta','1') ";
				dbk.execSQL(k2);
			} else {
				// Terapeuta datu basean dago, honetan egiten dugun bakarra rol
				// atributua aktibo moduan jartzea da
				String k3 = "UPDATE Erabiltzailea SET Aktiboa='1' WHERE Nan='"
						+ nan + "'";
				dbk.execSQL(k3);
			}
			terapeutaOndoSartuDa = new EI_TerapeutaOndoSartuDa();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Idazkariari datu-basean sartuta dauden terapeuta guztiak erakuzten
	 * zaizkio, (aktiboak daudenak, zein ez daudenak) gero honek nahi badu,
	 * terapeuta baten gainean klikatu eta bere informazioa agertuko da.
	 * Azkenik, terapeuta horren agenda kontsultau dezake.
	 */

	public void terapeutaKontsulta() {

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		// Datu-baseko terapeuta guztiak erakusten ditu
		String k1 = "SELECT Nan,Izena FROM Erabiltzailea WHERE rol='terapeuta'";
		ResultSet Emaitza1 = dbk.execSQL(k1);

		try {
			// Terapeuten zerrendan nan eta izenak gordeko dira,hau da,
			// terapeuta
			// bakoitzeko bi posizio gordeko dira, bat nan zenbakirako eta beste
			// izenerako.
			Vector<String> terapeutaZerrenda = new Vector<String>();
			int iterazioak = Emaitza1.getRow();
			for (int i = 0; i < iterazioak; i++) {
				Emaitza1.next();
				String terapeutaNan = Emaitza1.getString("Nan");
				String terapeutaIzena = Emaitza1.getString("Izena");
				terapeutaZerrenda.add(terapeutaNan);
				terapeutaZerrenda.add(terapeutaIzena);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Terapeutaren Nan-a jasotzen du parametro moduan eta bere agenda itzuli
	 * behar du.
	 * 
	 * @param Nan
	 */
	public void AgendaKontsultatu(String Nan) {

	}

	public void taulaBete(DefaultTableModel modelo) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT Nan,Izena,Helbidea,jaiotzeD,aktiboa FROM Erabiltzailea WHERE rol='terapeuta'";
		ResultSet rs = dbk.execSQL(K1);
		try {
			ResultSetMetaData metaDatos = rs.getMetaData();
			// Se obtiene el número de columnas.
			int numeroColumnas = metaDatos.getColumnCount();

			// Se crea un array de etiquetas para rellenar
			Object[] etiquetas = new Object[numeroColumnas];

			// Se obtiene cada una de las etiquetas para cada columna
			for (int i = 0; i < numeroColumnas; i++) {
				// Nuevamente, para ResultSetMetaData la primera columna es la
				// 1.
				etiquetas[i] = metaDatos.getColumnLabel(i + 1);
			}
			modelo.setColumnIdentifiers(etiquetas);
			while (rs.next()) {
				// Se crea un array que será una de las filas de la tabla.
				Object[] fila = new Object[numeroColumnas]; // Hay tres columnas
															// en la tabla

				// Se rellena cada posición del array con una de las columnas de
				// la tabla en base de datos.
				for (int i = 0; i < numeroColumnas; i++)
					fila[i] = rs.getObject(i + 1); // El primer indice en rs es
													// el 1, no el cero, por eso
													// se suma 1.

				// Se añade al modelo la fila completa.
				modelo.addRow(fila);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public Vector<Terapeuta> terapeutaLibreakLortu(String date, String time,
			String terapMot) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String dateTime = date + " " + time;

		/*
		 * Hitzorduaren ordua eta data , NOSKI ,uneko momentutik aurrera izan
		 * behar da horretarako after metodoa erabili behar da. Baina nola lortu
		 * nire dateTime-ak parametro moduan hartzea?
		 */
		if (true) {

			String k1 = "SELECT NAN , Izena FROM Erabiltzailea WHERE rol='Terapeuta' AND NAN IN (SELECT erabiltzaileID FROM Formakuntza WHERE terapiaMotaID='"
					+ terapMot
					+ "' UNION SELECT terapeutaID FROM Hitzordua WHERE dataOrdua<>'"
					+ dateTime + "')";
			ResultSet rs = dbk.execSQL(k1);
			Vector<Terapeuta> terapeutaLibreak = new Vector<Terapeuta>();
			try {
				while (rs.next()) {
					terapeutaLibreak.add(new Terapeuta(rs.getString("NAN"), rs
							.getString("Izena")));
				}
			} catch (SQLException e) {
				// EMAITZA HUTSA
				e.printStackTrace();
			}

			return terapeutaLibreak;
		} else {
			new EI_DataGaizki(date);
			return null;
		}

	}

	public class Terapeuta {
		private String nan;
		private String izena;

		public Terapeuta(String nan, String izena) {
			this.nan = nan;
			this.izena = izena;
		}

		public String getNan() {
			return nan;
		}

		public String getIzena() {
			return izena;
		}

		public String toString() {
			return izena;
		}

	}
}
