package kudeatzaileak;

import interfazeak.EI_Error_TerapiaMotaExistu;
import interfazeak.EI_TerapiaMotaGehitu;
import interfazeak.EI_TerapiaMotaGehituta;

import java.awt.EventQueue;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import javax.swing.table.DefaultTableModel;

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
	public void taulaBete(DefaultTableModel modelo){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT * FROM TerapiaMota";
		ResultSet rs = dbk.execSQL(K1);
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
