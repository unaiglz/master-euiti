package kudeatzaileak;

import interfazeak.EI_Bezeroa_Gehitu;
import interfazeak.EI_Hitzordua_Gehituta;
import interfazeak.EI_Hitzorduaren_Datuak_Erakutsi;
import interfazeak.EI_TerapeutaLibreak;
import interfazeak.EI_Trataketa_Amaitua;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import datuBaseKonexioa.DBKudeatzaile;

public class HitzorduKudeatzailea {

	private static HitzorduKudeatzailea instantzia = new HitzorduKudeatzailea();

	private HitzorduKudeatzailea() {

	}

	public static HitzorduKudeatzailea getInstantzia() {
		return instantzia;
	}

	/**
	 * Bezeroaren nan zenbakia, data eta ordu bat pasako zaio eta metodoak
	 * terapeuten zerrenda bat erakutsiko du bezeroak terapeuta aukeratu dezan
	 * 
	 * @param nanZenbakia
	 * @param data
	 * @param ordua
	 * @param terapiaMota
	 */

	// data eta ordua datu basean parametro bakarra bezala dago jarrita
	// honengatik metodoan aldaketak egin beharko dira inkonpabilitate hau
	// konpontzeko
	// gainera, String bezala jarrita daude

	public void HitzorduaEskatu(String nanZenbakia, String data, String ordua,
			String terapeutaID, String terapiaMota) {

		// EGIN BEHARREKOA: pasatuko dizkigun balioak jada dakigu egokiak
		// direzela, beraz bakarrik sortu behar dugu query bat datuak datu
		// basean gorde daitezen
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String k1 = "INSERT INTO  Hitzordua ( dataOrdua, terapeutaID , bezeroID , terapiaMotaID ,kobratuta) VALUES ( '"
				+ data
				+ " "
				+ ordua
				+ "', '"
				+ terapeutaID
				+ "','"
				+ nanZenbakia + "','" + terapiaMota + "', 0 )";
		String k2 = "INSERT INTO DataTaOrdua (dataOrdua) VALUES ('" + data
				+ " " + ordua + "')";
		dbk.execSQL(k2);
		dbk.execSQL(k1);
		new EI_Hitzordua_Gehituta(nanZenbakia, data, ordua, terapeutaID,
				terapiaMota);
	}

	public void terapeutaTaulaBete(DefaultTableModel modelo, ResultSet rs) {

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

	public void taulaBete(DefaultTableModel modelo) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT dataOrdua,terapeutaID,bezeroID,terapiaMotaID,Kobratuta,tratatua FROM Hitzordua WHERE Kobratuta=0 or tratatua=0";
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

	public String terapeutarenOharra(String data, String bezeroID) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT terapeutarenOharra FROM Hitzordua WHERE dataOrdua='"
				+ data + "' AND bezeroID='" + bezeroID + "'";
		ResultSet rs = dbk.execSQL(K1);
		String aux;
		try {
			rs.next();
			if (rs.getString("terapeutarenOharra") == null) {
				return "Ez dauka oharrik";
			} else {
				return rs.getString("terapeutarenOharra");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Ez du zentzurik";
		}
	}

	/**
	 * hitzordu baten kontsulta egiteko balio du, interfaze berri batean datuak
	 * jarriko ditu
	 * 
	 * @param data
	 * @param terapeutaID
	 * @param bezeroID
	 * @param terapiaMotaID
	 */
	public void hitzorduDatuakLortu(String data, String terapeutaID,
			String bezeroID, String terapiaMotaID) {

		Vector<String> hitzordua = new Vector<String>();
		hitzordua.add(data.substring(0, 10));
		hitzordua.add(data.substring(11));
		hitzordua.add(terapeutaID);
		hitzordua.add(bezeroID);
		hitzordua.add(terapiaMotaID);
		EI_Hitzorduaren_Datuak_Erakutsi eiHitzordua = new EI_Hitzorduaren_Datuak_Erakutsi(
				hitzordua);
		/*
		 * DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		 * 
		 * String k1 = "SELECT * FROM Hitzordua " + "WHERE dataOrdua='" + data +
		 * "' AND terapeutaID='" + terapeutaID + "' AND bezeroID='" + bezeroID +
		 * "' AND terapiaMotaID='" + terapiaMotaID + "';"; ResultSet emaitza1 =
		 * dbk.execSQL(k1); try { emaitza1.next(); // datuak lortu eta zerrendan
		 * sartzen dira Date hData = emaitza1.getDate("dataOrdua"); String
		 * hUrteaHilabeteaEguna = String.valueOf(hData.getYear() +
		 * hData.getMonth() + hData.getDate());
		 * String.valueOf(hData.toLocaleString()); String hOrduaMinutuaSegundua
		 * = String.valueOf(hData.getHours() + hData.getMinutes() +
		 * hData.getSeconds());
		 * hitzordua.add(String.valueOf(hUrteaHilabeteaEguna));
		 * hitzordua.add(hOrduaMinutuaSegundua); int hTerapeuta =
		 * emaitza1.getInt("terapeutaID");
		 * hitzordua.add(String.valueOf(hTerapeuta)); int hBezero =
		 * emaitza1.getInt("bezeroID"); hitzordua.add(String.valueOf(hBezero));
		 * int hMota = emaitza1.getInt("terapiaMotaID");
		 * hitzordua.add(String.valueOf(hMota)); String hOharra =
		 * emaitza1.getString("terapeutarenOharra"); hitzordua.add(hOharra); int
		 * hKobratuta = emaitza1.getInt("kobratuta");
		 * hitzordua.add(String.valueOf(hKobratuta));
		 * EI_Hitzorduaren_Datuak_Erakutsi eiHitzordua = new
		 * EI_Hitzorduaren_Datuak_Erakutsi( hitzordua);
		 * 
		 * 
		 * } catch (SQLException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 */
	}

	public void hitzorduaTratatuta(String dataOrdua, String terapeutaID,
			String bezeroID, String terapiaMotaID, String idatzitakoOharra) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "UPDATE Hitzordua SET tratatua = 1, terapeutarenOharra= '"
				+ idatzitakoOharra + "' WHERE dataOrdua='" + dataOrdua
				+ "' AND terapeutaID='" + terapeutaID + "'";
		dbk.execSQL(K1);
		new EI_Trataketa_Amaitua(dataOrdua);
	}
	
	public void hitzorduaAldatuOrduaz(String dataOrdua, String terapeutaID,
			String dataOrdua1) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "UPDATE Hitzordua SET dataOrdua ='" + dataOrdua1 + "'WHERE dataOrdua='" + dataOrdua
				+ "' AND terapeutaID='" + terapeutaID + "'";
		dbk.execSQL(K1);
	}

	public void hitzorduaAldatu(String terBerria, String dataOrdua, String aurrekoTer) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "UPDATE Hitzordua SET terapeutaID='" + terBerria + "' WHERE dataOrdua='" + dataOrdua
			+ "' AND terapeutaID='" + aurrekoTer + "'";
		dbk.execSQL(K1);
	}

}
