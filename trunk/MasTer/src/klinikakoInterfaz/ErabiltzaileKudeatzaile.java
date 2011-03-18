package klinikakoInterfaz;

import java.io.ObjectInputStream.GetField;
import java.sql.ResultSet;
import java.sql.SQLException;

import datuBaseKonexioa.DBKudeatzaile;

public class ErabiltzaileKudeatzaile {
	private EI_TerapeutaOndoSartuDa terapeutaOndoSartuDa;
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
	 */
	public void identifikazioaKonprobatu(String erab, char[] pasahitza) {
		String pass = String.valueOf(pasahitza);
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		String K1 = "SELECT * FROM Erabiltzailea WHERE izena = '" + erab
				+ "' AND pasahitza = MD5('" + pass + "') ";
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
					eiIdazkaria = new EI_Idazkaria();
				} else if (rol.equalsIgnoreCase("terapeuta")) {
					eiTerapetua = new EI_Terapeuta();
				} // Beste kasu berezi bat inplementatzea ez du merezi
			}
		} catch (SQLException e) {
			// EMAITZA HUTSA
			e.printStackTrace();
		}
	}
	
	/**
	 * Terapeuta datu basean dagoen konprobatuko du, horrela bada 
	 * bere rola aktibo bezala jarriko du. Bestalde, ez badago, datu basean sartutako
	 * parametroekin erabiltzaile bat sortuko du.
	 * @param izena
	 * @param nan
	 * @param pasahitza
	 * @param helbidea
	 */
	
	public void terapeutaGehitu(String izena, String nan, String pasahitza, String helbidea){
		//Idazkaria identifikatuta dagoela konprobatu behar da lehenengo eta rola boolean
		//bezala hartu da, hau aldatu behar da
		
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		
		//Terapeuta datu-basean dagoen begiratzeko
		String k1 = "SELECT Nan FROM Erabiltzailea WHERE NAN= '" + nan + " ' ";  
		
		ResultSet emaitza1 = dbk.execSQL(k1);		
		try {
			emaitza1.next();
			if (emaitza1.getRow() == 0){
				//Terapeuta ez dago datu-basean eta honetan sartzen dugu
				String k2 = "INSERT INTO Erabiltzailea VALUES" +
						"(" + izena + "," + pasahitza+ "," + nan+ "," + helbidea 
						+ "," + "'Terapeuta','True') ";
				dbk.execSQL(k2);				
			}else {
				//Terapeuta datu basean dago, honetan egiten dugun bakarra rol
				//atributua aktibo moduan jartzea da
				String k3 = "UPDATE Erabiltzailea SET Aktiboa='true' WHERE Nan=" + nan;
				dbk.execSQL(k3);
			}
			terapeutaOndoSartuDa = new EI_TerapeutaOndoSartuDa();			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
		
	
}
