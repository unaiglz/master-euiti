package kudeatzaileak;

import interfazeak.EI_TerapeutaDatuAldaketa;
import interfazeak.EI_TerapeutaOndoSartuDa;
import interfazeak.EI_Terapeuta_Datuak_Bistaratu;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import datuBaseKonexioa.DBKudeatzaile;

public class TerapeutaKudeatzaile {
	private EI_TerapeutaOndoSartuDa terapeutaOndoSartuDa;
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
	
	/**
	 * Terapeuta datu basean dagoen konprobatuko du, horrela bada bere rola
	 * aktibo bezala jarriko du. Bestalde, ez badago, datu basean sartutako
	 * parametroekin erabiltzaile bat sortuko du.
	 * 
	 * @param izena
	 * @param nan
	 * @param pasahitza
	 * @param helbidea
	 */
		
	public void terapeutaGehitu(String izena, String nan, String pasahitza,
			String helbidea) {
		// Idazkaria identifikatuta dagoela konprobatu behar da lehenengo eta
		// rola boolean
		// bezala hartu da, hau aldatu behar da

		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();

		// Terapeuta datu-basean dagoen begiratzeko
		String k1 = "SELECT NAN FROM Erabiltzailea WHERE NAN= '" + nan + " ' ";

		ResultSet emaitza1 = dbk.execSQL(k1);
		try {
			emaitza1.next();
			if (emaitza1.getRow() == 0) {
				// Terapeuta ez dago datu-basean eta honetan sartzen dugu
				String k2 = "INSERT INTO Erabiltzailea VALUES" + "(" + izena
						+ "," + pasahitza + "," + nan + "," + helbidea + ","
						+ "'Terapeuta','True') ";
				dbk.execSQL(k2);
			} else {
				// Terapeuta datu basean dago, honetan egiten dugun bakarra rol
				// atributua aktibo moduan jartzea da
				String k3 = "UPDATE Erabiltzailea SET Aktiboa='true' WHERE Nan="
						+ nan;
				dbk.execSQL(k3);
			}
			terapeutaOndoSartuDa = new EI_TerapeutaOndoSartuDa();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Idazkariari datu-basean sartuta dauden terapeuta guztiak erakuzten zaizkio,
	 * (aktiboak daudenak, zein ez daudenak) gero honek nahi badu, terapeuta baten gainean klikatu eta bere informazioa
	 * agertuko da. Azkenik, terapeuta horren agenda kontsultau dezake.
	 */
	
	public void terapeutaKontsulta(){
		
		DBKudeatzaile dbk = DBKudeatzaile.getInstantzia();
		
		//Datu-baseko terapeuta guztiak erakusten ditu
		String k1 = "SELECT Nan,Izena FROM Erabiltzailea WHERE rol='terapeuta'";
		ResultSet Emaitza1 = dbk.execSQL(k1);	
		
		try {
			//Terapeuten zerrendan nan eta izenak gordeko dira,hau da, terapeuta 
			//bakoitzeko bi posizio gordeko dira, bat nan zenbakirako eta beste
			//izenerako.
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
	 * Terapeutaren Nan-a jasotzen du parametro moduan 
	 * eta bere agenda itzuli behar du.
	 * @param Nan
	 */
	public void AgendaKontsultatu(String Nan){
		
	}
	
}