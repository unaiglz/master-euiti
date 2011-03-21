package kudeatzaileak;

import interfazeak.EI_Bezeroa_Gehitu;
import interfazeak.EI_TerapeutaLibreak;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.table.DefaultTableModel;

import datuBaseKonexioa.DBKudeatzaile;

public class HitzorduKudeatzailea {
	
	private static HitzorduKudeatzailea instantzia = new HitzorduKudeatzailea();
	
	private HitzorduKudeatzailea(){
		
	}
	
	public static HitzorduKudeatzailea getInstantzia(){
		return instantzia;
	}
	
	
	/**
	 * Bezeroaren nan zenbakia, data eta ordu bat pasako zaio eta metodoak
	 * terapeuten zerrenda bat erakutsiko du bezeroak terapeuta aukeratu dezan
	 * @param nanZenbakia
	 * @param data
	 * @param ordua
	 * @param terapiaMota
	 */
	
	//data eta ordua datu basean parametro bakarra bezala dago jarrita
	//honengatik metodoan aldaketak egin beharko dira inkonpabilitate hau konpontzeko
	//gainera, String bezala jarrita daude
	
	public void HitzorduaEskatu(String nanZenbakia, String data, String ordua,
			String terapiaMota) {
		
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		
		//data eta ordua parametro berean sartzeko, baina konbertsio bat egin behar da
		String dataOrdua = data + ordua;
		
		String k2 = "SELECT Erabiltzaile.Nan,Erabiltzailea.Izena FROM " +
				"Erabiltzailea, Formakuntza, TerapiaMota WHERE " +
				"Erabiltzailea.nan=Formakuntza.ErabiltzaileaID AND " +
				"TerapiaMota.ID=Formakuntza.TerapiaMotaID AND " +
				"TerapiaMota.Izena=" + terapiaMota +
				"AND (Erabiltzaile.ID NOT IN SELECT terapeutaID FROM Hitzordua "
				+ "WHERE dataOrdua=" + dataOrdua + ")";
		
		ResultSet emaitza2 = dbk.getInstantzia().execSQL(k2);
		EI_TerapeutaLibreak libreak = new EI_TerapeutaLibreak(emaitza2);
		libreak.frame.setVisible(true);
		
	}
	public void taulaBete(DefaultTableModel modelo,ResultSet rs){

		try {
			ResultSetMetaData metaDatos = rs.getMetaData();
			// Se obtiene el número de columnas.
			int numeroColumnas = metaDatos.getColumnCount();

			// Se crea un array de etiquetas para rellenar
			Object[] etiquetas = new Object[numeroColumnas];

			// Se obtiene cada una de las etiquetas para cada columna
			for (int i = 0; i < numeroColumnas; i++)
			{
			   // Nuevamente, para ResultSetMetaData la primera columna es la 1. 
			   etiquetas[i] = metaDatos.getColumnLabel(i + 1); 
			}
			modelo.setColumnIdentifiers(etiquetas);
			while (rs.next())
			{
			   // Se crea un array que será una de las filas de la tabla. 
			   Object [] fila = new Object[numeroColumnas]; // Hay tres columnas en la tabla

			   // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
			   for (int i=0;i<numeroColumnas;i++)
			      fila[i] = rs.getObject(i+1); // El primer indice en rs es el 1, no el cero, por eso se suma 1.

			   // Se añade al modelo la fila completa.
			   modelo.addRow(fila); 
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
