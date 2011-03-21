package kudeatzaileak;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Date;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.table.DefaultTableModel;

import datuBaseKonexioa.DBKudeatzaile;

public class BezeroKudeatzaile {

	private static BezeroKudeatzaile instantzia= new BezeroKudeatzaile();

	private BezeroKudeatzaile(){
		
	}
	
	public static BezeroKudeatzaile getInstantzia(){
		return instantzia;
	}
	public boolean bezeroaBilatu(String nan){
		Boolean badago=true;
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT COUNT(*) AS m FROM Bezeroa WHERE Nan='"
			+ nan + "'";
		ResultSet rs = dbk.execSQL(K1);
		try {
			rs.next();
			//probak
			if (rs.getInt("m") != 0) {
				badago=true;
				System.out.println("badago");
			} else {
				badago=false;
				System.out.println("ez dago");
			}
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
		return badago;
	}
	public void bezeroaGehitu(String nan, String izena, String jaiotzeData, String helbidea) {
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
			String K1 = "INSERT INTO Bezeroa VALUES('" + nan + "','"
			+ izena + "','" + jaiotzeData + "','" + helbidea + "')";
			dbk.execSQL(K1);
	}
	public void taulaBete(DefaultTableModel modelo){
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		String K1 = "SELECT * FROM Bezeroa";
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
